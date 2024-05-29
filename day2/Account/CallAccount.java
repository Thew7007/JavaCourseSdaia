package day2.Account;

public class CallAccount {

    public static void main(String[] args) {
        Account a1 = new Account("Abdullah", 5132);
        Account a2 = new Account("Abdulrhman", 415.512);

        a1.getMonthlyRate();

        System.out.println(a1.name);
        System.out.println(a1.getBalance());
        System.out.println(a1.getMonthlyRate());
        System.out.println(a1.getMonthlyIntrest());
        System.out.println("_______________________");
        System.out.println(a2.name);
        System.out.println(a2.getBalance());
        System.out.println(a2.getMonthlyRate());
        System.out.println(a2.getMonthlyIntrest());
    }
}
