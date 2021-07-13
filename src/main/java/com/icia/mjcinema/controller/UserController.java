package com.icia.mjcinema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icia.mjcinema.domain.User;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateUserForm;
import com.icia.mjcinema.service.UserService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;

	@GetMapping(value="/login")
	public String login() {
		return "login/Login";
	}

	@PostMapping("/login")
	public String login (@ModelAttribute LoginForm loginForm , BindingResult result , HttpSession session) {
		User user;

		try {
			user = userService.login(loginForm);
		} catch (RuntimeException e) {
			FieldError fieldError = new FieldError("loginForm" , "invalidIdOrPassword" , e.getMessage());
			result.addError(fieldError);
			return "login/Login";
		}

		session.setAttribute("loginMember", user);
		return "redirect:/";
	}

	@GetMapping("/register")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@PostMapping("/register")
	public String join(@ModelAttribute @Valid RegistrationForm joinMemberForm, BindingResult result, HttpSession session) throws IllegalStateException, IOException {
		
		if (result.hasErrors()) {
			
			return "Members/MemberJoinForm";
		}
		User user = userService.join(joinMemberForm);
		session.setAttribute("loginMember", user);
		return "redirect:/";
	}

	@PostMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping (value="/Members/idCheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String username) {
		String result = userService.idCheck(username);
		return result;
	}
		
	
	@RequestMapping (value="/Members/memberView")
	public String memberview(@RequestParam("mid") String mid , Model model) {
		UpdateUserForm member = userService.memberview(mid);
		model.addAttribute("member", member);
		
		return "Members/MemberView";
	}
	
	@RequestMapping (value="/Members/memberlist")
	public String memberlist(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("memberlist", users);
		return "Members/memberlist";
	}

	@RequestMapping (value="/Members/modifyMemberProfile" )
	public String profileModify(@RequestParam("mid") String mid, @RequestParam("mfile") MultipartFile mfile, Model model) throws IllegalStateException, IOException {

		userService.updateProfileImage(mid, mfile);
		model.addAttribute("mid", mid);
		model.addAttribute("mfile", mfile);
		return "redirect:/Members/memberView";
	}

	@RequestMapping (value = "/Members/memberInfo")
	public String MemberListView(@RequestParam("username") String username , Model model){
		UpdateUserForm member = userService.memberListView(username);
		model.addAttribute("member" , member);
		return "/Members/MemberInfo";
	}

	@PostMapping("/users/{username}/delete")
	public String leaveUser(@PathVariable("username") String username) {
		userService.leaveUser(username);

		return "redirect:/";
	}
}
