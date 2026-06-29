package com.SrinidhiBoardMeeting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoadOptionIntegerDto {
	private Long value;
	 private String label;

	 
}
