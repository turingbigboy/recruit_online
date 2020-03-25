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
import com.yyjj.api.vo.PositionVO;
import com.yyjj.api.vo.UserMakeVO;
import com.yyjj.api.vo.UserVO;
import com.yyjj.db.model.User;
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
	 * 用户是否收藏简历
	 * @param id Userid
	 * @return
	 */
	
	@GetMapping("/is_mark/{positionId:\\d+}")
	public AjaxResult<UserMakeVO> Detail(@PathVariable Integer positionId,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if(Objects.isNull(user)) {
			return AjaxResult.success("",false);
		}
		UserMake one = usermakeService.lambdaQuery().eq(UserMake::getPositionId, positionId)
			.eq(UserMake::getUserId, user.getUserId()).one();
		if(Objects.nonNull(one)) {
			return AjaxResult.success("",true);
		}else {
			return AjaxResult.success("",false);
		}
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
			return AjaxResult.success("收藏成功");
		}
		
		return AjaxResult.failed("收藏失败");	
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
	@DeleteMapping("/unmake")
	public AjaxResult<Boolean> remove(UserMakeVO vo) {
		boolean result = usermakeService.remove(
				new QueryWrapper<UserMake>().lambda()
				.eq(UserMake::getPositionId, vo.getPositionId())
				.eq(UserMake::getUserId, vo.getUserId()));
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
