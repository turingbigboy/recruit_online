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
import com.yyjj.api.vo.PositionVO;
import com.yyjj.api.vo.UserMakeVO;
import com.yyjj.api.vo.UserVO;
import com.yyjj.db.model.UserMake;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.PositionService;
import com.yyjj.service.service.UserMakeService;
import com.yyjj.service.service.UserService;

/**
 * 用户收藏
 * @author yml
 *
 */
@RestController
@RequestMapping("/usermake")
@SuppressWarnings("unchecked")
public class UserMakeController {
		
	@Autowired
	UserMakeService usermakeService;
	
	@Autowired
	PositionService positionService;
	
	@Autowired
	UserService userService;
	/**
	 * 分页查询用户收藏职位
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<UserMakeVO> listBasePage(UserMakeVO vo){
		return AjaxResult.success("",usermakeService.listPage(new QueryWrapper<UserMake>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 * 收藏职位详情
	 * @param id UserMakeid
	 * @return
	 */
	
	@GetMapping("/{id:\\d+}")
	public AjaxResult<UserMakeVO> Detail(@PathVariable Integer id) {	
		return AjaxResult.success("",convert(usermakeService.getById(id)));
	}
	
	
	/**
	 * 新增简历收藏
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<UserMakeVO> add(@RequestBody @Validated UserMakeVO vo) {
		boolean result = usermakeService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改用户收藏
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<UserMakeVO> modify(@RequestBody @Validated UserMakeVO vo) {
		boolean result = usermakeService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");		
	}
	
	/**
	 * 移除收藏
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = usermakeService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");	
	}
	
	private BasePage<UserMakeVO> convert(BasePage<UserMake> basePage) {
		List<UserMakeVO> resultList = new ArrayList<UserMakeVO>();
					
		for (UserMake usermake : basePage.getRecords()) {
			resultList.add(convert(usermake));
		}
		BasePage<UserMakeVO> result = new BasePage<UserMakeVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private UserMakeVO convert(UserMake usermake){
			UserMakeVO vo = UserMakeVO.newInstance(usermake);
			vo.setPosition(PositionVO.newInstance(positionService.getById(vo.getPositionId())));
			vo.setUser(UserVO.newInstance(userService.getById(vo.getUserId())));
			return vo;
	}
	
}
