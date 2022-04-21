package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;

public class PWriteCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PersonDao dao=PersonDao.getInstance();
		dao.write(id,name,age);
	}

}
