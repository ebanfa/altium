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

import com.cloderia.helion.client.shared.model.Conversation;
import com.cloderia.helion.client.shared.model.ConversationType;
import com.cloderia.helion.client.shared.operation.ConversationOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Conversation Conversations}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Conversation> findAll() {
		return em.createNamedQuery(Conversation.ALL_CONVERSATION_QUERY, Conversation.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Conversation findByCode(String code){
		try {
			return em.createNamedQuery(Conversation.FIND_CONVERSATION_BY_CODE_QUERY, Conversation.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversation
	 */
  	public void create(final ConversationOperation conversationOps) {
		Conversation conversation = conversationOps.getData();
  		conversation.setConvType(em.find(ConversationType.class, conversationOps.getConvTypeId()));
  		this.doBeforeCreateEntity(conversation);
    	em.persist(conversation);
  	}
	
	/**
	 * @param conversation
	 */
  	public void update(final Conversation conversation) {
    	em.merge(conversation);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Conversation conversation = em.find(Conversation.class, id);
    	if (conversation != null) {
      		em.remove(conversation);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Conversation.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<Conversation> findByType(String conversationTypeCode){
		return em.createNamedQuery(Conversation.FIND_CONVERSATION_BY_TYPE_CODE_QUERY, Conversation.class)
		.setParameter("entityCode", conversationTypeCode.toUpperCase()).getResultList();
	}
	

}
