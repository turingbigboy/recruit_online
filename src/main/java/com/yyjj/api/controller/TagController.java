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
import com.yyjj.api.vo.TagVO;
import com.yyjj.db.model.Tag;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.TagService;


/**
 * Tag
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/tag")
public class TagController {
		
	@Autowired
	TagService tagService;
	
	/**
	 * ${controllerName}
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<TagVO> listBasePage(TagVO vo){
		return AjaxResult.success("",tagService.listPage(new QueryWrapper<Tag>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *${controllerName}
	 * @param id Tagid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<TagVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(tagService.getById(id)));
	}
	
	
	/**
	 * Tag
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<TagVO> add(@RequestBody @Validated TagVO vo) {
		boolean result = tagService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * Tag
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<TagVO> modify(@RequestBody @Validated TagVO vo) {
		boolean result = tagService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * Tag
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = tagService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<TagVO> convert(BasePage<Tag> basePage) {
		List<TagVO> resultList = new ArrayList<TagVO>();
					
		for (Tag tag : basePage.getRecords()) {
			resultList.add(convert(tag));
		}
		BasePage<TagVO> result = new BasePage<TagVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private TagVO convert(Tag tag){
			TagVO vo = TagVO.newInstance(tag);
			//TODO
			return vo;
	}
	
}
