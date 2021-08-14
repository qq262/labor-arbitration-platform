/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.government.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.government.entity.GovernmentServices;

/**
 * government_servicesDAO接口
 * @author 秦宣浩
 * @version 2019-06-18
 */
@MyBatisDao
public interface GovernmentServicesDao extends CrudDao<GovernmentServices> {
	
}