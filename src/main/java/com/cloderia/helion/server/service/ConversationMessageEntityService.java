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

import com.cloderia.helion.client.shared.model.ConversationMessage;
import com.cloderia.helion.client.shared.model.Conversation;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.ConversationMessageOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ConversationMessage ConversationMessages}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationMessageEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ConversationMessage> findAll() {
		return em.createNamedQuery(ConversationMessage.ALL_CONVERSATIONMESSAGE_QUERY, ConversationMessage.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ConversationMessage findByCode(String code){
		try {
			return em.createNamedQuery(ConversationMessage.FIND_CONVERSATIONMESSAGE_BY_CODE_QUERY, ConversationMessage.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversationMessage
	 */
  	public void create(final ConversationMessageOperation conversationMessageOps) {
		ConversationMessage conversationMessage = conversationMessageOps.getData();
  		conversationMessage.setMsgConv(em.find(Conversation.class, conversationMessageOps.getMsgConvId()));
  		conversationMessage.setToParty(em.find(Party.class, conversationMessageOps.getToPartyId()));
  		conversationMessage.setFromParty(em.find(Party.class, conversationMessageOps.getFromPartyId()));
  		this.doBeforeCreateEntity(conversationMessage);
    	em.persist(conversationMessage);
  	}
	
	/**
	 * @param conversationMessage
	 */
  	public void update(final ConversationMessage conversationMessage) {
    	em.merge(conversationMessage);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ConversationMessage conversationMessage = em.find(ConversationMessage.class, id);
    	if (conversationMessage != null) {
      		em.remove(conversationMessage);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ConversationMessage.class.getSimpleName());
    	}
  	}

}
