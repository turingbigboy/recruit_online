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
import com.yyjj.api.vo.LableVO;
import com.yyjj.db.model.Lable;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.LableService;


/**
 * Lable
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/lable")
public class LableController {
		
	@Autowired
	LableService lableService;
	
	/**
	 * 分页查询分类职位
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<LableVO> listBasePage(LableVO vo){
		return AjaxResult.success("",lableService.listPage(new QueryWrapper<Lable>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *分类职位详情
	 * @param id Lableid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<LableVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(lableService.getById(id)));
	}
	
	
	/**
	 *新增分类职位
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<LableVO> add(@RequestBody @Validated LableVO vo) {
		boolean result = lableService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改分类职位
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<LableVO> modify(@RequestBody @Validated LableVO vo) {
		boolean result = lableService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除分类职位
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = lableService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<LableVO> convert(BasePage<Lable> basePage) {
		List<LableVO> resultList = new ArrayList<LableVO>();
					
		for (Lable lable : basePage.getRecords()) {
			resultList.add(convert(lable));
		}
		BasePage<LableVO> result = new BasePage<LableVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private LableVO convert(Lable lable){
			LableVO vo = LableVO.newInstance(lable);
			//TODO
			return vo;
	}
	
}
