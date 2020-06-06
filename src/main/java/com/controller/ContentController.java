package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Content;
import com.model.Member;
import com.service.impl.ContentServiceImpl;
import com.util.JsonConvert;

@Controller
public class ContentController {

	private String url = "";

	@Autowired
	ContentServiceImpl contentServiceImpl;

	@PostMapping("/view")
	@ResponseBody
	String getAllContent(@SessionAttribute("member") Member member) throws JsonProcessingException {
		return JsonConvert.convertToJson(contentServiceImpl.getAllContentByMemberId(member.getId()));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String addContent(@SessionAttribute("member") Member member,Model model) {
		if(member == null) {
			return "login";
		}
		model.addAttribute("content", new Content());
		model.addAttribute("action", "add");
		model.addAttribute("submit", "Add");
		return "content";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	String saveContent(@SessionAttribute("member") Member member,@ModelAttribute("content") Content content,Model model)  {
		if (content != null) {
			content.setMember(member);
			content.setCreateDate(new Date());
			contentServiceImpl.saveOrUpdate(content);
			url = "welcome";
			model.addAttribute("message", "Add success");
		} else
			url = "register";

		return url;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	String editContent(@SessionAttribute("member") Member member,Model model, @PathVariable("id") int id) {
		// find content and set to model
		if(member == null) {
			return "login";
		}
		model.addAttribute("content", contentServiceImpl.getContentById(id));
		model.addAttribute("submit", "Edit");
		model.addAttribute("action", "edit");
		return "content";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	String updateContent(@ModelAttribute("content") Content content, Model model) {
		if (content != null) {
			content.setUpdateDate(new Date());
			contentServiceImpl.saveOrUpdate(content);
			model.addAttribute("message", "Edit success");
			return "welcome";
		}
		model.addAttribute("message", "Edit Fail");
		return "login";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	String deleteContent(@SessionAttribute("member") Member member, @RequestParam("id") int id)
			throws JsonProcessingException {
		contentServiceImpl.deleteContentById(id);
		return JsonConvert.convertToJson(contentServiceImpl.getAllContentByMemberId(member.getId()));
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	String searchContent(@SessionAttribute("member") Member member, @RequestParam("text") String text)
			throws JsonProcessingException {
		//contentServiceImpl.deleteContentById(id);
		List<Content> contents = contentServiceImpl.searchContent(text, text, member.getId());
		return JsonConvert.convertToJson(contents);
	}
	
//	@RequestMapping(value = "/edit", method = RequestMethod.POST)
//	@ResponseBody
//	String editContent(@SessionAttribute("member") Member member, 
//			@RequestParam("title") String title,
//			@RequestParam("brief") String brief,
//			@RequestParam("content") String content,
//			@RequestParam("sort") String sort)
//			throws JsonProcessingException {
//		//change infor content
//		Content c = new Content();
//		c.setTitle(title);
//		c.setBrief(brief);
//		c.setContent(content);
//		c.setSort(Integer.parseInt(sort));
//		c.setUpdateDate(new Date());
//		
//		//update content
//		contentServiceImpl.saveOrUpdate(c);
//		List<Content> contents = contentServiceImpl.getAllContentByMemberId(member.getId());
//		
//		return JsonConvert.convertToJson(contents);
//	}
}
