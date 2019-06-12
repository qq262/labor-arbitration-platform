/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.news.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * news_trendsEntity
 * @author 秦宣浩
 * @version 2019-06-12
 */
@Table(name="news_trends", alias="a", columns={
		@Column(name="id", attrName="id", label="主键", isPK=true),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="conton", attrName="conton", label="内容", isQuery=false),
		@Column(name="remarks", attrName="remarks", label="备注", queryType=QueryType.LIKE),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
		@Column(name="author", attrName="author", label="作者"),
		@Column(name="picture", attrName="picture", label="图片", isQuery=false),
		@Column(name="file_trends", attrName="fileTrends", label="新闻内容"),
		@Column(name="type", attrName="type", label="类型"),
	}, orderBy="a.update_date DESC"
)
public class NewsTrends extends DataEntity<NewsTrends> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 标题
	private String conton;		// 内容
	private String author;		// 作者
	private String picture;		// 图片
	private String fileTrends;		// 新闻内容
	private String type;		// 类型
	
	public NewsTrends() {
		this(null);
	}

	public NewsTrends(String id){
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
	
	@Length(min=0, max=255, message="图片长度不能超过 255 个字符")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public String getFileTrends() {
		return fileTrends;
	}

	public void setFileTrends(String fileTrends) {
		this.fileTrends = fileTrends;
	}
	
	@Length(min=0, max=255, message="类型长度不能超过 255 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}