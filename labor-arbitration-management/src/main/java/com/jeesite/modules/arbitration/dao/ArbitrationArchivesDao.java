/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.arbitration.entity.ArbitrationArchives;

/**
 * js_arbitration_archivesDAO接口
 * @author 秦宣浩
 * @version 2019-06-12
 */
@MyBatisDao
public interface ArbitrationArchivesDao extends CrudDao<ArbitrationArchives> {
	
}