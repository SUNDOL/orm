package com.orm.server.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

// CRUD 각각의 기능에 맞게 적절하게 DTO 작성
public class BoardDTO {
	
	// Create DTO
	@Getter
	@Setter
	public static class Create {
		@Schema(description = "게시글 제목", example = "게시글 제목입니다.")
		private String title;
		
		@Schema(description = "게시글 내용", example = "게시글 내용입니다. 게시글 본문이라고도 하지요.")
		private String content;
		
		@Schema(description = "게시글 작성자", example = "작성자")
		private String author;
	}
	
	// Read DTO
	@Getter
	@Setter
	public static class Read {
		@Schema(description = "게시글 ID")
		private Long id;
		
		@Schema(description = "게시글 제목")
		private String title;
		
		@Schema(description = "게시글 내용")
		private String content;
		
		@Schema(description = "게시글 작성자")
		private String author;
		
		@Schema(description = "게시글 생성일")
		private LocalDateTime createdAt;
		
		@Schema(description = "게시글 최종 수정일")
		private LocalDateTime updatedAt;
	}
	
	// Update DTO
	@Getter
	@Setter
	public static class Update {
		@Schema(description = "게시글 제목", example = "게시글 제목 수정입니다.")
		private String title;
		
		@Schema(description = "게시글 내용", example = "게시글 내용 수정입니다. 게시글 본문 수정이라고도 하지요.")
		private String content;
	}
	
	// List DTO
	@Getter
	@Setter
	public static class List {
		@Schema(description = "게시글 ID")
		private Long id;
		
		@Schema(description = "게시글 제목")
		private String title;
		
		@Schema(description = "게시글 작성자")
		private String author;
		
		@Schema(description = "게시글 최종 수정일")
		private LocalDateTime updatedAt;
	}
	
}
