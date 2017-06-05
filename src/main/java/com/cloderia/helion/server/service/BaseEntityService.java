/**
 * 
 */
package com.cloderia.helion.server.service;

import java.util.Date;

import com.cloderia.helion.client.shared.model.BaseEntity;
import com.cloderia.helion.client.shared.util.StringUtil;

/**
 * @author adrian
 *
 */
public class BaseEntityService {

	
	/**
	 * @param entityData
	 */
	protected void doBeforeCreateEntity(BaseEntity entityData) {
		if(!StringUtil.isValidString(entityData.getEntityCode()))
			entityData.setEntityCode(StringUtil.generateRandom(7));
		
		if(entityData.getDateCreated() == null)	
			entityData.setDateCreated(new Date());
	}
}
