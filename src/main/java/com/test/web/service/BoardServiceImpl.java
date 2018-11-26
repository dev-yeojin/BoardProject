package com.test.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDao;
import com.test.web.vo.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Board getBoard(String b_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(String b_id) {
		// TODO Auto-generated method stub
		
	}

	
}
