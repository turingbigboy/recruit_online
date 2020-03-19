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
import com.yyjj.api.vo.ResumeVO;
import com.yyjj.db.model.Resume;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.ResumeService;


/**
 * 简历
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/resume")
public class ResumeController {
		
	@Autowired
	ResumeService resumeService;
	
	/**
	 *分页查询简历
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<ResumeVO> listBasePage(ResumeVO vo){
		return AjaxResult.success("",resumeService.listPage(new QueryWrapper<Resume>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *简历详情
	 * @param id Resumeid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<ResumeVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(resumeService.getById(id)));
	}
	
	
	/**
	 * 新增简历
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<ResumeVO> add(@RequestBody @Validated ResumeVO vo) {
		boolean result = resumeService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改简历
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<ResumeVO> modify(@RequestBody @Validated ResumeVO vo) {
		boolean result = resumeService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除简历
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = resumeService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<ResumeVO> convert(BasePage<Resume> basePage) {
		List<ResumeVO> resultList = new ArrayList<ResumeVO>();
					
		for (Resume resume : basePage.getRecords()) {
			resultList.add(convert(resume));
		}
		BasePage<ResumeVO> result = new BasePage<ResumeVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private ResumeVO convert(Resume resume){
			ResumeVO vo = ResumeVO.newInstance(resume);
			//TODO
			return vo;
	}
	
}
