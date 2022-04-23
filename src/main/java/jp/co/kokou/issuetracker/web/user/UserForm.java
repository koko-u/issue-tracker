package jp.co.kokou.issuetracker.web.user;

import jp.co.kokou.issuetracker.constraints.EnoughComplexity;
import jp.co.kokou.issuetracker.constraints.MatchingPasswords;
import jp.co.kokou.issuetracker.constraints.OnlyAlphanumerical;
import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@MatchingPasswords
public class UserForm {
    @NotBlank
    @OnlyAlphanumerical
    private String username;

    @ToString.Exclude
    @NotBlank
    @EnoughComplexity
    @MatchingPasswords.Password
    private String password;

    @ToString.Exclude
    @NotBlank
    @MatchingPasswords.PasswordConfirm
    private String passwordConfirm;
}
