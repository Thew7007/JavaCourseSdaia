package org.example.controller;

import org.example.dao.JobDAO;
import org.example.dto.JobDto;
import org.example.mappers.JobMapper;
import org.example.models.Job;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.inject.Inject;
import java.net.URI;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

@Path("/jobs")
public class JobController {

    
    private JobDAO dao = new JobDAO();

    @Context
    private UriInfo uriInfo;

    @Context
    private HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllJobs(
            @HeaderParam("Authorization") String authorizationHeader,
            @CookieParam("JSESSIONID") Cookie sessionId) {
        try {
            ArrayList<Job> jobList = dao.selectAlljobs();
            ArrayList<JobDto> jobDtoList = new ArrayList<>();
            for (Job job : jobList) {
                jobDtoList.add(JobMapper.toDto(job));
            }
            GenericEntity<ArrayList<JobDto>> jobs = new GenericEntity<ArrayList<JobDto>>(jobDtoList) {};
            String responseType = determineResponseType();
            return Response.ok(jobs, responseType).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                          .entity("An error occurred while fetching the jobs.")
                          .build();
        }
    }

    @GET
    @Path("{jobId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getJob(
            @HeaderParam("Authorization") String authorizationHeader,
            @CookieParam("JSESSIONID") Cookie sessionId,
            @PathParam("jobId") int jobId) {
        try {
            Job job = dao.selectJob(jobId);
            if (job == null) {
                throw new Exception("Job " + jobId + " not found");
            }
            JobDto jobDto = JobMapper.toDto(job);
            return Response.ok(jobDto).build();
        } catch (DataFormatException e) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity(e.getMessage())
                           .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("An error occurred while fetching the job.")
                           .build();
        }
    }

    @DELETE
    @Path("{jobId}")
    public Response deleteJob(
            @CookieParam("JSESSIONID") Cookie sessionId,
            @PathParam("jobId") int jobId) {
        try {
            dao.deletejob(jobId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("An error occurred while deleting the job.")
                           .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertJob(JobDto jobDto) {
        try {
            Job job = JobMapper.toEntity(jobDto);
            dao.insertJob(job);
            URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(job.getJobId())).build();
            return Response.created(uri).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("An error occurred while inserting the job.")
                           .build();
        }
    }

    @PUT
    @Path("{jobId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateJob(@PathParam("jobId") int jobId, JobDto jobDto) {
        try {
            Job job = JobMapper.toEntity(jobDto);
            job.setJobId(jobId);
            dao.updateJob(job);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("An error occurred while updating the job.")
                           .build();
        }
    }

    private String determineResponseType() {
        if (headers.getAcceptableMediaTypes().contains(MediaType.APPLICATION_XML)) {
            return MediaType.APPLICATION_XML;
        }
        return MediaType.APPLICATION_JSON;
    }
}
