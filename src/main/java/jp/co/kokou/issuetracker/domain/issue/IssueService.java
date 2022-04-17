package jp.co.kokou.issuetracker.domain.issue;

import jp.co.kokou.issuetracker.web.issue.IssueForm;

import java.util.List;
import java.util.Optional;

public interface IssueService {
    List<IssueEntity> getAllIssueList();

    void createIssue(IssueForm issueForm);

    Optional<IssueEntity> getIssueById(Long id);
}
