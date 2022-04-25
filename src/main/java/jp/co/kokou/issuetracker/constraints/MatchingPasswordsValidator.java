package jp.co.kokou.issuetracker.constraints;

import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

public class MatchingPasswordsValidator implements ConstraintValidator<MatchingPasswords, Object> {
    @Override
    public void initialize(MatchingPasswords constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        Field passwordField = null;
        Field passwordConfirmField = null;
        for (var field : value.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MatchingPasswords.Password.class) &&
                passwordField == null) {
                passwordField = field;
            }
            if (field.isAnnotationPresent(MatchingPasswords.PasswordConfirm.class) &&
                passwordConfirmField == null) {
                passwordConfirmField = field;
            }
        }

        boolean isValid;

        if (passwordField == null || passwordConfirmField == null) {
            isValid = false;
        } else {
            isValid = Objects.equals(
                    getStringValue(passwordField, value),
                    getStringValue(passwordConfirmField, value)
            );
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    context.getDefaultConstraintMessageTemplate()
            )
                    .addPropertyNode(passwordConfirmField.getName())
                    .addConstraintViolation();
        }

        return isValid;
    }

    @SneakyThrows
    private static String getStringValue(Field field, Object obj) {
        field.setAccessible(true);
        return (String)field.get(obj);
    }
}
