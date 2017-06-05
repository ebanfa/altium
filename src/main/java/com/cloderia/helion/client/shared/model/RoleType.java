package com.cloderia.helion.client.shared.model;

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
 * RoleType generated by hbm2java
 */
@Bindable
@Portable
@Entity
@NamedQueries({
  @NamedQuery(name = RoleType.ALL_ROLETYPE_QUERY, query = "SELECT e FROM RoleType e ORDER BY e.id"),
  @NamedQuery(name = RoleType.FIND_ROLETYPE_BY_CODE_QUERY, query = "SELECT e FROM RoleType e where e.entityCode = :entityCode ORDER  BY e.id"),
})
@Table(name="roletype")
public class RoleType extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String ALL_ROLETYPE_QUERY = "allRoleTypes";
	public static final String FIND_ROLETYPE_BY_CODE_QUERY = "findRoleTypesByCode";
	
    private Integer id;

	private String entityCode;
	private String name;
	private Date dateCreated;
	private String description;

    public RoleType() {
    }
	
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="entity_code", nullable=true, length=35)
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


