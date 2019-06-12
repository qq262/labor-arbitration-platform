/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.news.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.news.entity.NewsTrends;

/**
 * news_trendsDAO接口
 * @author 秦宣浩
 * @version 2019-06-12
 */
@MyBatisDao
public interface NewsTrendsDao extends CrudDao<NewsTrends> {
	
}