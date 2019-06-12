/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.arbitration.web;

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
 * js_arbitration_archivesController
 * @author 秦宣浩
 * @version 2019-06-12
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
	 * 保存js_arbitration_archives
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ArbitrationArchives arbitrationArchives) {
		arbitrationArchivesService.save(arbitrationArchives);
		return renderResult(Global.TRUE, text("保存js_arbitration_archives成功！"));
	}
	
	/**
	 * 删除js_arbitration_archives
	 */
	@RequiresPermissions("arbitration:arbitrationArchives:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ArbitrationArchives arbitrationArchives) {
		arbitrationArchivesService.delete(arbitrationArchives);
		return renderResult(Global.TRUE, text("删除js_arbitration_archives成功！"));
	}
	
}