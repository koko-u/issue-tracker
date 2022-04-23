package jp.co.kokou.issuetracker.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = OnlyAlphanumericalValidator.class)
@Documented
public @interface OnlyAlphanumerical {

    String message() default "{jp.co.kokou.issuetracker.constraints.OnlyAlphanumerical.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
