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
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yyjj.api.vo.UserVO;
import com.yyjj.db.model.User;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.UserService;


/**
 * User
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/user")
public class UserController {
		
	@Autowired
	UserService userService;
	
	/**
	 * 用户登录
	 * @param vo
	 * @return
	 */
	@PostMapping("/login")
	public AjaxResult<UserVO> login(@RequestBody @Validated UserVO user,HttpServletRequest request) {
		User u = userService.lambdaQuery().eq(User::getAccount, user.getAccount()).one();
		if (Objects.isNull(u)) {
			return AjaxResult.failed("登陆失败！无此账户");
		}
		userService.lambdaQuery().eq(User::getAccount, user.getAccount()).eq(User::getPassword, user.getPassword())
				.one();
		if (u.getPassword().equals(user.getPassword())) {
			request.getSession().setAttribute("user", u);
			return AjaxResult.success("登陆成功！欢迎您" + u.getName(), u);
		} else {
			return AjaxResult.failed("登陆失败！密码错误");
		}
	}
	
	/**
	 * 注册账户
	 * 
	 * @return
	 */
	@PostMapping("/register")
	public AjaxResult<UserVO> register(@RequestBody @Validated UserVO user) {
		User u = userService.lambdaQuery().eq(User::getAccount, user.getAccount()).one();
		if (Objects.isNull(u)) {
			userService.save(user.convert());
		} else {
			return AjaxResult.failed("注册失败！账户名称重复");
		}
		return AjaxResult.success("注册成功！请登录", user);
	}
	
	/**
	 * 用户列表
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<UserVO> listBasePage(UserVO vo){
		return AjaxResult.success("",userService.listPage(new QueryWrapper<User>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *用户详情
	 * @param id Userid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<UserVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(userService.getById(id)));
	}
	
	
	/**
	 * 新增用户
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<UserVO> add(@RequestBody @Validated UserVO vo) {
		boolean result = userService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改用户
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<UserVO> modify(@RequestBody UserVO vo) {
		boolean result = userService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 启用用户
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping("{id:\\d+}/enable")
	public AjaxResult<UserVO> enable(@PathVariable Integer id) {
		boolean result = userService.update(new UpdateWrapper<User>().lambda().eq(User::getUserId, id).set(User::getState, 1));
		if(result) {
			return AjaxResult.success("启用成功");
		}
		
		return AjaxResult.failed("启用失败");	
	}
	
	/**
	 * 停用用户
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping("{id:\\d+}/disable")
	public AjaxResult<UserVO> disable(@PathVariable Integer id) {
		boolean result = userService.update(new UpdateWrapper<User>().lambda().eq(User::getUserId, id).set(User::getState, 0));
		if(result) {
			return AjaxResult.success("启用成功");
		}		
		return AjaxResult.failed("启用失败");	
	}
	
	/**
	 * 删除用户
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = userService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<UserVO> convert(BasePage<User> basePage) {
		List<UserVO> resultList = new ArrayList<UserVO>();
					
		for (User user : basePage.getRecords()) {
			resultList.add(convert(user));
		}
		BasePage<UserVO> result = new BasePage<UserVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private UserVO convert(User user){
			UserVO vo = UserVO.newInstance(user);
			//TODO
			return vo;
	}
	
}
