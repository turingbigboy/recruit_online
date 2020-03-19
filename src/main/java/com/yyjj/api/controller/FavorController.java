package com.yyjj.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.yyjj.db.model.Favor;
import com.yyjj.api.vo.FavorVO;
import com.yyjj.service.service.FavorService;
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
 * Favor
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/favor")
public class FavorController {
		
	@Autowired
	FavorService favorService;
	
	/**
	 * ${controllerName}
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<FavorVO> listBasePage(FavorVO vo){
		return AjaxResult.success("",favorService.listPage(new QueryWrapper<Favor>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *${controllerName}
	 * @param id Favorid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<FavorVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(favorService.getById(id)));
	}
	
	
	/**
	 * Favor
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<FavorVO> add(@RequestBody @Validated FavorVO vo) {
		boolean result = favorService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * Favor
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<FavorVO> modify(@RequestBody @Validated FavorVO vo) {
		boolean result = favorService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * Favor
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult remove(@PathVariable Integer id) {
		boolean result = favorService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<FavorVO> convert(BasePage<Favor> basePage) {
		List<FavorVO> resultList = new ArrayList<FavorVO>();
					
		for (Favor favor : basePage.getRecords()) {
			resultList.add(convert(favor));
		}
		BasePage<FavorVO> result = new BasePage<FavorVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private FavorVO convert(Favor favor){
			FavorVO vo = FavorVO.newInstance(favor);
			//TODO
			return vo;
	}
	
}
