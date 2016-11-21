package com.wbhhc.domain;

// Generated 2013-12-22 21:08:55 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Syspage generated by hbm2java
 */
@Entity
@Table(name = "SYSPAGE")
public class Syspage implements java.io.Serializable {

	private BigDecimal id;
	private Subsystem subsystem;
	private String name;
	private String pageurl;
	private String code;
	private BigDecimal parentid;
	private String imgurl;
	private BigDecimal sort;
	private Set<Sysrole> sysroles = new HashSet<Sysrole>(0);
	private Set<Sysoperate> sysoperates = new HashSet<Sysoperate>(0);
	private Set<Sysrolepageopt> sysrolepageopts = new HashSet<Sysrolepageopt>(0);

	public Syspage() {
	}

	public Syspage(BigDecimal id, Subsystem subsystem) {
		this.id = id;
		this.subsystem = subsystem;
	}

	public Syspage(BigDecimal id, Subsystem subsystem, String name,
			String pageurl, String code, BigDecimal parentid, String imgurl,
			BigDecimal sort, Set<Sysrole> sysroles,
			Set<Sysoperate> sysoperates, Set<Sysrolepageopt> sysrolepageopts) {
		this.id = id;
		this.subsystem = subsystem;
		this.name = name;
		this.pageurl = pageurl;
		this.code = code;
		this.parentid = parentid;
		this.imgurl = imgurl;
		this.sort = sort;
		this.sysroles = sysroles;
		this.sysoperates = sysoperates;
		this.sysrolepageopts = sysrolepageopts;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYSID", nullable = false)
	public Subsystem getSubsystem() {
		return this.subsystem;
	}

	public void setSubsystem(Subsystem subsystem) {
		this.subsystem = subsystem;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PAGEURL", length = 100)
	public String getPageurl() {
		return this.pageurl;
	}

	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}

	@Column(name = "CODE", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "PARENTID", precision = 22, scale = 0)
	public BigDecimal getParentid() {
		return this.parentid;
	}

	public void setParentid(BigDecimal parentid) {
		this.parentid = parentid;
	}

	@Column(name = "IMGURL", length = 100)
	public String getImgurl() {
		return this.imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Column(name = "SORT", precision = 22, scale = 0)
	public BigDecimal getSort() {
		return this.sort;
	}

	public void setSort(BigDecimal sort) {
		this.sort = sort;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYSROLEANDPAGE", joinColumns = { @JoinColumn(name = "PAGEID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLEID", nullable = false, updatable = false) })
	public Set<Sysrole> getSysroles() {
		return this.sysroles;
	}

	public void setSysroles(Set<Sysrole> sysroles) {
		this.sysroles = sysroles;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SYSPAGEANDOPT", joinColumns = { @JoinColumn(name = "PAGEID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "OPTID", nullable = false, updatable = false) })
	public Set<Sysoperate> getSysoperates() {
		return this.sysoperates;
	}

	public void setSysoperates(Set<Sysoperate> sysoperates) {
		this.sysoperates = sysoperates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "syspage")
	public Set<Sysrolepageopt> getSysrolepageopts() {
		return this.sysrolepageopts;
	}

	public void setSysrolepageopts(Set<Sysrolepageopt> sysrolepageopts) {
		this.sysrolepageopts = sysrolepageopts;
	}

}
