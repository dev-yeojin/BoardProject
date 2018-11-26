package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.web.service.MemberService;
import com.test.web.vo.Member;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "msg", required = false) String msg){
		ModelAndView mv = new ModelAndView();
	
		mv.addObject("msg", msg);
		mv.setViewName("/loginPage");
	
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		String path = null;
		String msg = null;
		String userId = request.getParameter("login_userId");
		String pwd = request.getParameter("login_pwd");
		try {
			boolean exist = memberService.existMember(userId);
		
			if(exist){
				boolean loginSuccess = memberService.checkPassword(userId, pwd);
				
				if(loginSuccess){
					msg = "로그인에 성공하였습니다.";
					path = "/loginSuccess";
					Member member = memberService.getMember(userId);
					session.setAttribute("member", member);
				}else{
					msg = "비밀번호를 확인해주세요.";
					path = "redirect:/login";
				}
				
			}else{
				msg = "아이디가 존재하지 않습니다.";
				path = "redirect:/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("msg", msg);
		mv.setViewName(path);
		return mv;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		return "redirect:/login";
	}
}
