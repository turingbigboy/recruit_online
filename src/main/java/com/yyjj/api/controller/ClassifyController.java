package com.yyjj.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import com.yyjj.api.vo.ClassifyVO;
import com.yyjj.db.model.Classify;
import com.yyjj.db.model.Sort;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.ClassifyService;
import com.yyjj.service.service.SortService;


/**
 * 一级分类
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/classify")
public class ClassifyController {
		
	@Autowired
	ClassifyService classifyService;
	@Autowired
	SortService sortService;
	/**
	 * 一级类型列表 
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<ClassifyVO> listBasePage(ClassifyVO vo){
		return AjaxResult.success("",classifyService.listPage(vo.convert()).converterAll(this::convert));
	}
	
	/**
	 * 所有类型
	 * @return
	 */
	@GetMapping("/all")
	public AjaxResult<ClassifyVO> listAllClass() {
		List<Classify> list = classifyService.list();
		return  AjaxResult.success("",list);
	}
	/**
	 *查询指定类型
	 * @param id Classifyid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<ClassifyVO> findById(@PathVariable Integer id) {		
		return AjaxResult.success("",classifyService.getById(id));
	}
	
	/**
	 * 新增类型
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<ClassifyVO> add(@RequestBody @Validated ClassifyVO vo) {
		boolean result = classifyService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功",vo);	
		}else {
			return AjaxResult.failed("新增失败");
		}
	
	}
	
	/**
	 * 修改类型
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<ClassifyVO> modify(@RequestBody @Validated ClassifyVO vo) {
		boolean result = classifyService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功",vo);	
		}else {
			return AjaxResult.failed("修改失败");
		}	
	}
	
	/**
	 * 删除分类
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		List<Sort> productSorts = sortService.lambdaQuery().eq(Sort::getClassId, id).list();
		if(! CollectionUtils.isEmpty(productSorts)) {
			sortService.removeByIds(
					productSorts.stream().map(Sort::getClassId)
					.collect(Collectors.toList())
					);
		}
		boolean result = classifyService.removeById(id);
		
		if(result) {
			return AjaxResult.success("删除成功");	
		}else {
			return AjaxResult.failed("删除失败");
		}	
	}
	
	
	private BasePage<ClassifyVO> convert(BasePage<Classify> basePage) {
		List<ClassifyVO> resultList = new ArrayList<ClassifyVO>();
					
		for (Classify classify : basePage.getRecords()) {
			resultList.add(convert(classify));
		}
		BasePage<ClassifyVO> result = new BasePage<ClassifyVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private ClassifyVO convert(Classify classify){
			ClassifyVO vo = ClassifyVO.newInstance(classify);
			//TODO
			return vo;
	}
	
}
