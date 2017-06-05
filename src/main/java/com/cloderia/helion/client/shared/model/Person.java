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
 * Person generated by hbm2java
 */
@Bindable
@Portable
@Entity
@NamedQueries({
  @NamedQuery(name = Person.ALL_PERSON_QUERY, query = "SELECT e FROM Person e ORDER BY e.id"),
  @NamedQuery(name = Person.FIND_PERSON_BY_CODE_QUERY, query = "SELECT e FROM Person e where e.entityCode = :entityCode ORDER  BY e.id"),
})
@Table(name="person")
public class Person extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final String ALL_PERSON_QUERY = "allPersons";
	public static final String FIND_PERSON_BY_CODE_QUERY = "findPersonsByCode";
	
    private Integer id;

	private String entityCode;
    private Party personParty;
	private String name;
	private String firstName;
	private String lastName;
	private Date dateCreated;
	private String description;

    public Person() {
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
    @JoinColumn(name="person_party", nullable=false)
    public Party getPersonParty() {
        return this.personParty;
    }
    
    public void setPersonParty(Party personParty) {
        this.personParty = personParty;
    }
    
    @Column(name="name", nullable=false, length=75)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="first_name", nullable=false, length=255)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", nullable=false, length=255)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

