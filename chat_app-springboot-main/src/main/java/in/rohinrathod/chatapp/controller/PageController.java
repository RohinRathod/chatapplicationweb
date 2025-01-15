package in.rohinrathod.chatapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class PageController {

	@GetMapping("/register")
	public String registerPage() {
		return "register"; // Render the registration page (register.html)
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/chat")
	public String chatPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		model.addAttribute("username", username);
		return "chat";
	}

}
