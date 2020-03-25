package com.yyjj.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

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
import com.yyjj.api.vo.HrMakeVO;
import com.yyjj.db.model.Hr;
import com.yyjj.db.model.HrMake;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.HrMakeService;


/**
 * HrMake
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/hrmake")
public class HrMakeController {
		
	@Autowired
	HrMakeService hrmakeService;
	
	/**
	 * 分页查询hr收藏简历
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<HrMakeVO> listBasePage(HrMakeVO vo){
		return AjaxResult.success("",hrmakeService.listPage(new QueryWrapper<HrMake>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *hr收藏简历详情
	 * @param id HrMakeid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<HrMakeVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(hrmakeService.getById(id)));
	}
	
	/**
	 * 用户是否收藏简历
	 * @param id Userid
	 * @return
	 */
	
	@GetMapping("/is_mark/{resumeId:\\d+}")
	public AjaxResult<HrMakeVO> Detail(@PathVariable Integer resumeId,HttpServletRequest request) {
		Hr hr = (Hr) request.getSession().getAttribute("hr");
		if(Objects.isNull(hr)) {
			return AjaxResult.success("",false);
		}
		HrMake one = hrmakeService.lambdaQuery().eq(HrMake::getResumeId, resumeId)
			.eq(HrMake::getId, hr.getId()).one();
		if(Objects.nonNull(one)) {
			return AjaxResult.success("",true);
		}else {
			return AjaxResult.success("",false);
		}
	}
	/**
	 * 新增hr收藏简历
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<HrMakeVO> add(@RequestBody @Validated HrMakeVO vo) {
		boolean result = hrmakeService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改hr收藏简历
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<HrMakeVO> modify(@RequestBody @Validated HrMakeVO vo) {
		boolean result = hrmakeService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除hr收藏
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = hrmakeService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<HrMakeVO> convert(BasePage<HrMake> basePage) {
		List<HrMakeVO> resultList = new ArrayList<HrMakeVO>();
					
		for (HrMake hrmake : basePage.getRecords()) {
			resultList.add(convert(hrmake));
		}
		BasePage<HrMakeVO> result = new BasePage<HrMakeVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private HrMakeVO convert(HrMake hrmake){
			HrMakeVO vo = HrMakeVO.newInstance(hrmake);
			//TODO
			return vo;
	}
	
}
