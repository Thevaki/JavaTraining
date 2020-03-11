package com.libraryManagementSystem.User.Controller;

import com.libraryManagementSystem.User.Model.User;
import com.libraryManagementSystem.User.SecurityConfig.AuthenticationResponse;
import com.libraryManagementSystem.User.SecurityConfig.JwtUtil;
import com.libraryManagementSystem.User.Service.UserLoginService;
import com.libraryManagementSystem.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserLoginService userLoginService;

    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails =
                userLoginService.loadUserByUsername(user.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt) {
        });
    }

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
