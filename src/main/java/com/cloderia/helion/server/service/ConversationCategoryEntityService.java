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

import com.cloderia.helion.client.shared.model.ConversationCategory;
import com.cloderia.helion.client.shared.operation.ConversationCategoryOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ConversationCategory ConversationCategorys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ConversationCategoryEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ConversationCategory> findAll() {
		return em.createNamedQuery(ConversationCategory.ALL_CONVERSATIONCATEGORY_QUERY, ConversationCategory.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ConversationCategory findByCode(String code){
		try {
			return em.createNamedQuery(ConversationCategory.FIND_CONVERSATIONCATEGORY_BY_CODE_QUERY, ConversationCategory.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param conversationCategory
	 */
  	public void create(final ConversationCategoryOperation conversationCategoryOps) {
		ConversationCategory conversationCategory = conversationCategoryOps.getData();
  		this.doBeforeCreateEntity(conversationCategory);
    	em.persist(conversationCategory);
  	}
	
	/**
	 * @param conversationCategory
	 */
  	public void update(final ConversationCategory conversationCategory) {
    	em.merge(conversationCategory);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ConversationCategory conversationCategory = em.find(ConversationCategory.class, id);
    	if (conversationCategory != null) {
      		em.remove(conversationCategory);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ConversationCategory.class.getSimpleName());
    	}
  	}

}
