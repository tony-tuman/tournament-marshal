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
import tmarshal.server.exceptions.UnauthorizedAccessException;
import tmarshal.server.service.UserService;

@Controller
@RequestMapping("/user/{id}")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value="id") String id) throws UnauthorizedAccessException {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable(value="id") String id) throws UnauthorizedAccessException {
        userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody void deleteUser(@PathVariable(value="user") User user) throws UnauthorizedAccessException {
        userService.addUser(user);
    }
}
