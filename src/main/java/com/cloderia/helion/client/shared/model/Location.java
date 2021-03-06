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
 * Location generated by hbm2java
 */
@Bindable
@Portable
@Entity
@NamedQueries({
  @NamedQuery(name = Location.ALL_LOCATION_QUERY, query = "SELECT e FROM Location e ORDER BY e.id"),
  @NamedQuery(name = Location.FIND_LOCATION_BY_CODE_QUERY, query = "SELECT e FROM Location e where e.entityCode = :entityCode ORDER  BY e.id"),
  @NamedQuery(name = Location.FIND_LOCATION_BY_TYPE_CODE_QUERY, query = "SELECT e FROM Location e JOIN e.locationType a where a.entityCode = :entityCode ORDER  BY e.id"),
})
@Table(name="location")
public class Location extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String ALL_LOCATION_QUERY = "allLocations";
	public static final String FIND_LOCATION_BY_CODE_QUERY = "findLocationsByCode";
	public static final String FIND_LOCATION_BY_TYPE_CODE_QUERY = "findLocationsByTypeCode";
	
    private Integer id;

	private String entityCode;
    private LocationType locationType;
    private Location parentLocation;
    private Currency locationCurrency;
	private String name;
	private Date dateCreated;
	private String description;

    public Location() {
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
    @JoinColumn(name="location_type", nullable=false)
    public LocationType getLocationType() {
        return this.locationType;
    }
    
    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="parent_location", nullable=true)
    public Location getParentLocation() {
        return this.parentLocation;
    }
    
    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="location_currency", nullable=true)
    public Currency getLocationCurrency() {
        return this.locationCurrency;
    }
    
    public void setLocationCurrency(Currency locationCurrency) {
        this.locationCurrency = locationCurrency;
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


