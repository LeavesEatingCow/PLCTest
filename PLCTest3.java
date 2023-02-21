import java.util.Scanner;
public class PLCTest3 {
    public static boolean isValidSignedReal(String str) {
        str = str.trim();

        char suffix = str.charAt(str.length() - 1);
        if (!(suffix == 'f' || suffix == 'F' || suffix == 'l' || suffix == 'L')) {
            suffix = '\0';
        }

        if (suffix != '\0') {
            str = str.substring(0, str.length() - 1);
        }

        int exponentIndex = str.indexOf('e');
        if (exponentIndex == -1) {
            exponentIndex = str.indexOf('E');
        }
        if (exponentIndex != -1) {
            String mantissaStr = str.substring(0, exponentIndex);
            String exponentStr = str.substring(exponentIndex + 1);

            boolean mantissaValid = isValidSignedReal(mantissaStr);
            boolean exponentValid = true;
            if (exponentStr.length() > 0) {
                char firstChar = exponentStr.charAt(0);
                if (firstChar == '-' || firstChar == '+') {
                    exponentStr = exponentStr.substring(1);
                }
                exponentValid = isValidSignedInteger(exponentStr);
            }

            return mantissaValid && exponentValid;
        }

        int decimalIndex = str.indexOf('.');
        if (decimalIndex == -1) {
            return false;
        }

        String integerStr = str.substring(0, decimalIndex);
        String fractionalStr = str.substring(decimalIndex + 1);
        if (integerStr.isEmpty() && fractionalStr.isEmpty()) {
            return false;
        }

        boolean integerValid = true;
        boolean fractionalValid = true;
        if (!integerStr.isEmpty()) {
            integerValid = isValidSignedInteger(integerStr);
        }
        if (!fractionalStr.isEmpty()) {
            fractionalValid = isValidUnsignedInteger(fractionalStr);
        }

        return integerValid && fractionalValid;
    }

    public static boolean isValidSignedInteger(String str) {
        if (str.isEmpty()) {
            return false;
        }
        int startIndex = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            startIndex = 1;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidUnsignedInteger(String str) {
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a number >> ");
        String input = console.nextLine();

        if (isValidSignedReal(input)) {
            System.out.println(input + " is a valid signed number.");
        } else {
            System.out.println(input + " is not a valid signed number.");
        }
    }

}
