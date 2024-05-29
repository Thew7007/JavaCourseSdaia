package day2.Student;

public class CallStudent {

    public static void main(String[] args) {

        var s1 = new Student("Ali", 15);
        var s2 = new Student("Abdulrhman", 23);

        Student.fullMark = 25;
        // get set example *_*
        s1.serMark(-25);

        System.out.println(s1.name);
        System.out.println(s1.getPersent());
        System.out.println(s1.getGrade());
        System.out.println("________________________");
        System.out.println(s2.name);
        System.out.println(s2.getPersent());
        System.out.println(s2.getGrade());
    }
}
