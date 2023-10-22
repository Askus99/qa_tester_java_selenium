package firstProgram;

import java.util.Scanner;

public class FirstProgram {
    public static void main(String[] args) {
        String password = prompt("Enter password: ");
        String validPassword = "password";
        if (password.equals(validPassword)){
            System.out.println("AH");
        }else{
            System.out.println("Nope");
        }
        System.out.println("end of program");
    }

    private static String prompt(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(s);
        return scanner.nextLine();
    }
}
