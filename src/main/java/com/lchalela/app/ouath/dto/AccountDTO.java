package com.lchalela.app.ouath.dto;

import java.math.BigDecimal;
import java.util.List;


import lombok.Data;

@Data
public class AccountDTO {
	private BigDecimal balance;
	private String typeAccount;
	private String accountNumber;
	private String cbu;
	private String alias;
	private Long userId;
	private Boolean isActived;
	private List<TransactionDTO> transactionDTO;
}
