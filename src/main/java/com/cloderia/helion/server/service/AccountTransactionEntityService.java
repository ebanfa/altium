/**
 * 
 */

package com.cloderia.helion.server.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cloderia.helion.client.shared.model.AccountTransaction;
import com.cloderia.helion.client.shared.model.BillingAccount;
import com.cloderia.helion.client.shared.model.AccountTransactionType;
import com.cloderia.helion.client.shared.model.AccountTransactionStatus;
import com.cloderia.helion.client.shared.operation.AccountTransactionOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link AccountTransaction AccountTransactions}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountTransactionEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<AccountTransaction> findAll() {
		return em.createNamedQuery(AccountTransaction.ALL_ACCOUNTTRANSACTION_QUERY, AccountTransaction.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public AccountTransaction findByCode(String code){
		try {
			return em.createNamedQuery(AccountTransaction.FIND_ACCOUNTTRANSACTION_BY_CODE_QUERY, AccountTransaction.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param accountTransaction
	 */
  	public void create(final AccountTransactionOperation accountTransactionOps) {
		AccountTransaction accountTransaction = accountTransactionOps.getData();
  		accountTransaction.setBillingAccount(em.find(BillingAccount.class, accountTransactionOps.getBillingAccountId()));
  		accountTransaction.setAcctTxnType(em.find(AccountTransactionType.class, accountTransactionOps.getAcctTxnTypeId()));
  		accountTransaction.setTransactionStatus(em.find(AccountTransactionStatus.class, accountTransactionOps.getTransactionStatusId()));
  		this.doBeforeCreateEntity(accountTransaction);
    	em.persist(accountTransaction);
  	}
	
	/**
	 * @param accountTransaction
	 */
  	public void update(final AccountTransaction accountTransaction) {
    	em.merge(accountTransaction);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final AccountTransaction accountTransaction = em.find(AccountTransaction.class, id);
    	if (accountTransaction != null) {
      		em.remove(accountTransaction);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + AccountTransaction.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<AccountTransaction> findByType(String accountTransactionTypeCode){
		return em.createNamedQuery(AccountTransaction.FIND_ACCOUNTTRANSACTION_BY_TYPE_CODE_QUERY, AccountTransaction.class)
		.setParameter("entityCode", accountTransactionTypeCode.toUpperCase()).getResultList();
	}
	

}
