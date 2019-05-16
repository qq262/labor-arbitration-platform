/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 档案Entity
 * @author qinxuanhao
 * @version 2019-05-15
 */
@Table(name="${_prefix}arbitration_archives", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="archives_level", attrName="archivesLevel", label="档案等级"),
		@Column(name="archives_type", attrName="archivesType", label="争议类型"),
		@Column(name="archives_code", attrName="archivesCode", label="档案编号", queryType=QueryType.LIKE),
		@Column(name="apply_user", attrName="applyUser", label="申请人", queryType=QueryType.LIKE),
		@Column(name="defendant_user", attrName="defendantUser", label="被申请人", queryType=QueryType.LIKE),
		@Column(name="apply_date", attrName="applyDate", label="申请日期"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="date_acceptance", attrName="dateAcceptance", label="受理日期"),
		@Column(name="opening_date", attrName="openingDate", label="开庭日期"),
		@Column(name="date_submission", attrName="dateSubmission", label="提交文书日期"),
		@Column(name="date_time_slot", attrName="dateTimeSlot", label="时间段"),
	}, orderBy="a.update_date DESC"
)
public class ArbitrationArchives extends DataEntity<ArbitrationArchives> {
	
	private static final long serialVersionUID = 1L;
	private String archivesLevel;		// 档案等级
	private String archivesType;		// 争议类型
	private String archivesCode;		// 档案编号
	private String applyUser;		// 申请人
	private String defendantUser;		// 被申请人
	private Date applyDate;		// 申请日期
	private Date dateAcceptance;		// 受理日期
	private Date openingDate;		// 开庭日期
	private Date dateSubmission;		// 提交文书日期
	private String dateTimeSlot;		// 时间段
	
	public ArbitrationArchives() {
		this(null);
	}

	public ArbitrationArchives(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="档案等级长度不能超过 255 个字符")
	public String getArchivesLevel() {
		return archivesLevel;
	}

	public void setArchivesLevel(String archivesLevel) {
		this.archivesLevel = archivesLevel;
	}
	
	@Length(min=0, max=255, message="争议类型长度不能超过 255 个字符")
	public String getArchivesType() {
		return archivesType;
	}

	public void setArchivesType(String archivesType) {
		this.archivesType = archivesType;
	}
	
	@Length(min=0, max=64, message="档案编号长度不能超过 64 个字符")
	public String getArchivesCode() {
		return archivesCode;
	}

	public void setArchivesCode(String archivesCode) {
		this.archivesCode = archivesCode;
	}
	
	@Length(min=0, max=255, message="申请人长度不能超过 255 个字符")
	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	
	@Length(min=0, max=255, message="被申请人长度不能超过 255 个字符")
	public String getDefendantUser() {
		return defendantUser;
	}

	public void setDefendantUser(String defendantUser) {
		this.defendantUser = defendantUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDateAcceptance() {
		return dateAcceptance;
	}

	public void setDateAcceptance(Date dateAcceptance) {
		this.dateAcceptance = dateAcceptance;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDateSubmission() {
		return dateSubmission;
	}

	public void setDateSubmission(Date dateSubmission) {
		this.dateSubmission = dateSubmission;
	}
	
	@Length(min=0, max=255, message="时间段长度不能超过 255 个字符")
	public String getDateTimeSlot() {
		return dateTimeSlot;
	}

	public void setDateTimeSlot(String dateTimeSlot) {
		this.dateTimeSlot = dateTimeSlot;
	}
	
}