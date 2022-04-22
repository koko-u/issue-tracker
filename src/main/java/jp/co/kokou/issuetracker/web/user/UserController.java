package jp.co.kokou.issuetracker.web.user;

import jp.co.kokou.issuetracker.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String showUserList(Model model) {
        model.addAttribute("pageTitle", "User List");
        var userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "users/list";
    }
}
