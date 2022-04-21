package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PContentCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		PersonDao dao=PersonDao.getInstance();
		PersonDto dto = dao.contentView(num);
		request.setAttribute("dto", dto);
	}
}
