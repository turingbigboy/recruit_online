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
import com.yyjj.api.vo.HrVO;
import com.yyjj.db.model.Hr;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.HrService;


/**
 * Hr
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/hr")
public class HrController {
		
	@Autowired
	HrService hrService;
	
	/**
	 * 分页查询hr列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<HrVO> listBasePage(HrVO vo){
		return AjaxResult.success("",hrService.listPage(new QueryWrapper<Hr>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 * hr登录
	 * @param vo
	 * @return
	 */
	@PostMapping("/login")
	public AjaxResult<HrVO> login(@RequestBody @Validated HrVO hr,HttpServletRequest request) {
		Hr u = hrService.lambdaQuery().eq(Hr::getAccount, hr.getAccount()).one();
		if (Objects.isNull(u)) {
			return AjaxResult.failed("登陆失败！无此账户");
		}
		hrService.lambdaQuery().eq(Hr::getAccount, hr.getAccount()).eq(Hr::getPassword, hr.getPassword())
				.one();
		if (u.getPassword().equals(hr.getPassword())) {
			request.getSession().setAttribute("hr", u);
			return AjaxResult.success("登陆成功！欢迎您" + u.getName(), u);
		} else {
			return AjaxResult.failed("登陆失败！密码错误");
		}
	}
	
	/**
	 * 注册hr账户
	 * 
	 * @return
	 */
	@PostMapping("/register")
	public AjaxResult<HrVO> register(@RequestBody @Validated HrVO hr) {
		Hr u = hrService.lambdaQuery().eq(Hr::getAccount, hr.getAccount()).one();
		if (Objects.isNull(u)) {
			hrService.save(hr.convert());
		} else {
			return AjaxResult.failed("注册失败！账户名称重复");
		}
		return AjaxResult.success("注册成功！请登录", hr);
	}
	
	/**
	 *hr详情
	 * @param id Hrid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<HrVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(hrService.getById(id)));
	}
	
	
	/**
	 * 新增hr
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<HrVO> add(@RequestBody @Validated HrVO vo) {
		boolean result = hrService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改hr
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<HrVO> modify(@RequestBody @Validated HrVO vo) {
		boolean result = hrService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除Hr
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = hrService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<HrVO> convert(BasePage<Hr> basePage) {
		List<HrVO> resultList = new ArrayList<HrVO>();
					
		for (Hr hr : basePage.getRecords()) {
			resultList.add(convert(hr));
		}
		BasePage<HrVO> result = new BasePage<HrVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private HrVO convert(Hr hr){
			HrVO vo = HrVO.newInstance(hr);
			//TODO
			return vo;
	}
	
}
