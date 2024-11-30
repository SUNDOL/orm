package com.orm.server.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity 작성
// 서버가 실행되면 바로 Table 생성됨
@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
public class Board {

	// Primary Key 자동 설정
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long bId;
	
	@Column(name = "board_title", nullable = false)
	private String bTitle;
	
	@Column(name = "board_content", nullable = false)
	private String bContent;
	
	@Column(name = "board_author", nullable = false, updatable = false)
	private String bAuthor;
	
	@Column(name = "board_created_at", updatable = false)
	private LocalDateTime bCreatedAt;
	
	@Column(name = "board_updated_at")
	private LocalDateTime bUpdatedAt;
	
	// 게시글 등록 시 게시글 생성일, 게시글 수정일이 자동으로 입력됨
	@PrePersist
	protected void onCreate() {
		this.bCreatedAt = LocalDateTime.now();
		this.bUpdatedAt = LocalDateTime.now();
	}
	
	// 게시글 수정 시 게시글 수정일이 자동으로 수정됨
	@PreUpdate
	protected void onUpdate() {
		this.bUpdatedAt = LocalDateTime.now();
	}
	
}
