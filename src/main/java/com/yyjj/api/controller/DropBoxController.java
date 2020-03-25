package com.yyjj.api.controller;

import java.time.LocalDateTime;
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
import com.yyjj.api.vo.DropBoxVO;
import com.yyjj.db.model.DropBox;
import com.yyjj.db.model.Resume;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.DropBoxService;
import com.yyjj.service.service.ResumeService;
import com.yyjj.service.service.UserService;


/**
 * 投递箱
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/dropbox")
public class DropBoxController {
		
	@Autowired
	DropBoxService dropboxService;
	@Autowired
	UserService userService;
	@Autowired
	ResumeService resumeService;
	/**
	 * 分页投递箱列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<DropBoxVO> listBasePage(DropBoxVO vo){
		return AjaxResult.success("",dropboxService.listPage(new QueryWrapper<DropBox>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *投递箱详情
	 * @param id DropBoxid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<DropBoxVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(dropboxService.getById(id)));
	}
	
	
	/**
	 * 新增投递
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<DropBoxVO> add(@RequestBody @Validated DropBoxVO vo) {
		Integer userId = vo.getUserId();
		List<Resume> list = resumeService.lambdaQuery().eq(Resume::getUserId, userId).list();
		vo.setResumeId(list.get(0).getId());
		vo.setCreateTime(LocalDateTime.now());
		boolean result = dropboxService.save(vo.convert());
		if(result) {
			return AjaxResult.success("投递成功");
		}
		
		return AjaxResult.failed("投递失败");	
	}
	
	/**
	 * 修改投递箱
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<DropBoxVO> modify(@RequestBody @Validated DropBoxVO vo) {
		boolean result = dropboxService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除投递箱
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = dropboxService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<DropBoxVO> convert(BasePage<DropBox> basePage) {
		List<DropBoxVO> resultList = new ArrayList<DropBoxVO>();
					
		for (DropBox dropbox : basePage.getRecords()) {
			resultList.add(convert(dropbox));
		}
		BasePage<DropBoxVO> result = new BasePage<DropBoxVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private DropBoxVO convert(DropBox dropbox){
			DropBoxVO vo = DropBoxVO.newInstance(dropbox);
			//TODO
			return vo;
	}
	
}
