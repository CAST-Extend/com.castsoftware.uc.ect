package com.castsoftware.ect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public static String frame(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/login/?logout")
	public static String logout(Model model) {
		return "login";
	}
	
}
