/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.news.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.news.entity.NewsTrends;
import com.jeesite.modules.news.service.NewsTrendsService;

/**
 * news_trendsController
 * @author 秦宣浩
 * @version 2019-06-12
 */
@Controller
@RequestMapping(value = "${adminPath}/news/newsTrends")
public class NewsTrendsController extends BaseController {

	@Autowired
	private NewsTrendsService newsTrendsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public NewsTrends get(String id, boolean isNewRecord) {
		return newsTrendsService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("news:newsTrends:view")
	@RequestMapping(value = {"list", ""})
	public String list(NewsTrends newsTrends, Model model) {
		model.addAttribute("newsTrends", newsTrends);
		return "modules/news/newsTrendsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("news:newsTrends:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<NewsTrends> listData(NewsTrends newsTrends, HttpServletRequest request, HttpServletResponse response) {
		newsTrends.setPage(new Page<>(request, response));
		Page<NewsTrends> page = newsTrendsService.findPage(newsTrends);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("news:newsTrends:view")
	@RequestMapping(value = "form")
	public String form(NewsTrends newsTrends, Model model) {
		model.addAttribute("newsTrends", newsTrends);
		return "modules/news/newsTrendsForm";
	}

	/**
	 * 保存news_trends
	 */
	@RequiresPermissions("news:newsTrends:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated NewsTrends newsTrends) {
		String picture = newsTrends.getPicture();
		String[] split = picture.split("jpg");
		String srt = "",sts="";
		for(int i=0;i<split.length;i++) {
		if(i < 1) {
			srt += "<img src='" + split[i] + "jpg'>";
			
		}else {
			
			srt += "<img src='" + split[i].substring(1) + "jpg'>";
		}
		
			
		}
		String filesList = newsTrends.getRemarks();
		String[] files = filesList.split("/js");
		for(int c=0;c<files.length;c++) {
			if(c==0) {
				
			}else if (c >= 2) {
			String [] num = files[c].split("/");
			int p = num.length-1;
			sts += "<li><a class='btn btn-info btn-xs blue' target='_blank' href='/js"+files[c]+"'><i class='fa fa-download'></i> '"+num[p]+"' </a></li>";	

			}else {
			String [] nums = files[c].split("/");
			int ps = nums.length-1;	
			sts += "<li><a class='btn btn-info btn-xs blue' target='_blank' href='/js"+files[c].substring(0,files[c].length()-1)+"'><i class='fa fa-download'></i>'"+nums[ps]+"' </a></li>";	

			}
			
			
		}
	
		newsTrends.setPicture(srt);
		newsTrends.setRemarks(sts);
		newsTrendsService.save(newsTrends);
		return renderResult(Global.TRUE, text("保存news_trends成功！"));
	}
	
	/**
	 * 删除news_trends
	 */
	@RequiresPermissions("news:newsTrends:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(NewsTrends newsTrends) {
		newsTrendsService.delete(newsTrends);
		return renderResult(Global.TRUE, text("删除news_trends成功！"));
	}
	
}