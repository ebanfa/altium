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

import com.cloderia.helion.client.shared.model.FileCategory;
import com.cloderia.helion.client.shared.operation.FileCategoryOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link FileCategory FileCategorys}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FileCategoryEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<FileCategory> findAll() {
		return em.createNamedQuery(FileCategory.ALL_FILECATEGORY_QUERY, FileCategory.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public FileCategory findByCode(String code){
		try {
			return em.createNamedQuery(FileCategory.FIND_FILECATEGORY_BY_CODE_QUERY, FileCategory.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param fileCategory
	 */
  	public void create(final FileCategoryOperation fileCategoryOps) {
		FileCategory fileCategory = fileCategoryOps.getData();
  		this.doBeforeCreateEntity(fileCategory);
    	em.persist(fileCategory);
  	}
	
	/**
	 * @param fileCategory
	 */
  	public void update(final FileCategory fileCategory) {
    	em.merge(fileCategory);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final FileCategory fileCategory = em.find(FileCategory.class, id);
    	if (fileCategory != null) {
      		em.remove(fileCategory);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + FileCategory.class.getSimpleName());
    	}
  	}

}
