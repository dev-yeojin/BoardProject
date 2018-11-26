package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.web.service.MemberService;
import com.test.web.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/memberList", method=RequestMethod.GET)
	public ModelAndView getMemberList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String memberList = memberService.getMemberList();
		
		mv.addObject("memberList", memberList);
		mv.setViewName("/member/memberList");
		
		return mv;
	}
	
	@RequestMapping(value="/member/view", method=RequestMethod.GET)
	public ModelAndView getMember(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String userId = request.getParameter("userId");
		Member member = memberService.getMember(userId);
	
		mv.addObject("member", member);
		mv.setViewName("/member/memberView");
		
		return mv;
	}
	
	@RequestMapping(value="/member/create", method=RequestMethod.GET)
	public String createMemberPage(){
		return "/member/memberCreate";
	}
	
	@RequestMapping(value="/member/create", method=RequestMethod.POST)
	public String createMember(HttpServletRequest request, HttpServletResponse response){
		Member member = new Member();
		
		member.setU_id(request.getParameter("register_userId"));
		member.setU_pwd(request.getParameter("register_pwd"));
		member.setU_name(request.getParameter("register_name"));
		
		try {
			memberService.createMember(member);
			return "redirect:/login";
		} catch (Exception e) {
			return "redirect:/error";
		}
	}
	
	@RequestMapping(value="/member/edit", method=RequestMethod.GET)
	public ModelAndView updateMemberPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String userId = request.getParameter("userId");
		Member member = memberService.getMember(userId);
		
		mv.addObject("member", member);
		mv.setViewName("/member/memberEdit");
		
		return mv;
	}
	
	@RequestMapping(value="/member/edit", method=RequestMethod.POST)
	public String editMember(HttpServletRequest request, HttpServletResponse response){
		Member member = new Member();
		
		member.setU_id(request.getParameter("userId"));
		member.setU_pwd(request.getParameter("pwd"));
		member.setU_name(request.getParameter("name"));
		
		try {
			memberService.updateMember(member);
			return "redirect:/login";
		} catch (Exception e) {
			return "redirect:/error";
		}
	}
	
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String deleteMember(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		
		session.removeAttribute("member");
		memberService.deleteMember(userId);
		
		return "redirect:/login";
	}
}

