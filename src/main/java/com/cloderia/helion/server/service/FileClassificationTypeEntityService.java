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

import com.cloderia.helion.client.shared.model.FileClassificationType;
import com.cloderia.helion.client.shared.operation.FileClassificationTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link FileClassificationType FileClassificationTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FileClassificationTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<FileClassificationType> findAll() {
		return em.createNamedQuery(FileClassificationType.ALL_FILECLASSIFICATIONTYPE_QUERY, FileClassificationType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public FileClassificationType findByCode(String code){
		try {
			return em.createNamedQuery(FileClassificationType.FIND_FILECLASSIFICATIONTYPE_BY_CODE_QUERY, FileClassificationType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param fileClassificationType
	 */
  	public void create(final FileClassificationTypeOperation fileClassificationTypeOps) {
		FileClassificationType fileClassificationType = fileClassificationTypeOps.getData();
  		this.doBeforeCreateEntity(fileClassificationType);
    	em.persist(fileClassificationType);
  	}
	
	/**
	 * @param fileClassificationType
	 */
  	public void update(final FileClassificationType fileClassificationType) {
    	em.merge(fileClassificationType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final FileClassificationType fileClassificationType = em.find(FileClassificationType.class, id);
    	if (fileClassificationType != null) {
      		em.remove(fileClassificationType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + FileClassificationType.class.getSimpleName());
    	}
  	}

}
