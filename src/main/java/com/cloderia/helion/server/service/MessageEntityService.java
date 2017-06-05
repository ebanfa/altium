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

import com.cloderia.helion.client.shared.model.Message;
import com.cloderia.helion.client.shared.operation.MessageOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Message Messages}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MessageEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Message> findAll() {
		return em.createNamedQuery(Message.ALL_MESSAGE_QUERY, Message.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Message findByCode(String code){
		try {
			return em.createNamedQuery(Message.FIND_MESSAGE_BY_CODE_QUERY, Message.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param message
	 */
  	public void create(final MessageOperation messageOps) {
		Message message = messageOps.getData();
  		this.doBeforeCreateEntity(message);
    	em.persist(message);
  	}
	
	/**
	 * @param message
	 */
  	public void update(final Message message) {
    	em.merge(message);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Message message = em.find(Message.class, id);
    	if (message != null) {
      		em.remove(message);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Message.class.getSimpleName());
    	}
  	}

}
