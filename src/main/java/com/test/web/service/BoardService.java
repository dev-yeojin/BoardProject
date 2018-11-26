package com.test.web.service;

import java.util.List;

import com.test.web.vo.Board;

public interface BoardService {

	public List<Board> getBoardList();

	public Board getBoard(String b_id);
	public void addBoard(Board board);
	public void editBoard(Board board);
	public void deleteBoard(String b_id);
}
