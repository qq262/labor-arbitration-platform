/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.news.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.news.entity.NewsTrends;
import com.jeesite.modules.news.dao.NewsTrendsDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * news_trendsService
 * @author 秦宣浩
 * @version 2019-06-12
 */
@Service
@Transactional(readOnly=true)
public class NewsTrendsService extends CrudService<NewsTrendsDao, NewsTrends> {
	
	/**
	 * 获取单条数据
	 * @param newsTrends
	 * @return
	 */
	@Override
	public NewsTrends get(NewsTrends newsTrends) {
		return super.get(newsTrends);
	}
	
	/**
	 * 查询分页数据
	 * @param newsTrends 查询条件
	 * @param newsTrends.page 分页对象
	 * @return
	 */
	@Override
	public Page<NewsTrends> findPage(NewsTrends newsTrends) {
		return super.findPage(newsTrends);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param newsTrends
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(NewsTrends newsTrends) {
		super.save(newsTrends);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(newsTrends.getId(), "newsTrends_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(newsTrends.getId(), "newsTrends_file");
	}
	
	/**
	 * 更新状态
	 * @param newsTrends
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(NewsTrends newsTrends) {
		super.updateStatus(newsTrends);
	}
	
	/**
	 * 删除数据
	 * @param newsTrends
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(NewsTrends newsTrends) {
		super.delete(newsTrends);
	}
	
}