package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.service.memberService;


@Controller
public class memberController {

	@RequestMapping(value="/Members/Login")
	public String main() throws IllegalStateException, IOException  { 
		return "Members/Login";
	}

	
}
