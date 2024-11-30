package com.orm.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.orm.server.dto.BoardDTO;
import com.orm.server.entity.Board;
import com.orm.server.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repository;

	// 게시물 등록
	public String create(BoardDTO.Create data) {
		try {
			Board board = new Board();
			board.setBTitle(data.getTitle());
			board.setBContent(data.getContent());
			board.setBAuthor(data.getAuthor());
			Board save = repository.save(board);	
			if (save != null && save.getBId() != null) {
				return "good";				
			} else {
				return "bad1";
			}
		} catch (Exception e) {
			return "bad2";
		}
	}

	// 게시물 조회 (게시물 1개 상세 조회)
	public BoardDTO.Read read(Long id) {
		Board board = repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));		
		BoardDTO.Read dto = new BoardDTO.Read();
		dto.setId(board.getBId());
		dto.setTitle(board.getBTitle());
		dto.setContent(board.getBContent());
		dto.setAuthor(board.getBAuthor());
		dto.setCreatedAt(board.getBCreatedAt());
		dto.setUpdatedAt(board.getBUpdatedAt());
		return dto;
	}

	// 게시물 수정
	public String update(Long id, BoardDTO.Update data) {
		try {
			Board board = repository.findById(id).orElse(null);
			if (board == null) {
				return "not found";
			} else {
				board.setBTitle(data.getTitle());
				board.setBContent(data.getContent());
				try {
					Board update = repository.save(board);
					if (update != null) {
						return "good";
					} else {
						return "bad";
					}
				} catch (Exception e) {
					return "error1";
				}		
			}
		} catch (Exception e) {
			return "error2";
		}
	}

	// 게시물 삭제
	public String delete(Long id) {
		try {
			Board board = repository.findById(id).orElse(null);
			if (board == null) {
				return "not found";
			} else {
				try {
					repository.delete(board);
					Board delete = repository.findById(id).orElse(null);
					if (delete == null) {
						return "good";
					} else {
						return "bad";
					}
				} catch (Exception e) {
					return "error1";
				}
			}
		} catch (Exception e) {
			return "error2";
		}
	}

	// 게시물 조회 (목록 조회)
	public Page<BoardDTO.List> list(Pageable pageable) {
		Page<Board> list = repository.findAll(pageable);
		return list.map(i -> {
			BoardDTO.List item = new BoardDTO.List();
			item.setId(i.getBId());
			item.setTitle(i.getBTitle());
			item.setAuthor(i.getBAuthor());
			item.setUpdatedAt(i.getBUpdatedAt());
			return item;
		});
	}

}
