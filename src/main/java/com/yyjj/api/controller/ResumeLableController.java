package com.yyjj.api.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.yyjj.db.model.ResumeLable;
import com.yyjj.api.vo.ResumeLableVO;
import com.yyjj.service.service.ResumeLableService;
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
 * ResumeLable
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/resumelable")
public class ResumeLableController {
		
	@Autowired
	ResumeLableService resumelableService;
	
	/**
	 * ${controllerName}
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<ResumeLableVO> listBasePage(ResumeLableVO vo){
		return AjaxResult.success("",resumelableService.listPage(new QueryWrapper<ResumeLable>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *${controllerName}
	 * @param id ResumeLableid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<ResumeLableVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(resumelableService.getById(id)));
	}
	
	
	/**
	 * ResumeLable
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<ResumeLableVO> add(@RequestBody @Validated ResumeLableVO vo) {
		boolean result = resumelableService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * ResumeLable
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<ResumeLableVO> modify(@RequestBody @Validated ResumeLableVO vo) {
		boolean result = resumelableService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * ResumeLable
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = resumelableService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<ResumeLableVO> convert(BasePage<ResumeLable> basePage) {
		List<ResumeLableVO> resultList = new ArrayList<ResumeLableVO>();
					
		for (ResumeLable resumelable : basePage.getRecords()) {
			resultList.add(convert(resumelable));
		}
		BasePage<ResumeLableVO> result = new BasePage<ResumeLableVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private ResumeLableVO convert(ResumeLable resumelable){
			ResumeLableVO vo = ResumeLableVO.newInstance(resumelable);
			//TODO
			return vo;
	}
	
}
