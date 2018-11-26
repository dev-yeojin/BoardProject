package com.test.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.web.service.BoardService;
import com.test.web.vo.Board;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/board/boardList", method=RequestMethod.GET)
	public ModelAndView getBoardList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<Board> boardList = boardService.getBoardList();
		
		mv.addObject("boardList", boardList);
		mv.setViewName("/board/boardList");
		return mv;
	}
	
	@RequestMapping(value="/board/view", method=RequestMethod.GET)
	public ModelAndView getBoard(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String b_id = request.getParameter("b_id");
		
		Board board = boardService.getBoard(b_id);
		
		mv.addObject("board", board);
		mv.setViewName("/board/boardView");
		return mv;
	}
	
	@RequestMapping(value="/board/create", method=RequestMethod.GET)
	public String createBoardPage(){
		return "/board/boardCreate";
	}
	
	@RequestMapping(value="/board/create", method=RequestMethod.POST)
	public ModelAndView createBoard(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Board board = new Board(request.getParameter("b_id"), request.getParameter("b_content"), request.getParameter("b_writer"));
		
		mv.addObject("board", board);
		mv.setViewName("redirect:/board/boardList");
		return mv;
	}
	
	@RequestMapping(value="/board/edit", method=RequestMethod.GET)
	public ModelAndView editBoardPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String b_id = request.getParameter("b_id");
		
		Board board = boardService.getBoard(b_id);
		
		mv.addObject("board", board);
		mv.setViewName("/board/boardEdit");
		return mv;
	}
	
	@RequestMapping(value="/board/edit", method=RequestMethod.POST)
	public ModelAndView editBoard(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Board board = new Board(request.getParameter("b_id"), request.getParameter("b_content"), request.getParameter("b_writer"));
		
		mv.addObject("board", "board");
		mv.setViewName("redirect:/board/view");
		
		return mv;
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.GET)
	public String deleteBoard(HttpServletRequest request, HttpServletResponse response){
		String b_id = request.getParameter("b_id");
		boardService.deleteBoard(b_id);
		
		return "redirect:/board/boardList";
	}
}
