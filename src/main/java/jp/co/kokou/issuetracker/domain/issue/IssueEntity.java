package jp.co.kokou.issuetracker.domain.issue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "issues")
public class IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;

    public IssueEntity() {
    }

    public IssueEntity(String summary, String description) {
        this.summary = summary;
        this.description = description;
    }
}
