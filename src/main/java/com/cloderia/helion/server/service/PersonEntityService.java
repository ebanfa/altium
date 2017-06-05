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

import com.cloderia.helion.client.shared.model.Person;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.operation.PersonOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link Person Persons}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PersonEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<Person> findAll() {
		return em.createNamedQuery(Person.ALL_PERSON_QUERY, Person.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public Person findByCode(String code){
		try {
			return em.createNamedQuery(Person.FIND_PERSON_BY_CODE_QUERY, Person.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param person
	 */
  	public void create(final PersonOperation personOps) {
		Person person = personOps.getData();
  		person.setPersonParty(em.find(Party.class, personOps.getPersonPartyId()));
  		this.doBeforeCreateEntity(person);
    	em.persist(person);
  	}
	
	/**
	 * @param person
	 */
  	public void update(final Person person) {
    	em.merge(person);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final Person person = em.find(Person.class, id);
    	if (person != null) {
      		em.remove(person);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + Person.class.getSimpleName());
    	}
  	}

}
