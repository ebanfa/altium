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

import com.cloderia.helion.client.shared.model.WritingStyle;
import com.cloderia.helion.client.shared.operation.WritingStyleOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link WritingStyle WritingStyles}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class WritingStyleEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<WritingStyle> findAll() {
		return em.createNamedQuery(WritingStyle.ALL_WRITINGSTYLE_QUERY, WritingStyle.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public WritingStyle findByCode(String code){
		try {
			return em.createNamedQuery(WritingStyle.FIND_WRITINGSTYLE_BY_CODE_QUERY, WritingStyle.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param writingStyle
	 */
  	public void create(final WritingStyleOperation writingStyleOps) {
		WritingStyle writingStyle = writingStyleOps.getData();
  		this.doBeforeCreateEntity(writingStyle);
    	em.persist(writingStyle);
  	}
	
	/**
	 * @param writingStyle
	 */
  	public void update(final WritingStyle writingStyle) {
    	em.merge(writingStyle);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final WritingStyle writingStyle = em.find(WritingStyle.class, id);
    	if (writingStyle != null) {
      		em.remove(writingStyle);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + WritingStyle.class.getSimpleName());
    	}
  	}

}
