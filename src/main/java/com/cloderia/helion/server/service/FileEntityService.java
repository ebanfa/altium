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

import com.cloderia.helion.client.shared.model.File;
import com.cloderia.helion.client.shared.model.FileType;
import com.cloderia.helion.client.shared.operation.FileOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link File Files}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FileEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<File> findAll() {
		return em.createNamedQuery(File.ALL_FILE_QUERY, File.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public File findByCode(String code){
		try {
			return em.createNamedQuery(File.FIND_FILE_BY_CODE_QUERY, File.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param file
	 */
  	public void create(final FileOperation fileOps) {
		File file = fileOps.getData();
  		file.setFileType(em.find(FileType.class, fileOps.getFileTypeId()));
  		this.doBeforeCreateEntity(file);
    	em.persist(file);
  	}
	
	/**
	 * @param file
	 */
  	public void update(final File file) {
    	em.merge(file);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final File file = em.find(File.class, id);
    	if (file != null) {
      		em.remove(file);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + File.class.getSimpleName());
    	}
  	}
	/**
	 * @return
	 */
	public List<File> findByType(String fileTypeCode){
		return em.createNamedQuery(File.FIND_FILE_BY_TYPE_CODE_QUERY, File.class)
		.setParameter("entityCode", fileTypeCode.toUpperCase()).getResultList();
	}
	

}
