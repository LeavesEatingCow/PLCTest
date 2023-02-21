
import java.util.Scanner;

public class PLCTest {
    public static boolean isValidEmail(String email) {
        String localPartRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(\\.[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+)*$";
        String domainRegex = "^[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
        String[] parts = email.split("@");
        String localPart = parts[0];
        String domain = parts[1];

        if (parts.length != 2) {
            return false;
        }


        if (localPart.length() < 1 || domain.length() < 1) {
            return false;
        }

        if (!localPart.matches(localPartRegex)) {
            return false;
        }

        if (!domain.matches(domainRegex) || domain.startsWith("-") || domain.endsWith("-")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter an e-mail address >> ");
        String email = console.nextLine();

        if(isValidEmail(email)) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}


