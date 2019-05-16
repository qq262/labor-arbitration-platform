/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
import com.jeesite.modules.arbitration.entity.ArbitrationArchives;
import com.jeesite.modules.arbitration.service.ArbitrationArchivesService;

/**
 * 档案Controller
 * @author qinxuanhao
 * @version 2019-05-15
 */
@Controller
@RequestMapping(value = "${adminPath}/arbitration/arbitrationArchives")
public class ArbitrationArchivesController extends BaseController {

	@Autowired
	private ArbitrationArchivesService arbitrationArchivesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ArbitrationArchives get(String id, boolean isNewRecord) {
		return arbitrationArchivesService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:view")
	@RequestMapping(value = {"list", ""})
	public String list(ArbitrationArchives arbitrationArchives, Model model) {
		model.addAttribute("arbitrationArchives", arbitrationArchives);
		return "modules/arbitration/arbitrationArchivesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ArbitrationArchives> listData(ArbitrationArchives arbitrationArchives, HttpServletRequest request, HttpServletResponse response) {
		arbitrationArchives.setPage(new Page<>(request, response));
		Page<ArbitrationArchives> page = arbitrationArchivesService.findPage(arbitrationArchives);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:view")
	@RequestMapping(value = "form")
	public String form(ArbitrationArchives arbitrationArchives, Model model) {
		model.addAttribute("arbitrationArchives", arbitrationArchives);
		return "modules/arbitration/arbitrationArchivesForm";
	}

	/**
	 * 保存档案列表
	 * @throws ParseException 
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ArbitrationArchives arbitrationArchives) throws ParseException {
		arbitrationArchivesService.save(arbitrationArchives);
		return renderResult(Global.TRUE, text("保存档案列表成功！"));
	}
	
	
	/**
	 * 生成
	 * @throws ParseException 
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:edit")
	@PostMapping(value = "cheungSave")
	@ResponseBody
	public String cheungSave(@Validated ArbitrationArchives arbitrationArchives) throws ParseException {
		arbitrationArchivesService.save(arbitrationArchives);
		return renderResult(Global.TRUE, text(arbitrationArchives.getId()));
	}
	
	
	/**
	 * 删除档案列表
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ArbitrationArchives arbitrationArchives) {
		arbitrationArchivesService.delete(arbitrationArchives);
		return renderResult(Global.TRUE, text("删除档案列表成功！"));
	}
	
}