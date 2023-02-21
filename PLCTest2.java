import java.util.Scanner;

public class PLCTest2 {
    public static boolean isValidIntegerConstant(String input) {
        input = input.trim();

        if (input.isEmpty()) {
            return false;
        }

        if (input.startsWith("0x") || input.startsWith("0X")) {
            String hex = input.substring(2);
            if (hex.endsWith("I64") || hex.endsWith("Ui64")) {
                hex = hex.substring(0, hex.length() - 3);
            }
            return hex.matches("[0-9a-fA-F]+");
        }

        if (input.startsWith("0")) {
            String oct = input.substring(1);
            if (oct.endsWith("u") || oct.endsWith("l")) {
                oct = oct.substring(0, oct.length() - 1);
            }
            return oct.matches("[0-7]+");
        }

        if (input.endsWith("u") || input.endsWith("l")) {
            input = input.substring(0, input.length() - 1);
        }
        return input.matches("[0-9]+");
    }


    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter an integer >> ");
        String input = console.nextLine();
        if (isValidIntegerConstant(input)) {
            System.out.println(input + " is a valid integer constant.");
        } else {
            System.out.println(input + " is not a valid integer constant.");
        }
    }
}
