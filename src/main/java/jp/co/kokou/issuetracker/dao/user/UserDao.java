package jp.co.kokou.issuetracker.dao.user;

import jp.co.kokou.issuetracker.domain.user.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<UserEntity> selectByUsername(String username);

    @Select
    List<UserEntity> selectAll();
}
