package jp.co.kokou.issuetracker.web.user;

import jp.co.kokou.issuetracker.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public String showUserList(Model model) {
        model.addAttribute("pageTitle", "User List");
        var userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "users/list";
    }

    @GetMapping("/create")
    public String showForm(@ModelAttribute("userForm") UserForm userForm, Model model) {
        model.addAttribute("pageTitle", "Create User");
        return "users/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
        log.debug("{}", userForm);
        if (bindingResult.hasErrors()) {
            return showForm(userForm, model);
        }
        return "redirect:/users";
    }
}
