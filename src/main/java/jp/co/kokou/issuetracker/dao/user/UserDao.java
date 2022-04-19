package jp.co.kokou.issuetracker.dao.user;

import jp.co.kokou.issuetracker.domain.auth.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<UserEntity> selectByUsername(String username);
}
