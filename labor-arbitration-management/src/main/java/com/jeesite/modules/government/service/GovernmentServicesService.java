/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.government.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.government.entity.GovernmentServices;
import com.jeesite.modules.government.dao.GovernmentServicesDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * government_servicesService
 * @author 秦宣浩
 * @version 2019-06-18
 */
@Service
@Transactional(readOnly=true)
public class GovernmentServicesService extends CrudService<GovernmentServicesDao, GovernmentServices> {
	
	/**
	 * 获取单条数据
	 * @param governmentServices
	 * @return
	 */
	@Override
	public GovernmentServices get(GovernmentServices governmentServices) {
		return super.get(governmentServices);
	}
	
	/**
	 * 查询分页数据
	 * @param governmentServices 查询条件
	 * @param governmentServices.page 分页对象
	 * @return
	 */
	@Override
	public Page<GovernmentServices> findPage(GovernmentServices governmentServices) {
		return super.findPage(governmentServices);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param governmentServices
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GovernmentServices governmentServices) {
		super.save(governmentServices);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(governmentServices.getId(), "governmentServices_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(governmentServices.getId(), "governmentServices_file");
	}
	
	/**
	 * 更新状态
	 * @param governmentServices
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(GovernmentServices governmentServices) {
		super.updateStatus(governmentServices);
	}
	
	/**
	 * 删除数据
	 * @param governmentServices
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(GovernmentServices governmentServices) {
		super.delete(governmentServices);
	}
	
}