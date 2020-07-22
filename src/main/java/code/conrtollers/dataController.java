package code.conrtollers;

import code.POJO.SmallUserInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import code.entities.User;
import code.repo.UserRepo;

@RestController
public class dataController {

    @Autowired
    UserRepo userRepo;


    // Переделать под POST

    @GetMapping("/getUserInfo")
    public User getFullUserInfo(@AuthenticationPrincipal User user) {
        return user;
    }
    @GetMapping("/user")
    public Iterable<User> getUser() {
        return userRepo.findAll();
    }

    @GetMapping("/getSmallUserInfo")
    public SmallUserInfo getSmallUserInfo(@AuthenticationPrincipal User user) {
        return new SmallUserInfo(user.getName(), user.getUserPic());
    }
}
