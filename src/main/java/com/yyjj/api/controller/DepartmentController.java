package com.yyjj.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.yyjj.db.model.Department;
import com.yyjj.api.vo.DepartmentVO;
import com.yyjj.service.service.DepartmentService;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Department
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/department")
public class DepartmentController {
		
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * ${controllerName}
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<DepartmentVO> listBasePage(DepartmentVO vo){
		return AjaxResult.success("",departmentService.listPage(new QueryWrapper<Department>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *${controllerName}
	 * @param id Departmentid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<DepartmentVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(departmentService.getById(id)));
	}
	
	
	/**
	 * Department
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<DepartmentVO> add(@RequestBody @Validated DepartmentVO vo) {
		boolean result = departmentService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * Department
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<DepartmentVO> modify(@RequestBody @Validated DepartmentVO vo) {
		boolean result = departmentService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * Department
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult remove(@PathVariable Integer id) {
		boolean result = departmentService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<DepartmentVO> convert(BasePage<Department> basePage) {
		List<DepartmentVO> resultList = new ArrayList<DepartmentVO>();
					
		for (Department department : basePage.getRecords()) {
			resultList.add(convert(department));
		}
		BasePage<DepartmentVO> result = new BasePage<DepartmentVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private DepartmentVO convert(Department department){
			DepartmentVO vo = DepartmentVO.newInstance(department);
			//TODO
			return vo;
	}
	
}
