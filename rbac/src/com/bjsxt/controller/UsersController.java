package com.bjsxt.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	@RequestMapping("login")
	public String login(Users users,HttpSession session){
		Map<String,Object> map = usersServiceImpl.login(users);
		if(map.get("user")!=null){
			session.setAttribute("user", map.get("user"));
			int i=0;
//			return "showAllUrl";
			return "redirect:/main.jsp";
		}
		return "redirect:/login121212.jsp";
	}
	
	@RequestMapping("demo")
	public String demo(){
		System.out.println("执行demo");
		return "main.jsp";
	}
	
}
