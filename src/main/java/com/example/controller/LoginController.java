package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		ModelAndView modelAndView = null;
		User user = service.findUser(username, password);

		if (user != null) {
			modelAndView = new ModelAndView("welcome.jsp");
			modelAndView.addObject("username", user.getUsername());
			modelAndView.addObject("gender", user.getGender());

			String date = service.getLastLogin(user.getUsername()); //get last_login from db
			
			modelAndView.addObject("last_login", date);
			
			Date newLogin = service.getLocalDate();
			
			service.updateUser(newLogin, user.getUsername()); //update last_login

		} else {
			modelAndView = new ModelAndView("login.jsp");
			modelAndView.addObject("msg", "Errore! Credenziali non valide.");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutUser() {
		ModelAndView modelAndView = new ModelAndView("login.jsp");
		modelAndView.addObject("msg", "Hai effettuato il logout.");

		return modelAndView;

	}
}
