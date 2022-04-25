package jp.co.kokou.issuetracker.constraints;

import jp.co.kokou.issuetracker.dao.user.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
@Slf4j
public class UniqueKeyValidator implements ConstraintValidator<UniqueKey, Object> {

    private final UserDao userDao;

    private String columnName;

    @Override
    public void initialize(UniqueKey constraintAnnotation) {
        columnName = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean isValid;

        try {
            var field = value.getClass().getDeclaredField(columnName);
            field.setAccessible(true);
            var columnValue = (String)field.get(value);

            isValid = userDao.countBy(columnName, columnValue) == 0;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            isValid = true;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                            context.getDefaultConstraintMessageTemplate()
                    )
                    .addPropertyNode(columnName)
                    .addConstraintViolation();
        }


        return isValid;
    }
}
