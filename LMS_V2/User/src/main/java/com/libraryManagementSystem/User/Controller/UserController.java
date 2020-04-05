package com.libraryManagementSystem.User.Controller;

import com.libraryManagementSystem.User.Model.AppUser;
import com.libraryManagementSystem.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/User")
@XmlRootElement
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private Environment env;

    //@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    @RequestMapping(value = "/createUser" , method = RequestMethod.POST)
    public AppUser createUser(@RequestBody AppUser user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/editUserDetails",method = RequestMethod.PUT)
    public AppUser editUser(@RequestBody AppUser user){return userService.editUserDetails(user);}

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public AppUser deleteUser(@PathVariable("id") Integer id){return userService.deleteUser(id);}

    @RequestMapping(value="/findUserById/{id}",method = RequestMethod.GET)
    public AppUser findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping(value="/fetchAllUsers",method = RequestMethod.GET)
    public List<AppUser> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping("/admin/home")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }

}
