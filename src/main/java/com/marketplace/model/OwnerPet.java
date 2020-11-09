package com.marketplace.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_OWNER_PET", schema = "DBKINGDOM")
public class OwnerPet {

	@Id
	@Column(name = "ID_OWNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fullName;

	private String phone;

	private String email;

	@JoinColumn(name = "ID_ANIMAL", referencedColumnName = "ID_ANIMAL", nullable = true)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Animal> animals;

}
