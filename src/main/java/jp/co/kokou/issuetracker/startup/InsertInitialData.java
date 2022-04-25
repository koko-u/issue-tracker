package jp.co.kokou.issuetracker.startup;

import jp.co.kokou.issuetracker.dao.user.UserDao;
import jp.co.kokou.issuetracker.domain.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Profile("dev")
public class InsertInitialData implements ApplicationListener<ApplicationReadyEvent> {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final List<UserEntity> initialUserList;

    public InsertInitialData(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.initialUserList = new ArrayList<>();
        var alice = new UserEntity();
        alice.setUsername("alice");
        alice.setPassword(this.passwordEncoder.encode("alice"));
        this.initialUserList.add(alice);
        var bob = new UserEntity();
        bob.setUsername("bob");
        bob.setPassword(this.passwordEncoder.encode("bob"));
        this.initialUserList.add(bob);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initialUserList.forEach(user -> userDao.deleteByUsername(user.getUsername()));
        initialUserList.forEach(userDao::insert);
    }
}
