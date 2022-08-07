package com.hackathonteam3.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="careers")
public class Career {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column
	private String name;
	private String description;
	private String level;
	private String requirements;
	
	//OneToMany
	private Long university;

	public Career() {
		
	}

	public Career(Long id, String name, String description, String level, String requirements, Long university) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.requirements = requirements;
		this.university = university;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Long getUniversity() {
		return university;
	}

	public void setUniversity(Long university) {
		this.university = university;
	}
	
}
