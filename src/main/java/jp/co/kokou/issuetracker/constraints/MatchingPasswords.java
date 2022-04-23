package jp.co.kokou.issuetracker.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MatchingPasswordsValidator.class)
public @interface MatchingPasswords {

    String message() default "{jp.co.kokou.issuetracker.constraints.MatchingPasswords.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ FIELD, METHOD})
    @Retention(RUNTIME)
    @Documented
    public @interface Password {
    }
    @Target({ FIELD, METHOD})
    @Retention(RUNTIME)
    @Documented
    public @interface PasswordConfirm {
    }
}
