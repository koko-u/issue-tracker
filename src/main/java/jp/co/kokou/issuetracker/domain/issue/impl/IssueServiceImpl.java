package jp.co.kokou.issuetracker.domain.issue.impl;

import jp.co.kokou.issuetracker.dao.issue.IssueDao;
import jp.co.kokou.issuetracker.domain.issue.IssueEntity;
import jp.co.kokou.issuetracker.domain.issue.IssueService;
import jp.co.kokou.issuetracker.web.issue.IssueForm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    @NonNull
    private final IssueDao issueDao;

    @Override
    public List<IssueEntity> getAllIssueList() {
        return issueDao.selectAll(SelectOptions.get());
    }

    @Override
    @Transactional
    public void createIssue(IssueForm issueForm) {
        var issueEntity = new IssueEntity(issueForm.getSummary(), issueForm.getDescription());
        issueDao.insert(issueEntity);
    }

    @Override
    public Optional<IssueEntity> getIssueById(Long id) {
        return issueDao.selectById(id);
    }
}
