package code.conrtollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class htmlController {

    @GetMapping({"/login", "/"})
    public String login() {
        return "html/login.html";
    }

    @GetMapping({"/main"})
    public String mainPage() {
        return "html/main.html";
    }
}