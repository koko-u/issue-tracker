package jp.co.kokou.issuetracker.constraints;

public enum PasswordComplexity {
    FairStrength(30d),
    NormalStrength(35d),
    SufficientStrength(40d);

    private final double value;
    PasswordComplexity(double entropy) {
        this.value = entropy;
    }

    public double entropy() {
        return value;
    }
}
