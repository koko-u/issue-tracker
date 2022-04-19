package jp.co.kokou.issuetracker.domain.auth;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class UserEntity {
    private String username;
    private String password;
}