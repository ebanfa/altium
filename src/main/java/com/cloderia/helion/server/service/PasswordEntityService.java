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

import com.cloderia.helion.client.shared.model.Password;
import com.cloderia.helion.client.shared.operation.PasswordOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Password Passwords}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PasswordEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Password> findAll() {
		return new ArrayList<Password>();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Password findByCode(String code){
		return null;
	}
	
	/**
	 * @param password
	 */
  	public void create(final PasswordOperation passwordOps) {
		Password password = passwordOps.getData();
  		this.doBeforeCreateEntity(password);
    	em.persist(password);
  	}
	
	/**
	 * @param password
	 */
  	public void update(final Password password) {
    	em.merge(password);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Password password = em.find(Password.class, id);
    	if (password != null) {
      		em.remove(password);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Password.class.getSimpleName());
    	}
  	}

}
