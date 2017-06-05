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

import com.cloderia.helion.client.shared.model.FileType;
import com.cloderia.helion.client.shared.model.FileCategory;
import com.cloderia.helion.client.shared.operation.FileTypeOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link FileType FileTypes}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FileTypeEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<FileType> findAll() {
		return em.createNamedQuery(FileType.ALL_FILETYPE_QUERY, FileType.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public FileType findByCode(String code){
		try {
			return em.createNamedQuery(FileType.FIND_FILETYPE_BY_CODE_QUERY, FileType.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param fileType
	 */
  	public void create(final FileTypeOperation fileTypeOps) {
		FileType fileType = fileTypeOps.getData();
  		fileType.setFileCategory(em.find(FileCategory.class, fileTypeOps.getFileCategoryId()));
  		this.doBeforeCreateEntity(fileType);
    	em.persist(fileType);
  	}
	
	/**
	 * @param fileType
	 */
  	public void update(final FileType fileType) {
    	em.merge(fileType);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final FileType fileType = em.find(FileType.class, id);
    	if (fileType != null) {
      		em.remove(fileType);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + FileType.class.getSimpleName());
    	}
  	}

}
