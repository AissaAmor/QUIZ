package spring.session.testBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.testBackEnd.Configuration.BCryptManagerUtil;
import spring.session.testBackEnd.Configuration.JwtTokenUtil;
import spring.session.testBackEnd.entities.JwtResponse;
import spring.session.testBackEnd.entities.User;
import spring.session.testBackEnd.repository.UserRepository;
import spring.session.testBackEnd.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addCoach(@RequestBody User user) {
		user.setPassword(BCryptManagerUtil.passwordEncoder().encode(user.getPassword()));
		userservice.AjoutUser(user);
	}
	
	public boolean comparePassword(String requestPass, String currentPassword) {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		if (passencoder.matches(requestPass,currentPassword)) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(path = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

		
		User userdetails = userservice.loadByUsername(authenticationRequest.getUsername());
		String reqPassword = authenticationRequest.getPassword();
		String currentPass = userdetails.getPassword();
		if (comparePassword(reqPassword, currentPass)) {
			System.out.println("valid" + "/" + userdetails.getPassword());
			final String token = jwtTokenUtil.generateToken(userdetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} else {
			System.out.println("invalid" + "/" + reqPassword + "/" + currentPass);
			return ResponseEntity.ok(null);
		}
	}
}
