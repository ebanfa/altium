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

import com.cloderia.helion.client.shared.model.ConversationParty;
import com.cloderia.helion.client.shared.model.Conversation;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.ConversationPartyOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ConversationParty ConversationPartys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationPartyEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ConversationParty> findAll() {
		return em.createNamedQuery(ConversationParty.ALL_CONVERSATIONPARTY_QUERY, ConversationParty.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ConversationParty findByCode(String code){
		try {
			return em.createNamedQuery(ConversationParty.FIND_CONVERSATIONPARTY_BY_CODE_QUERY, ConversationParty.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversationParty
	 */
  	public void create(final ConversationPartyOperation conversationPartyOps) {
		ConversationParty conversationParty = conversationPartyOps.getData();
  		conversationParty.setPartyConv(em.find(Conversation.class, conversationPartyOps.getPartyConvId()));
  		conversationParty.setConvParty(em.find(Party.class, conversationPartyOps.getConvPartyId()));
  		this.doBeforeCreateEntity(conversationParty);
    	em.persist(conversationParty);
  	}
	
	/**
	 * @param conversationParty
	 */
  	public void update(final ConversationParty conversationParty) {
    	em.merge(conversationParty);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ConversationParty conversationParty = em.find(ConversationParty.class, id);
    	if (conversationParty != null) {
      		em.remove(conversationParty);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ConversationParty.class.getSimpleName());
    	}
  	}

}
