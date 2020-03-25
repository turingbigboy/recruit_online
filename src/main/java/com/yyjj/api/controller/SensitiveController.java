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
import com.yyjj.api.vo.SensitiveVO;
import com.yyjj.db.model.Sensitives;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.SensitiveService;


/**
 * 敏感词
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/sensitive")
public class SensitiveController {
		
	@Autowired
	SensitiveService sensitiveService;
	
	/**
	 * 分页查询敏感词列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<SensitiveVO> listBasePage(SensitiveVO vo){
		return AjaxResult.success("",sensitiveService.listPage(new QueryWrapper<Sensitives>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *敏感词详情
	 * @param id Sensitiveid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<SensitiveVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(sensitiveService.getById(id)));
	}
	
	
	/**
	 * 新增敏感词
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<SensitiveVO> add(@RequestBody @Validated SensitiveVO vo) {
		boolean result = sensitiveService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改敏感词
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<SensitiveVO> modify(@RequestBody @Validated SensitiveVO vo) {
		boolean result = sensitiveService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除敏感词
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = sensitiveService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<SensitiveVO> convert(BasePage<Sensitives> basePage) {
		List<SensitiveVO> resultList = new ArrayList<SensitiveVO>();
					
		for (Sensitives sensitive : basePage.getRecords()) {
			resultList.add(convert(sensitive));
		}
		BasePage<SensitiveVO> result = new BasePage<SensitiveVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private SensitiveVO convert(Sensitives sensitive){
			SensitiveVO vo = SensitiveVO.newInstance(sensitive);
			//TODO
			return vo;
	}
	
}
