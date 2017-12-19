package tmarshal.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tmarshal.model.SparseUser;
import tmarshal.server.exceptions.UnauthorizedAccessException;
import tmarshal.server.service.SparseUserService;

import java.util.Collection;

@Controller
@RequestMapping("/sparseUsers")
public class SparseUserController {

    @Autowired
    private SparseUserService sparseUserService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Collection<SparseUser> getSparseUsers() throws UnauthorizedAccessException {
        System.out.println("Called sparseUsers");
        return sparseUserService.getAllSparseUsers();
    }
}
