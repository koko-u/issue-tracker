package jp.co.kokou.issuetracker.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OnlyAlphanumericalValidator implements ConstraintValidator<OnlyAlphanumerical, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.codePoints().allMatch(OnlyAlphanumericalValidator::isAlphaNumeric);
    }

    private static boolean isAlphaNumeric(int codePoint) {
        return switch (Character.getType(codePoint)) {
            case Character.UPPERCASE_LETTER,
                 Character.LOWERCASE_LETTER,
                 Character.TITLECASE_LETTER,
                 Character.DECIMAL_DIGIT_NUMBER -> true;
            default -> false;
        };
    }
}
