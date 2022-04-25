package jp.co.kokou.issuetracker.dao.user;

import jp.co.kokou.issuetracker.domain.user.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.SelectBuilder;

import java.util.List;
import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserDao {

    @Select
    Optional<UserEntity> selectByUsername(String username);

    default long countBy(String key, String value) {
        var config = Config.get(this);
        var builder = SelectBuilder.newInstance(config);
        builder
                .sql("SELECT COUNT(*) FROM users WHERE " + key + " = ")
                .literal(String.class, value);
        return builder.getScalarSingleResult(Long.class);
    }

    @Select
    List<UserEntity> selectAll();

    @Insert
    int insert(UserEntity user);

    @Delete(sqlFile = true)
    int deleteByUsername(String username);
}
