package com.libraryManagementSystem.User.Controller;

import com.libraryManagementSystem.User.Model.User;
import com.libraryManagementSystem.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/User")
@XmlRootElement
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/createUser" , method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/editUserDetails",method = RequestMethod.PUT)
    public User editUser(@RequestBody User user){return userService.editUserDetails(user);}

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id") Integer id){return userService.deleteUser(id);}

    @RequestMapping(value="/findUserById/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    @RequestMapping(value="/fetchAllUsers",method = RequestMethod.GET)
    public List<User> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

}
