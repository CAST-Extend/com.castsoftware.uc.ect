package com.castsoftware.ect.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castsoftware.ect.model.AADApplication;
import com.castsoftware.ect.model.AADPortal;


@Controller
public class LoginController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/login")
	public String frame(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/login/?logout")
	public String logout(Model model) {
		return "login";
	}
	
}
