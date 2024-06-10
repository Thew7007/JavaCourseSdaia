package org.example.mappers;

import org.example.dto.JobDto;
import org.example.models.Job;
import org.mapstruct.Mapper;

@Mapper
public interface JobMapper {

    
    public static JobDto toDto(Job job) {
        if (job == null) {
            return null;
        }
        JobDto dto = new JobDto();
        dto.setJobId(job.getJobId());
        dto.setJobTitle(job.getTitle());
        dto.setMinSalary(job.getMinSalary());
        dto.setMaxSalary(job.getMaxSal());
        
        return dto;
    }

    
    public static Job toEntity(JobDto dto) {
        if (dto == null) {
            return null;
        }
        Job job = new Job();
        job.setJobId(dto.getJobId());
        job.setTitle(dto.getJobTitle());
        job.setMinSalary(dto.getMinSalary());
        job.setMaxSal(dto.getMaxSalary());
        // Add other transformations if necessary
        return job;
    }
}

