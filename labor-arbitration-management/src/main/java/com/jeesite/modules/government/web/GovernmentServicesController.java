/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.government.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.jeesite.modules.government.entity.GovernmentServices;
import com.jeesite.modules.government.service.GovernmentServicesService;

/**
 * government_servicesController
 * @author 秦宣浩
 * @version 2019-06-18
 */
@Controller
@RequestMapping(value = "${adminPath}/government/governmentServices")
public class GovernmentServicesController extends BaseController {

	@Autowired
	private GovernmentServicesService governmentServicesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public GovernmentServices get(String id, boolean isNewRecord) {
		return governmentServicesService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("government:governmentServices:view")
	@RequestMapping(value = {"list", ""})
	public String list(GovernmentServices governmentServices, Model model) {
		model.addAttribute("governmentServices", governmentServices);
		return "modules/government/governmentServicesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("government:governmentServices:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<GovernmentServices> listData(GovernmentServices governmentServices, HttpServletRequest request, HttpServletResponse response) {
		governmentServices.setPage(new Page<>(request, response));
		Page<GovernmentServices> page = governmentServicesService.findPage(governmentServices);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("government:governmentServices:view")
	@RequestMapping(value = "form")
	public String form(GovernmentServices governmentServices, Model model) {
		model.addAttribute("governmentServices", governmentServices);
		return "modules/government/governmentServicesForm";
	}

	/**
	 * 保存government_services
	 */
	@RequiresPermissions("government:governmentServices:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated GovernmentServices governmentServices) {
		String picture = governmentServices.getPicture();
		String splitList = picture.replace("|", " ");
		String[] split = splitList.split(" ");
		String srt = "",sts="";
		for(int i=0;i<split.length;i++) {
		if(i < 1) {
			srt += "<img src='" + split[i] + "'>";
			
		}else {
			
			srt += "<img src='" + split[i].substring(1) + "'>";
		}
		
			
		}
		String filesList = governmentServices.getFileUpload();
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
	
		governmentServices.setPicture(srt);
		governmentServices.setFileUpload(sts);;
		governmentServicesService.save(governmentServices);
		return renderResult(Global.TRUE, text("保存government_services成功！"));
	}
	
	/**
	 * 删除government_services
	 */
	@RequiresPermissions("government:governmentServices:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(GovernmentServices governmentServices) {
		governmentServicesService.delete(governmentServices);
		return renderResult(Global.TRUE, text("删除government_services成功！"));
	}
	
}