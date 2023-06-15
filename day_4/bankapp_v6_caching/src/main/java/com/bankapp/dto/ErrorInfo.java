package com.bankapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {
	private String statuscode;
	private String errorMessage;
	private String  toContactEmail;
	private LocalDateTime  timestemp;
}
