package tmarshal.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tmarshal.model.User;
import tmarshal.server.service.UserService;

@Controller
@RequestMapping("/user/{id}")
public class UserController {

    @Autowired
    private UserService userService;
    SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value="id") String id) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User specifiedUser = userService.findById(id);
        if (auth.getName().equals(specifiedUser.getUserName()) || auth.getAuthorities().contains(ADMIN_AUTHORITY)) {
            return userService.findById(id);
        } else {
            throw new Exception("Get out!!!!");
        }
    }
}
