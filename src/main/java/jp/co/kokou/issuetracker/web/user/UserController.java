package jp.co.kokou.issuetracker.web.user;

import jp.co.kokou.issuetracker.domain.auth.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String showUserList(Model model) {
        model.addAttribute("pageTitle", "User List");
        var alice = new UserEntity(); alice.setUsername("alice");
        var bob = new UserEntity(); bob.setUsername("bob");
        var carol = new UserEntity(); carol.setUsername("carol");
        var diane = new UserEntity(); diane.setUsername("diane");
        var emma = new UserEntity(); emma.setUsername("emma");
        model.addAttribute("userList", List.of(alice, bob, carol, diane, emma));
        return "users/list";
    }
}
