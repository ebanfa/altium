/**
 * 
 */
package com.cloderia.helion.client.shared.util;

import java.math.BigDecimal;

import com.cloderia.helion.client.shared.model.AcademicLevel;
import com.cloderia.helion.client.shared.model.Urgency;

/**
 * @author adrian
 *
 */
public class Calculator {

	/**
	 * @param academicLevel
	 * @param urgency
	 * @param pageCount
	 * @return
	 */
	public BigDecimal calculate(AcademicLevel academicLevel, Urgency urgency, BigDecimal pageCount, BigDecimal pricingFactor) {
		return academicLevel.getPriceFactor().multiply(urgency.getPriceFactor()).multiply(pricingFactor).multiply(pageCount);
	}

}
