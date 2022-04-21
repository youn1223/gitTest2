package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;

public class PModifyCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PersonDao dao = PersonDao.getInstance();
		dao.modify(num,name,age);
	}
}
