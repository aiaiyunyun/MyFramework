package com.wbhhc.domain;

// Generated 2013-12-22 21:08:55 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Subsystem generated by hbm2java
 */
@Entity
@Table(name = "SUBSYSTEM")
public class Subsystem implements java.io.Serializable {

	private BigDecimal id;
	private String name;
	private Set<Syspage> syspages = new HashSet<Syspage>(0);

	public Subsystem() {
	}

	public Subsystem(BigDecimal id) {
		this.id = id;
	}

	public Subsystem(BigDecimal id, String name, Set<Syspage> syspages) {
		this.id = id;
		this.name = name;
		this.syspages = syspages;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subsystem")
	public Set<Syspage> getSyspages() {
		return this.syspages;
	}

	public void setSyspages(Set<Syspage> syspages) {
		this.syspages = syspages;
	}

}
