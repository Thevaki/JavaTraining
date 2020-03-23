package com.libraryManagementSystem.User.Controller;

import com.libraryManagementSystem.User.Model.AuthenticationRequest;
import com.libraryManagementSystem.User.Model.AuthenticationResponse;
import com.libraryManagementSystem.User.Model.User;
import com.libraryManagementSystem.User.Service.JwtUserService;
import com.libraryManagementSystem.User.Service.UserService;
import com.libraryManagementSystem.User.filters.JwtRequestFilter;
import com.libraryManagementSystem.User.util.JwtUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/User")
@XmlRootElement
public class UserController {

    @Autowired
    private JwtUserService jwtUserService;
    
    @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
    
    @RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);//user input
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = jwtUserService
				.loadUserByUsername(authenticationRequest.getUsername()); //user name in db.. so user name shpould be PK

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}

//@EnableWebSecurity
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService myUserDetailsService;
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(myUserDetailsService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable()
//				.authorizeRequests().antMatchers("/User/authenticate").permitAll().
//						anyRequest().authenticated().and().
//						exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//	}
//
//}
