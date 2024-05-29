package day2.salary;

public class CallSalaryOpi {

    public static void main(String[] args) {

        SalaryOprations x = new SalaryOprations("Abdullah", 35000, 2016);
        SalaryOprations y = new SalaryOprations("Abdulrhman", 50000, 2023);

        System.out.println(x.name);
        System.out.println(x.calculateAniualSalary());
        System.out.println(x.calculateServiceYear());
        System.out.println("______________________________");
        System.out.println(y.name);
        System.out.println(y.calculateAniualSalary());
        System.out.println(y.calculateServiceYear());
    }
}
