package com.cloderia.helion.client.shared.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.jboss.errai.databinding.client.api.Bindable;

import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Urgency generated by hbm2java
 */
@Bindable
@Portable
@Entity
@NamedQueries({
  @NamedQuery(name = Urgency.ALL_URGENCY_QUERY, query = "SELECT e FROM Urgency e ORDER BY e.id"),
  @NamedQuery(name = Urgency.FIND_URGENCY_BY_CODE_QUERY, query = "SELECT e FROM Urgency e where e.entityCode = :entityCode ORDER  BY e.id"),
})
@Table(name="urgency")
public class Urgency extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String ALL_URGENCY_QUERY = "allUrgencys";
	public static final String FIND_URGENCY_BY_CODE_QUERY = "findUrgencysByCode";
	
    private Integer id;

	private String entityCode;
	private String name;
	@NotNull(message="The price Factor is required.")
	private BigDecimal priceFactor;
	private Date dateCreated;
	private String description;

    public Urgency() {
    }
	
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="entity_code", nullable=false, length=35)
    public String getEntityCode() {
        return this.entityCode;
    }
    
    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }
    
    @Column(name="name", nullable=false, length=75)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="price_factor", nullable=false, length=255)
    public BigDecimal getPriceFactor() {
        return this.priceFactor;
    }
    
    public void setPriceFactor(BigDecimal priceFactor) {
        this.priceFactor = priceFactor;
    }
    
    @Column(name="date_created", nullable=false, length=35)
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    @Column(name="description", nullable=false, length=255)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

}


