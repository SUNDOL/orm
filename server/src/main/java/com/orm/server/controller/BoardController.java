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

@RestController
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@PostMapping
	public String create(@RequestBody BoardDTO.Create data) {
		return service.create(data);
	}
	
	@GetMapping("/{id}")
	public BoardDTO.Read read(@PathVariable("id") Long id) {
		return service.read(id);
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody BoardDTO.Update data) {
		return service.update(id, data);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
		
	@GetMapping
	public Page<BoardDTO.List> list(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("bId")));
		return service.list(pageable);
	}
}
