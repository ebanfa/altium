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

import com.cloderia.helion.client.shared.model.FileClassification;
import com.cloderia.helion.client.shared.model.FileClassificationType;
import com.cloderia.helion.client.shared.operation.FileClassificationOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link FileClassification FileClassifications}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FileClassificationEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<FileClassification> findAll() {
		return em.createNamedQuery(FileClassification.ALL_FILECLASSIFICATION_QUERY, FileClassification.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public FileClassification findByCode(String code){
		try {
			return em.createNamedQuery(FileClassification.FIND_FILECLASSIFICATION_BY_CODE_QUERY, FileClassification.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param fileClassification
	 */
  	public void create(final FileClassificationOperation fileClassificationOps) {
		FileClassification fileClassification = fileClassificationOps.getData();
  		fileClassification.setFclassType(em.find(FileClassificationType.class, fileClassificationOps.getFclassTypeId()));
  		this.doBeforeCreateEntity(fileClassification);
    	em.persist(fileClassification);
  	}
	
	/**
	 * @param fileClassification
	 */
  	public void update(final FileClassification fileClassification) {
    	em.merge(fileClassification);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final FileClassification fileClassification = em.find(FileClassification.class, id);
    	if (fileClassification != null) {
      		em.remove(fileClassification);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + FileClassification.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<FileClassification> findByType(String fileClassificationTypeCode){
		return em.createNamedQuery(FileClassification.FIND_FILECLASSIFICATION_BY_TYPE_CODE_QUERY, FileClassification.class)
		.setParameter("entityCode", fileClassificationTypeCode.toUpperCase()).getResultList();
	}
	

}
