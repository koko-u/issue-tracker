package jp.co.kokou.issuetracker.dao.issue;

import jp.co.kokou.issuetracker.domain.issue.IssueEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface IssueDao {
    @Select
    List<IssueEntity> selectAll(SelectOptions options);

    @Select
    Optional<IssueEntity> selectById(Long id);

    @Insert
    int insert(IssueEntity issueEntity);
}
