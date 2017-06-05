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

import com.cloderia.helion.client.shared.model.ConversationMessageFile;
import com.cloderia.helion.client.shared.model.ConversationMessage;
import com.cloderia.helion.client.shared.model.File;
import com.cloderia.helion.client.shared.operation.ConversationMessageFileOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ConversationMessageFile ConversationMessageFiles}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationMessageFileEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ConversationMessageFile> findAll() {
		return em.createNamedQuery(ConversationMessageFile.ALL_CONVERSATIONMESSAGEFILE_QUERY, ConversationMessageFile.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ConversationMessageFile findByCode(String code){
		try {
			return em.createNamedQuery(ConversationMessageFile.FIND_CONVERSATIONMESSAGEFILE_BY_CODE_QUERY, ConversationMessageFile.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversationMessageFile
	 */
  	public void create(final ConversationMessageFileOperation conversationMessageFileOps) {
		ConversationMessageFile conversationMessageFile = conversationMessageFileOps.getData();
  		conversationMessageFile.setConvMsg(em.find(ConversationMessage.class, conversationMessageFileOps.getConvMsgId()));
  		conversationMessageFile.setMsgFile(em.find(File.class, conversationMessageFileOps.getMsgFileId()));
  		this.doBeforeCreateEntity(conversationMessageFile);
    	em.persist(conversationMessageFile);
  	}
	
	/**
	 * @param conversationMessageFile
	 */
  	public void update(final ConversationMessageFile conversationMessageFile) {
    	em.merge(conversationMessageFile);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ConversationMessageFile conversationMessageFile = em.find(ConversationMessageFile.class, id);
    	if (conversationMessageFile != null) {
      		em.remove(conversationMessageFile);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ConversationMessageFile.class.getSimpleName());
    	}
  	}

}
