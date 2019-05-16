/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.arbitration.entity.ArbitrationArchives;

/**
 * 档案DAO接口
 * @author qinxuanhao
 * @version 2019-05-15
 */
@MyBatisDao
public interface ArbitrationArchivesDao extends CrudDao<ArbitrationArchives> {
	
}