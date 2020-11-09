package com.marketplace.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_ANIMAL", schema = "DBKINGDOM")
public class Animal {

	@Id
	@Column(name = "ID_ANIMAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnimal;

	private String race;

	private String description;

	private String region;

	private String province;

	private String city;

	private Date birthDate;

	private Date availableDate;

	private Boolean privateOwner;

	private Boolean dogHouse;

	private Boolean breeding;

	private BigDecimal price;

	private Boolean pedigree;

	private String pedigreeDetails;

	@JoinColumn(name = "ID_ANIMAL_ATTRIBUTES", referencedColumnName = "ID_ANIMAL_ATTRIBUTES", nullable = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AnimalAttributes> additionalProperties;

	@JoinColumn(name = "ID_OWNER", referencedColumnName = "ID_OWNER")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private OwnerPet ownerPet;

}
