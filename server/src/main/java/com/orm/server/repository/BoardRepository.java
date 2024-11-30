package com.orm.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orm.server.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
