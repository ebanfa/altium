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

import com.cloderia.helion.client.shared.model.AccountTransactionType;
import com.cloderia.helion.client.shared.operation.AccountTransactionTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link AccountTransactionType AccountTransactionTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountTransactionTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<AccountTransactionType> findAll() {
		return em.createNamedQuery(AccountTransactionType.ALL_ACCOUNTTRANSACTIONTYPE_QUERY, AccountTransactionType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public AccountTransactionType findByCode(String code){
		try {
			return em.createNamedQuery(AccountTransactionType.FIND_ACCOUNTTRANSACTIONTYPE_BY_CODE_QUERY, AccountTransactionType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param accountTransactionType
	 */
  	public void create(final AccountTransactionTypeOperation accountTransactionTypeOps) {
		AccountTransactionType accountTransactionType = accountTransactionTypeOps.getData();
  		this.doBeforeCreateEntity(accountTransactionType);
    	em.persist(accountTransactionType);
  	}
	
	/**
	 * @param accountTransactionType
	 */
  	public void update(final AccountTransactionType accountTransactionType) {
    	em.merge(accountTransactionType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final AccountTransactionType accountTransactionType = em.find(AccountTransactionType.class, id);
    	if (accountTransactionType != null) {
      		em.remove(accountTransactionType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + AccountTransactionType.class.getSimpleName());
    	}
  	}

}
