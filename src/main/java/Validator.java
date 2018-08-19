import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Validator {
    public static String alphaValidator(String isAlpha) {
        Scanner scanner = new Scanner(System.in);
        if (StringUtils.isNumeric(isAlpha)) {
            System.out.println("This value should be alphabetical\nPlease provide it once again");
            isAlpha = scanner.nextLine();
            alphaValidator(isAlpha);
        }
        return isAlpha;
    }

    public static String numericValidator(String isNumeric) {
        Scanner scanner = new Scanner(System.in);
        if (StringUtils.isAlpha(isNumeric)) {
            System.out.println("This value should be numeric\nPlease provide it once again");
            isNumeric = scanner.nextLine();
            numericValidator(isNumeric);
        }
        return isNumeric;
    }

}
