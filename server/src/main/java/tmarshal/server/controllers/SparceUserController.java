package tmarshal.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tmarshal.model.SparceUser;
import tmarshal.server.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping("/sparce-user/{id}")
public class SparceUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody SparceUser getSparceUser(@PathVariable(value="id") String id) throws Exception {
        return new SparceUser(userService.findById(id));
    }
}