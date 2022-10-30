package com.corona.insertrecords.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class LimitAmountDTO  implements Serializable {

	public LimitAmountDTO(BigDecimal amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public LimitAmountDTO(BigDecimal amount) {
		this.amount = amount;
	}

	private BigDecimal amount;
	private String currency;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "LimitAmountDTO{" +
				"amount=" + amount +
				", currency='" + currency + '\'' +
				'}';
	}
}
