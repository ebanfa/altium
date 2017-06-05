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

import com.cloderia.helion.client.shared.model.ConversationType;
import com.cloderia.helion.client.shared.model.ConversationCategory;
import com.cloderia.helion.client.shared.operation.ConversationTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ConversationType ConversationTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ConversationType> findAll() {
		return em.createNamedQuery(ConversationType.ALL_CONVERSATIONTYPE_QUERY, ConversationType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ConversationType findByCode(String code){
		try {
			return em.createNamedQuery(ConversationType.FIND_CONVERSATIONTYPE_BY_CODE_QUERY, ConversationType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversationType
	 */
  	public void create(final ConversationTypeOperation conversationTypeOps) {
		ConversationType conversationType = conversationTypeOps.getData();
  		conversationType.setConvCategory(em.find(ConversationCategory.class, conversationTypeOps.getConvCategoryId()));
  		this.doBeforeCreateEntity(conversationType);
    	em.persist(conversationType);
  	}
	
	/**
	 * @param conversationType
	 */
  	public void update(final ConversationType conversationType) {
    	em.merge(conversationType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ConversationType conversationType = em.find(ConversationType.class, id);
    	if (conversationType != null) {
      		em.remove(conversationType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ConversationType.class.getSimpleName());
    	}
  	}

}
