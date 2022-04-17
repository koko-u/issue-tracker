package jp.co.kokou.issuetracker.web.issue;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public final class IssueForm {
    @NonNull
    @NotBlank
    @Size(max = 256)
    private String summary;

    @Size(max = 1000)
    private String description;

    public IssueForm() {
        this("", "");
    }

    public IssueForm(String summary) {
        this(summary, "");
    }
}
