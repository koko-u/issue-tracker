package jp.co.kokou.issuetracker.constraints;

import lombok.extern.slf4j.Slf4j;
import me.gosimple.nbvcxz.Nbvcxz;
import me.gosimple.nbvcxz.resources.ConfigurationBuilder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
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
        log.debug("Basic Score: {}", result.getBasicScore());
        log.debug("Warning: {}", result.getFeedback().getWarning());
        log.debug("Suggestion: {}", result.getFeedback().getSuggestion());
        return result.isMinimumEntropyMet();
    }
}
