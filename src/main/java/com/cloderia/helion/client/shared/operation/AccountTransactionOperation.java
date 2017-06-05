/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.AccountTransaction;

/**
 * @author adrian
 *
 */
@Portable
public class AccountTransactionOperation extends AbstractOperation {

	private final AccountTransaction accountTransaction;

	protected Integer billingAccountId;

	protected Integer acctTxnTypeId;

	protected Integer transactionStatusId;

  	public AccountTransactionOperation(final @MapsTo("accountTransaction") AccountTransaction accountTransaction, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.accountTransaction = accountTransaction;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link AccountTransaction} that has been created or updated.
   	 */
  	public AccountTransaction getData() {
    	return accountTransaction;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getBillingAccountId() {
    	return billingAccountId;
  	}

  	/**
   	 * .
   	 */
  	public void setBillingAccountId(Integer billingAccountId) {
    	this.billingAccountId = billingAccountId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getAcctTxnTypeId() {
    	return acctTxnTypeId;
  	}

  	/**
   	 * .
   	 */
  	public void setAcctTxnTypeId(Integer acctTxnTypeId) {
    	this.acctTxnTypeId = acctTxnTypeId;
  	}

  	/**
   	 * 
   	 */
  	public Integer getTransactionStatusId() {
    	return transactionStatusId;
  	}

  	/**
   	 * .
   	 */
  	public void setTransactionStatusId(Integer transactionStatusId) {
    	this.transactionStatusId = transactionStatusId;
  	}
}

