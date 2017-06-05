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

import com.cloderia.helion.client.shared.model.DocumentType;
import com.cloderia.helion.client.shared.operation.DocumentTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link DocumentType DocumentTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DocumentTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<DocumentType> findAll() {
		return em.createNamedQuery(DocumentType.ALL_DOCUMENTTYPE_QUERY, DocumentType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public DocumentType findByCode(String code){
		try {
			return em.createNamedQuery(DocumentType.FIND_DOCUMENTTYPE_BY_CODE_QUERY, DocumentType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param documentType
	 */
  	public void create(final DocumentTypeOperation documentTypeOps) {
		DocumentType documentType = documentTypeOps.getData();
  		this.doBeforeCreateEntity(documentType);
    	em.persist(documentType);
  	}
	
	/**
	 * @param documentType
	 */
  	public void update(final DocumentType documentType) {
    	em.merge(documentType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final DocumentType documentType = em.find(DocumentType.class, id);
    	if (documentType != null) {
      		em.remove(documentType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + DocumentType.class.getSimpleName());
    	}
  	}

}
