package com.yyjj.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyjj.api.vo.AdminVO;
import com.yyjj.db.model.Admin;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.AdminService;


/**
 * Admin
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	AdminService adminService;
	
	/**
	 * 分页查询管理员列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<AdminVO> listBasePage(AdminVO vo){
		return AjaxResult.success("",adminService.listPage(new QueryWrapper<Admin>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *管理员详情
	 * @param id Adminid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<AdminVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(adminService.getById(id)));
	}
	
	
	/**
	 * 新增管理元
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<AdminVO> add(@RequestBody @Validated AdminVO vo) {
		boolean result = adminService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改管理员
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<AdminVO> modify(@RequestBody @Validated AdminVO vo) {
		boolean result = adminService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除管理员
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = adminService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<AdminVO> convert(BasePage<Admin> basePage) {
		List<AdminVO> resultList = new ArrayList<AdminVO>();
					
		for (Admin admin : basePage.getRecords()) {
			resultList.add(convert(admin));
		}
		BasePage<AdminVO> result = new BasePage<AdminVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private AdminVO convert(Admin admin){
			AdminVO vo = AdminVO.newInstance(admin);
			//TODO
			return vo;
	}
	
}
