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

import com.cloderia.helion.client.shared.model.Signup;
import com.cloderia.helion.client.shared.operation.SignupOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Signup Signups}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SignupEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Signup> findAll() {
		return new ArrayList<Signup>();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Signup findByCode(String code){
		return null;
	}
	
	/**
	 * @param signup
	 */
  	public void create(final SignupOperation signupOps) {
		Signup signup = signupOps.getData();
  		this.doBeforeCreateEntity(signup);
    	em.persist(signup);
  	}
	
	/**
	 * @param signup
	 */
  	public void update(final Signup signup) {
    	em.merge(signup);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Signup signup = em.find(Signup.class, id);
    	if (signup != null) {
      		em.remove(signup);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Signup.class.getSimpleName());
    	}
  	}

}
