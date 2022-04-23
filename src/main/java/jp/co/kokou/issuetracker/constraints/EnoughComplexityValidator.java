package jp.co.kokou.issuetracker.constraints;

import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.resources.ConfigurationBuilder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnoughComplexityValidator implements ConstraintValidator<EnoughComplexity, String> {

    private final Nbvcxz nbvcxz;

    public EnoughComplexityValidator() {
        this.nbvcxz = new Nbvcxz();
    }

    @Override
    public void initialize(EnoughComplexity constraintAnnotation) {
        var entropy = constraintAnnotation.value().entropy();
        var configuration = new ConfigurationBuilder()
                .setMinimumEntropy(entropy)
                .createConfiguration();
        this.nbvcxz.setConfiguration(configuration);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        var result = nbvcxz.estimate(value);
        return result.isMinimumEntropyMet();
    }
}
