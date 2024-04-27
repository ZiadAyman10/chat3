package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// Other imports...

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private PersonService personService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // Autowire the BCryptPasswordEncoder bean

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Return the login form view
    }

    @GetMapping("/login/{username}/{password}")
    public String processLogin(@PathVariable String username, @PathVariable String password, HttpServletRequest request) {
        // Validate username and password
        Person user = personService.getPerson(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Login successful - create a secure session, etc.
            HttpSession session = request.getSession(true); // Create a new session if none exists
            session.setAttribute("user", user); // Store user information in the session
            String test="/api/person/"+user.getId();
            return test; // Redirect to chat page after successful login
        } else {
            // Login failed - handle invalid credentials (without revealing details)
            return "/api/login"; // Return login form with a generic error message
        }
    }
}
