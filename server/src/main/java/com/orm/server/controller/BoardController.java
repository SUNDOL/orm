package com.orm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orm.server.dto.BoardDTO;
import com.orm.server.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@Operation(summary = "게시물 등록", description = "새 게시물을 생성함.")
	@PostMapping
	public String create(
			@RequestBody BoardDTO.Create data) {
		return service.create(data);
	}
	
	@Operation(summary = "게시물 조회", description = "특정 게시글의 상세 정보를 조회함.")
	@GetMapping("/{id}")
	public BoardDTO.Read read(
			@Parameter(description = "조회할 게시글의 id")
			@PathVariable("id") Long id) {
		return service.read(id);
	}
	
	@Operation(summary = "게시물 수정", description = "특정 게시물을 수정함.")
	@PutMapping("/{id}")
	public String update(
			@Parameter(description = "수정할 게시글의 id") 
			@PathVariable("id") Long id, 
			@RequestBody BoardDTO.Update data) {
		return service.update(id, data);
	}
	
	@Operation(summary = "게시물 삭제", description = "특정 게시물을 삭제함.")
	@DeleteMapping("/{id}")
	public String delete(
			@Parameter(description = "삭제할 게시글의 id") 
			@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
	@Operation(summary = "게시물 목록", description = "게시글 목록을 조회함.")
	@GetMapping
	public Page<BoardDTO.List> list(
			@Parameter(description = "페이지 번호 (0부터 시작)")
			@RequestParam("page") int page, 
			@Parameter(description = "한 번에 몇 개의 데이터를 조회할 것인가")
			@RequestParam("size") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("bId")));
		return service.list(pageable);
	}
}
