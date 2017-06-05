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

import com.cloderia.helion.client.shared.model.PartyRole;
import com.cloderia.helion.client.shared.model.Party;
import com.cloderia.helion.client.shared.model.RoleType;
import com.cloderia.helion.client.shared.operation.PartyRoleOperation;
  		

/**
 * A service that provides transaction boundaries around CRUD operations on {@link PartyRole PartyRoles}.
 * @author Adrian Haldermann
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PartyRoleEntityService extends BaseEntityService{

  	@PersistenceContext(unitName = "helion-default")
  	private EntityManager em;
	
	/**
	 * @return
	 */
	public List<PartyRole> findAll() {
		return em.createNamedQuery(PartyRole.ALL_PARTYROLE_QUERY, PartyRole.class).getResultList();
  	}
  	
  	/**
  	 * @param code
  	 * @return
  	 */
  	public PartyRole findByCode(String code){
		try {
			return em.createNamedQuery(PartyRole.FIND_PARTYROLE_BY_CODE_QUERY, PartyRole.class)
			.setParameter("entityCode", code).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param partyRole
	 */
  	public void create(final PartyRoleOperation partyRoleOps) {
		PartyRole partyRole = partyRoleOps.getData();
  		partyRole.setPartyRoleParty(em.find(Party.class, partyRoleOps.getPartyRolePartyId()));
  		partyRole.setRoleType(em.find(RoleType.class, partyRoleOps.getRoleTypeId()));
  		this.doBeforeCreateEntity(partyRole);
    	em.persist(partyRole);
  	}
	
	/**
	 * @param partyRole
	 */
  	public void update(final PartyRole partyRole) {
    	em.merge(partyRole);
  	}

	/**
	 * @param id
	 */
  	public void delete(final Long id) {
    	final PartyRole partyRole = em.find(PartyRole.class, id);
    	if (partyRole != null) {
      		em.remove(partyRole);
    	} else {
      	throw new IllegalArgumentException("The given id, " + id + ", was not a key for any " + PartyRole.class.getSimpleName());
    	}
  	}

}
