/**
 * 
 */
package com.cloderia.helion.client.shared.operation;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;

import com.cloderia.helion.client.shared.model.Person;

/**
 * @author adrian
 *
 */
@Portable
public class PersonOperation extends AbstractOperation {

	private final Person person;

	protected Integer personPartyId;

  	public PersonOperation(final @MapsTo("person") Person person, 
  		final @MapsTo("sourceQueueSessionId") String sourceQueueSessionId) {
    	this.person = person;
    	this.sourceQueueSessionId = sourceQueueSessionId;
  	}

  	/**
   	 * A {@link Person} that has been created or updated.
   	 */
  	public Person getData() {
    	return person;
  	}
  	
  	

  	/**
   	 * 
   	 */
  	public Integer getPersonPartyId() {
    	return personPartyId;
  	}

  	/**
   	 * .
   	 */
  	public void setPersonPartyId(Integer personPartyId) {
    	this.personPartyId = personPartyId;
  	}
}

