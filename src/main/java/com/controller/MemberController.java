package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Member;
import com.service.impl.MemberServiceImpl;
import com.util.HashPassword;

@Controller
@SessionAttributes("member")
public class MemberController {

	private String url = "";

	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model,@RequestParam(value="message",required = false) String message) {
		
		if(message!="") {
			model.addAttribute("message", message);
		}
		model.addAttribute("member", new Member());

		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveMember(@ModelAttribute("member") Member member, Model model) {

		if (member != null) {
			try {
				member.setPassword(HashPassword.hash(member.getPassword()));
				memberServiceImpl.saveOrUpdate(member);
				url = "login";
			} catch (Exception e) {
				model.addAttribute("message", "That member already exists on the system");
				url = "redirect:/register";
			}
			
		} else {
			// if member is null then return register page
			model.addAttribute("message", "Resgister fail...!");
			url = "redirect:/register";
		}

		return url;
	}

	@RequestMapping(value = { "/", "/home", "/welcome" }, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		if (member==null) {
			return "login";
		}else {
			if(member.getUserName()!=null) {
				return "welcome";
			}
			return "login";
		}
		
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String loginSuccess(@RequestParam("userName") String username, @RequestParam("password") String password,
			Model model,HttpServletRequest request, HttpSession session) {
		if (username != "" && password != "") {
			Member member = memberServiceImpl.getMemberByUsername(username);
			//if member valid -> welcome page
			if (username.equals(member.getUserName()) && HashPassword.hash(password).equals(member.getPassword())) {
				url = "welcome";
				session = request.getSession();
				session.setAttribute("member", member);
			}else {
				model.addAttribute("message", "Sorry! username or password not right!");
				url ="login";
			}

		}else {
			model.addAttribute("message", "All field is requied!");
			url = "login";
		}
		
		return url;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public String profile(Model model, HttpSession session, HttpServletRequest request) {
		session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		//System.out.println(member.getUserName());
		if(member!=null) {
			model.addAttribute("member", member);
			return "profile";
		}
		return "login";

	}
	
	@RequestMapping(value = { "/profile" }, method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("member") Member member,Model model) {
		memberServiceImpl.saveOrUpdate(member);
		model.addAttribute("message", "Everything updated");
		return "welcome";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("member");
		System.out.println(session.getAttribute("member"));
		return "login";
	}

}
