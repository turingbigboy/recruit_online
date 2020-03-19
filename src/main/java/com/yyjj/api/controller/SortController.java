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
import com.yyjj.api.vo.SortVO;
import com.yyjj.db.model.Sort;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.SortService;


/**
 * 二级分类
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/sort")
public class SortController {
		
	@Autowired
	SortService sortService;
	
	/**
	 * 分页查询二级分类
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<SortVO> listBasePage(SortVO vo){
		return AjaxResult.success("",sortService.listPage(new QueryWrapper<Sort>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *二级分类详情
	 * @param id Sortid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<SortVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(sortService.getById(id)));
	}
	
	
	/**
	 * 新增二级分类
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<SortVO> add(@RequestBody @Validated SortVO vo) {
		boolean result = sortService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改二级分类
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<SortVO> modify(@RequestBody @Validated SortVO vo) {
		boolean result = sortService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除二级分类
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = sortService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<SortVO> convert(BasePage<Sort> basePage) {
		List<SortVO> resultList = new ArrayList<SortVO>();
					
		for (Sort sort : basePage.getRecords()) {
			resultList.add(convert(sort));
		}
		BasePage<SortVO> result = new BasePage<SortVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private SortVO convert(Sort sort){
			SortVO vo = SortVO.newInstance(sort);
			//TODO
			return vo;
	}
	
}
