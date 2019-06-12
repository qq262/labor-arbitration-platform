/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.arbitration.entity.ArbitrationArchives;
import com.jeesite.modules.arbitration.dao.ArbitrationArchivesDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * js_arbitration_archivesService
 * @author 秦宣浩
 * @version 2019-06-12
 */
@Service
@Transactional(readOnly=true)
public class ArbitrationArchivesService extends CrudService<ArbitrationArchivesDao, ArbitrationArchives> {
	
	/**
	 * 获取单条数据
	 * @param arbitrationArchives
	 * @return
	 */
	@Override
	public ArbitrationArchives get(ArbitrationArchives arbitrationArchives) {
		return super.get(arbitrationArchives);
	}
	
	/**
	 * 查询分页数据
	 * @param arbitrationArchives 查询条件
	 * @param arbitrationArchives.page 分页对象
	 * @return
	 */
	@Override
	public Page<ArbitrationArchives> findPage(ArbitrationArchives arbitrationArchives) {
		return super.findPage(arbitrationArchives);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param arbitrationArchives
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ArbitrationArchives arbitrationArchives) {
		super.save(arbitrationArchives);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(arbitrationArchives.getId(), "arbitrationArchives_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(arbitrationArchives.getId(), "arbitrationArchives_file");
	}
	
	/**
	 * 更新状态
	 * @param arbitrationArchives
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ArbitrationArchives arbitrationArchives) {
		super.updateStatus(arbitrationArchives);
	}
	
	/**
	 * 删除数据
	 * @param arbitrationArchives
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ArbitrationArchives arbitrationArchives) {
		super.delete(arbitrationArchives);
	}
	
}