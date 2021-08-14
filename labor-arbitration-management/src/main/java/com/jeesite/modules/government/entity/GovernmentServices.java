/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.government.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * government_servicesEntity
 * @author 秦宣浩
 * @version 2019-06-18
 */
@Table(name="government_services", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="conton", attrName="conton", label="内容", isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
		@Column(name="author", attrName="author", label="作者"),
		@Column(name="picture", attrName="picture", label="图片", isQuery=false),
		@Column(name="content_article", attrName="contentArticle", label="文章内容", isQuery=false),
		@Column(name="type", attrName="type", label="类型"),
		@Column(name="file_upload", attrName="fileUpload", label="文件上传", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class GovernmentServices extends DataEntity<GovernmentServices> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String conton;		// 内容
	private String author;		// 作者
	private String picture;		// 图片
	private String contentArticle;		// 文章内容
	private String type;		// 类型
	private String fileUpload;		// 文件上传
	
	public GovernmentServices() {
		this(null);
	}

	public GovernmentServices(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="标题长度不能超过 255 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getConton() {
		return conton;
	}

	public void setConton(String conton) {
		this.conton = conton;
	}
	
	@Length(min=0, max=255, message="作者长度不能超过 255 个字符")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Length(min=0, max=1024, message="图片长度不能超过 1024 个字符")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getContentArticle() {
		return contentArticle;
	}

	public void setContentArticle(String contentArticle) {
		this.contentArticle = contentArticle;
	}
	
	@Length(min=0, max=255, message="类型长度不能超过 255 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=1024, message="文件上传长度不能超过 1024 个字符")
	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	
}