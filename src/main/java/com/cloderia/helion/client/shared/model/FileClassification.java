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
 * FileClassification generated by hbm2java
 */
@Bindable
@Portable
@Entity
@NamedQueries({
  @NamedQuery(name = FileClassification.ALL_FILECLASSIFICATION_QUERY, query = "SELECT e FROM FileClassification e ORDER BY e.id"),
  @NamedQuery(name = FileClassification.FIND_FILECLASSIFICATION_BY_CODE_QUERY, query = "SELECT e FROM FileClassification e where e.entityCode = :entityCode ORDER  BY e.id"),
  @NamedQuery(name = FileClassification.FIND_FILECLASSIFICATION_BY_TYPE_CODE_QUERY, query = "SELECT e FROM FileClassification e JOIN e.fclassType a where a.entityCode = :entityCode ORDER  BY e.id"),
})
@Table(name="fileclassification")
public class FileClassification extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String ALL_FILECLASSIFICATION_QUERY = "allFileClassifications";
	public static final String FIND_FILECLASSIFICATION_BY_CODE_QUERY = "findFileClassificationsByCode";
	public static final String FIND_FILECLASSIFICATION_BY_TYPE_CODE_QUERY = "findFileClassificationsByTypeCode";
	
    private Integer id;

	private String entityCode;
    private FileClassificationType fclassType;
	private String name;
	private Date dateCreated;
	private String description;

    public FileClassification() {
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
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="fclass_type", nullable=false)
    public FileClassificationType getFclassType() {
        return this.fclassType;
    }
    
    public void setFclassType(FileClassificationType fclassType) {
        this.fclassType = fclassType;
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


