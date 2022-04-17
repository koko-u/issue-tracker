package jp.co.kokou.issuetracker.web.issue;

import jp.co.kokou.issuetracker.domain.issue.IssueService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
@Slf4j
public class IssueController {

    @NonNull
    private final IssueService issueService;

    private final String pageTitle = "pageTitle";

    @GetMapping("")
    public String showIssueList(Model model) {
        var issueList = issueService.getAllIssueList();
        model.addAttribute("issueList", issueList);
        model.addAttribute(pageTitle, "Issue List");
        return "issues/list";
    }

    @GetMapping("/create")
    public String showForm(@ModelAttribute("issueForm") IssueForm issueForm, Model model) {
        model.addAttribute(pageTitle, "Create Issue");
        return "issues/create";
    }

    @PostMapping("/create")
    public String createIssue(
            @Validated IssueForm issueForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return showForm(issueForm, model);
        }
        issueService.createIssue(issueForm);
        return "redirect:/issues";
    }

    @GetMapping("/{id}")
    public String showIssueDetail(@PathVariable("id") Long id, Model model) {
        return issueService.getIssueById(id).map(issue -> {
            model.addAttribute(pageTitle, "Issue Detail");
            model.addAttribute("issue", issue);
            return "issues/detail";
        }).orElse("redirect:/issues");
    }
}
