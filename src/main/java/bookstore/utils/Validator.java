package bookstore.utils;

import org.apache.commons.lang3.StringUtils;

public class Validator {
    public static String alphaValidator(String isAlpha) {
        if (StringUtils.isNumeric(isAlpha)) {
            System.out.println("This value should be alphabetical\nPlease provide it once again");
            isAlpha = UserInput.scanner.nextLine();
            return alphaValidator(isAlpha);
        }
        return isAlpha;
    }

    public static String numericValidator(String isNumeric) {
        if (StringUtils.isAlpha(isNumeric)) {
            System.out.println("This value should be numeric\nPlease provide it once again");
            isNumeric = UserInput.scanner.nextLine();
            return numericValidator(isNumeric);
        }
        return isNumeric;
    }
}
