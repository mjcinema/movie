package com.icia.mjcinema.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icia.mjcinema.domain.User;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;

	@GetMapping(value="/login")
	public String login() {
		return "login/Login";
	}


	@GetMapping("/register")
	public String registrationForm() {
		return "register/register";
	}
	//회원가입
	@PostMapping("/register")
	public String join(@ModelAttribute @Valid RegistrationForm joinMemberForm, BindingResult result, HttpSession session) throws IllegalStateException, IOException {
		
		if (result.hasErrors()) {
			
			return "register/register";
		}
		User user = userService.join(joinMemberForm);
		session.setAttribute("loginMember", user);
		return "redirect:/";
	}

	
	@RequestMapping ("/idCheck")
	public @ResponseBody String idCheck(@RequestParam("username") String username) {
		return userService.idCheck(username);
	}
		
	//회원정보
	@GetMapping ("/user")
	public String user(@RequestParam("username") String username, Model model) {
		UpdateUserForm user = userService.user(username);
		model.addAttribute("user", user);
		return "users/user";
	}
	//회원목록
	@GetMapping ("/userList")
	public String userlist(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("userlist", users);
		return "users/userList";
	}

	// todo updateProfileImage
	@RequestMapping (value="/Members/modifyMemberProfile" )
	public String profileModify(@RequestParam("username") String mid, @RequestParam("mfile") MultipartFile mfile, Model model) throws IllegalStateException, IOException {

		userService.updateProfileImage(mid, mfile);
		model.addAttribute("mid", mid);
		model.addAttribute("mfile", mfile);
		return "redirect:/profile";
	}
	//내 정보 보기
	@GetMapping("/profile")
	public String userList(Model model, Principal principal){

		principal.getName();
		User user = userService.getUserByUsername(principal.getName());
		model.addAttribute("user" , UpdateUserForm.fromMember(user));
		return "users/profile";
	}
	//유저 삭제
	@PostMapping("/users/{username}/delete")
		public String leaveUser(@PathVariable("username") String username) {
		userService.leaveUser(username);

		return "redirect:/userList";
	}
	//회원 수정 get
	@GetMapping("/edit")
	public String userEditForm(@RequestParam("username")String username, Model model)throws IllegalStateException, IOException{
	model.addAttribute(username);
	return "/users/edit";

	}

	//회원 수정 post
	@PostMapping("/users/{username}/edit")
	public String updateUser(@PathVariable("username")String username , UpdateUserForm form , Model model){
		User user = UpdateUserForm.toUser(form);
		// form -> User;
		userService.updateUser(user); //dto User
		return "redirect:/profile";


	}




}
