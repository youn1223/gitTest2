package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PListCommand implements PCommand{

	@Override
	public void execute(HttpServletRequest request) {
		PersonDao dao = PersonDao.getInstance();
		ArrayList<PersonDto> lists = dao.list();
		request.setAttribute("lists", lists);
	}

}
