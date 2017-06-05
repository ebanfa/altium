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

import com.cloderia.helion.client.shared.model.ClassifiedFile;
import com.cloderia.helion.client.shared.model.File;
import com.cloderia.helion.client.shared.model.FileClassification;
import com.cloderia.helion.client.shared.operation.ClassifiedFileOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link ClassifiedFile ClassifiedFiles}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClassifiedFileEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<ClassifiedFile> findAll() {
		return em.createNamedQuery(ClassifiedFile.ALL_CLASSIFIEDFILE_QUERY, ClassifiedFile.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public ClassifiedFile findByCode(String code){
		try {
			return em.createNamedQuery(ClassifiedFile.FIND_CLASSIFIEDFILE_BY_CODE_QUERY, ClassifiedFile.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param classifiedFile
	 */
  	public void create(final ClassifiedFileOperation classifiedFileOps) {
		ClassifiedFile classifiedFile = classifiedFileOps.getData();
  		classifiedFile.setClassFile(em.find(File.class, classifiedFileOps.getClassFileId()));
  		classifiedFile.setFileClass(em.find(FileClassification.class, classifiedFileOps.getFileClassId()));
  		this.doBeforeCreateEntity(classifiedFile);
    	em.persist(classifiedFile);
  	}
	
	/**
	 * @param classifiedFile
	 */
  	public void update(final ClassifiedFile classifiedFile) {
    	em.merge(classifiedFile);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final ClassifiedFile classifiedFile = em.find(ClassifiedFile.class, id);
    	if (classifiedFile != null) {
      		em.remove(classifiedFile);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + ClassifiedFile.class.getSimpleName());
    	}
  	}

}
