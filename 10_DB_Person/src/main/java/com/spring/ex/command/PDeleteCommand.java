package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;

public class PDeleteCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");

		PersonDao pdao = PersonDao.getInstance();
		pdao.deleteList(num);
	}
}
