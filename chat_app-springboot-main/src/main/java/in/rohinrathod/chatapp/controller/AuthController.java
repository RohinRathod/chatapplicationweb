package in.rohinrathod.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rohinrathod.chatapp.Entity.UserDto;
import in.rohinrathod.chatapp.service.UserService;

@RestController
public class AuthController {

	@Autowired
	public UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(UserDto userDto) {

		userDto.setRole("ROLE_USER");
		if (userService.findByUsername(userDto.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
		}

		// Proceed to register the new user
		boolean success = userService.registerUser(userDto);
		if (success) {
			return ResponseEntity.ok("Registration successful");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
		}
	}

}
