package day2.salary;

public class SalaryOprations {

    String name;
    int salary;
    int year;

    public  SalaryOprations(String n, int s, int y){
        name = n;
        salary = s;
        year = y;
    }

    public int calculateAniualSalary(){
        return salary * 12;
    }

    public int calculateServiceYear(){
        return 2024 - year;
    }
}
