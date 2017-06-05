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

import com.cloderia.helion.client.shared.model.Currency;
import com.cloderia.helion.client.shared.operation.CurrencyOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Currency Currencys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CurrencyEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Currency> findAll() {
		return em.createNamedQuery(Currency.ALL_CURRENCY_QUERY, Currency.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Currency findByCode(String code){
		try {
			return em.createNamedQuery(Currency.FIND_CURRENCY_BY_CODE_QUERY, Currency.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param currency
	 */
  	public void create(final CurrencyOperation currencyOps) {
		Currency currency = currencyOps.getData();
  		this.doBeforeCreateEntity(currency);
    	em.persist(currency);
  	}
	
	/**
	 * @param currency
	 */
  	public void update(final Currency currency) {
    	em.merge(currency);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Currency currency = em.find(Currency.class, id);
    	if (currency != null) {
      		em.remove(currency);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Currency.class.getSimpleName());
    	}
  	}

}
