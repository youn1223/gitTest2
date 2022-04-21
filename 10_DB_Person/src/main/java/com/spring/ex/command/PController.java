package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PController {
	
	
	String page;
	PCommand command;
	
	@RequestMapping(value = "insertForm" , method = RequestMethod.GET)
	public String insertForm() {
		page="insertForm";
		
		return page;
	}

	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(HttpServletRequest request) {
		command = new PWriteCommand();
		command.execute(request);
		//return "list";
		return "redirect:/list";

	}

	@RequestMapping(value="list")
	public String list(HttpServletRequest request) {
		command = new PListCommand();
		command.execute(request);
		return "list";
	}
	
	@RequestMapping(value="content_view")
	public String content_view(HttpServletRequest request) {
		command = new PContentCommand();
		command.execute(request);
		return "content_view";
	}

	@RequestMapping(value="modify")
	public String modify(HttpServletRequest request) {
		command = new PModifyCommand();
		command.execute(request);
		return "redirect:/list";
	}
	
	@RequestMapping(value="delete")
	public String delete(HttpServletRequest request) { 
		command = new PDeleteCommand();
		command.execute(request);
		return "redirect:/list";
	}
}
