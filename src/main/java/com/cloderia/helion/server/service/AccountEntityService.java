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

import com.cloderia.helion.client.shared.model.Account;
import com.cloderia.helion.client.shared.operation.AccountOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Account Accounts}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Account> findAll() {
		return em.createNamedQuery(Account.ALL_ACCOUNT_QUERY, Account.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Account findByCode(String code){
		try {
			return em.createNamedQuery(Account.FIND_ACCOUNT_BY_CODE_QUERY, Account.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param account
	 */
  	public void create(final AccountOperation accountOps) {
		Account account = accountOps.getData();
  		this.doBeforeCreateEntity(account);
    	em.persist(account);
  	}
	
	/**
	 * @param account
	 */
  	public void update(final Account account) {
    	em.merge(account);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Account account = em.find(Account.class, id);
    	if (account != null) {
      		em.remove(account);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Account.class.getSimpleName());
    	}
  	}

}
