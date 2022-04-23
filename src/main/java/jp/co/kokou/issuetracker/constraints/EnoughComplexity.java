package jp.co.kokou.issuetracker.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = EnoughComplexityValidator.class)
@Documented
public @interface EnoughComplexity {

    String message() default "{jp.co.kokou.issuetracker.constraints.EnoughComplexity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    PasswordComplexity value() default PasswordComplexity.NormalStrength;
}
