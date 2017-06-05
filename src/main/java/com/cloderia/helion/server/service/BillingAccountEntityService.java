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

import com.cloderia.helion.client.shared.model.BillingAccount;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.BillingAccountOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link BillingAccount BillingAccounts}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BillingAccountEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<BillingAccount> findAll() {
		return em.createNamedQuery(BillingAccount.ALL_BILLINGACCOUNT_QUERY, BillingAccount.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public BillingAccount findByCode(String code){
		try {
			return em.createNamedQuery(BillingAccount.FIND_BILLINGACCOUNT_BY_CODE_QUERY, BillingAccount.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param billingAccount
	 */
  	public void create(final BillingAccountOperation billingAccountOps) {
		BillingAccount billingAccount = billingAccountOps.getData();
  		billingAccount.setBAccountParty(em.find(Party.class, billingAccountOps.getBAccountPartyId()));
  		this.doBeforeCreateEntity(billingAccount);
    	em.persist(billingAccount);
  	}
	
	/**
	 * @param billingAccount
	 */
  	public void update(final BillingAccount billingAccount) {
    	em.merge(billingAccount);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final BillingAccount billingAccount = em.find(BillingAccount.class, id);
    	if (billingAccount != null) {
      		em.remove(billingAccount);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + BillingAccount.class.getSimpleName());
    	}
  	}

}
