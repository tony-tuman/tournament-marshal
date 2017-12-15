package tmarshal.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tmarshal.model.SparseUser;
import tmarshal.server.exceptions.UnauthorizedAccessException;
import tmarshal.server.service.SparseUserService;

@Controller
@RequestMapping("/sparse-user/{userName}")
public class SparseUserController {

    @Autowired
    private SparseUserService sparseUserService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody SparseUser getSparseUser(@PathVariable(value="userName") String userName) throws UnauthorizedAccessException {
        return sparseUserService.getUserByName(userName);
    }
}
