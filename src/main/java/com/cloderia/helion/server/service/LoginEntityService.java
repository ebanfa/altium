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

import com.cloderia.helion.client.shared.model.Login;
import com.cloderia.helion.client.shared.util.StringUtil;

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Login Logins}.
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class LoginEntityService {

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Login> findAll() {
		return new ArrayList<Login>();
  	}
	
	/**
	 * @param login
	 */
  	public Boolean login(final Login login) {
  		if(!StringUtil.isValidString(login.getUserName())) return false;
  		if(!StringUtil.isValidString(login.getPassword())) return false;
    	return true;
  	}
	
	/**
	 * @param login
	 */
  	public void update(final Login login) {
    	em.merge(login);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Login login = em.find(Login.class, id);
    	if (login != null) {
      		em.remove(login);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Login.class.getSimpleName());
    	}
  	}

}
