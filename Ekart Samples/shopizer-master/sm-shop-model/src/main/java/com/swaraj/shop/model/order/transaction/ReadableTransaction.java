package com.swaraj.shop.model.order.transaction;

import java.io.Serializable;

import com.swaraj.core.model.payments.PaymentType;
import com.swaraj.core.model.payments.TransactionType;

public class ReadableTransaction extends TransactionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PaymentType paymentType;
	private TransactionType transactionType;
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}


}
