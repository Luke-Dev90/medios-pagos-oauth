package com.lchalela.app.ouath.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionDTO {
	private String accountDestination;
	private String accountOrigin;
	private String reason;
	private LocalDateTime createAt;
	private BigDecimal amount;
}
