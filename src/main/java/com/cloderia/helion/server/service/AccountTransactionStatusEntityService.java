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

import com.cloderia.helion.client.shared.model.AccountTransactionStatus;
import com.cloderia.helion.client.shared.operation.AccountTransactionStatusOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link AccountTransactionStatus AccountTransactionStatuss}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountTransactionStatusEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<AccountTransactionStatus> findAll() {
		return em.createNamedQuery(AccountTransactionStatus.ALL_ACCOUNTTRANSACTIONSTATUS_QUERY, AccountTransactionStatus.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public AccountTransactionStatus findByCode(String code){
		try {
			return em.createNamedQuery(AccountTransactionStatus.FIND_ACCOUNTTRANSACTIONSTATUS_BY_CODE_QUERY, AccountTransactionStatus.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param accountTransactionStatus
	 */
  	public void create(final AccountTransactionStatusOperation accountTransactionStatusOps) {
		AccountTransactionStatus accountTransactionStatus = accountTransactionStatusOps.getData();
  		this.doBeforeCreateEntity(accountTransactionStatus);
    	em.persist(accountTransactionStatus);
  	}
	
	/**
	 * @param accountTransactionStatus
	 */
  	public void update(final AccountTransactionStatus accountTransactionStatus) {
    	em.merge(accountTransactionStatus);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final AccountTransactionStatus accountTransactionStatus = em.find(AccountTransactionStatus.class, id);
    	if (accountTransactionStatus != null) {
      		em.remove(accountTransactionStatus);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + AccountTransactionStatus.class.getSimpleName());
    	}
  	}

}
