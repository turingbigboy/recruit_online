package com.yyjj.api.controller;

import java.time.LocalDateTime;
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
import com.yyjj.api.vo.AdminVO;
import com.yyjj.api.vo.StatisticsVO;
import com.yyjj.db.model.Admin;
import com.yyjj.db.model.DropBox;
import com.yyjj.db.model.User;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.AdminService;
import com.yyjj.service.service.CompanyService;
import com.yyjj.service.service.DropBoxService;
import com.yyjj.service.service.UserService;


/**
 * Admin
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	AdminService adminService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DropBoxService dropBoxService;
	/**
	 * 分页查询管理员列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<AdminVO> listBasePage(AdminVO vo){
		return AjaxResult.success("",adminService.listPage(new QueryWrapper<Admin>(vo.convert())).converterAll(this::convert));
	}
	
	@GetMapping("statistics")
	public AjaxResult<StatisticsVO> statistics(){
		StatisticsVO vo = new StatisticsVO();
		vo.setCompanyCount(companyService.count());
		
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime firstDateTime = LocalDateTime.of(startTime.getYear(), startTime.getMonthValue(),1,0,0);
		LocalDateTime lastDateTime = firstDateTime.plusMonths(1);
		Integer count = userService.lambdaQuery().ge(User::getCreateTime,firstDateTime).le(User::getCreateTime, lastDateTime).count();		
		vo.setNewUserCount(count);
		Integer count2 = dropBoxService.lambdaQuery().ge(DropBox::getCreateTime,firstDateTime).le(DropBox::getCreateTime, lastDateTime).count();		
		vo.setOfferCount(count2);		
		return AjaxResult.success("", vo);
	}
	
	
	/**
	 * 管理登录
	 * @param vo
	 * @return
	 */
	@PostMapping("/login")
	public AjaxResult<AdminVO> login(@RequestBody @Validated AdminVO admin,HttpServletRequest request) {
		Admin u = adminService.lambdaQuery().eq(Admin::getAccount, admin.getAccount()).one();
		if (Objects.isNull(u)) {
			return AjaxResult.failed("登陆失败！无此账户");
		}
		adminService.lambdaQuery().eq(Admin::getAccount, admin.getAccount()).eq(Admin::getPassword, admin.getPassword())
				.one();
		if (u.getPassword().equals(admin.getPassword())) {
			request.getSession().setAttribute("admin", u);
			return AjaxResult.success("登陆成功！欢迎您" + u.getName(), u);
		} else {
			return AjaxResult.failed("登陆失败！密码错误");
		}
	}
	
	/**
	 *管理员详情
	 * @param id Adminid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<AdminVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(adminService.getById(id)));
	}
	
	
	/**
	 * 新增管理元
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<AdminVO> add(@RequestBody @Validated AdminVO vo) {
		boolean result = adminService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改管理员
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<AdminVO> modify(@RequestBody @Validated AdminVO vo) {
		boolean result = adminService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除管理员
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = adminService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<AdminVO> convert(BasePage<Admin> basePage) {
		List<AdminVO> resultList = new ArrayList<AdminVO>();
					
		for (Admin admin : basePage.getRecords()) {
			resultList.add(convert(admin));
		}
		BasePage<AdminVO> result = new BasePage<AdminVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private AdminVO convert(Admin admin){
			AdminVO vo = AdminVO.newInstance(admin);
			//TODO
			return vo;
	}
	
}
