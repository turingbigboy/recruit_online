package com.yyjj.api.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.yyjj.db.model.Company;
import com.yyjj.api.vo.CompanyVO;
import com.yyjj.service.service.CompanyService;
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
 * Company
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/company")
public class CompanyController {
		
	@Autowired
	CompanyService companyService;
	
	/**
	 * ${controllerName}
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<CompanyVO> listBasePage(CompanyVO vo){
		return AjaxResult.success("",companyService.listPage(new QueryWrapper<Company>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *${controllerName}
	 * @param id Companyid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<CompanyVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(companyService.getById(id)));
	}
	
	
	/**
	 * Company
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<CompanyVO> add(@RequestBody @Validated CompanyVO vo) {
		boolean result = companyService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * Company
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<CompanyVO> modify(@RequestBody @Validated CompanyVO vo) {
		boolean result = companyService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * Company
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = companyService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<CompanyVO> convert(BasePage<Company> basePage) {
		List<CompanyVO> resultList = new ArrayList<CompanyVO>();
					
		for (Company company : basePage.getRecords()) {
			resultList.add(convert(company));
		}
		BasePage<CompanyVO> result = new BasePage<CompanyVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private CompanyVO convert(Company company){
			CompanyVO vo = CompanyVO.newInstance(company);
			//TODO
			return vo;
	}
	
}
