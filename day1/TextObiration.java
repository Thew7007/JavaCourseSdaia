package day1;

public class TextObiration
{
    public static void main(String[] args) {

        String x = "nice";
        String phone = "0540701733";
        String email = "a@gamil.com";

        System.out.println(x.charAt(1));
        System.out.println(x.length());

        char b = email.charAt(1);
        System.out.println(b);

        char g = phone.charAt(1);
        System.out.println(g);


        System.out.println(email.toUpperCase());

        System.out.println(email.endsWith(".com"));
        System.out.println(x.contains("z"));


        char grad = 'A';
        System.out.println(Character.isUpperCase(grad));
        System.out.println(Character.isLetter(grad));
        System.out.println(Character.isDigit(grad));


    }
}
