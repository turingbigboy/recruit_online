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
import com.yyjj.api.vo.CommentVO;
import com.yyjj.db.model.Comment;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.CommentService;


/**
 * 评论
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/comment")
public class CommentController {
		
	@Autowired
	CommentService commentService;
	
	/**
	 * 分页查询评论
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<CommentVO> listBasePage(CommentVO vo){
		return AjaxResult.success("",commentService.listPage(new QueryWrapper<Comment>(vo.convert())).converterAll(this::convert));
	}
	
	/**
	 *评论详情
	 * @param id Commentid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<CommentVO> Detail(@PathVariable Integer id) {		
		return AjaxResult.success("",convert(commentService.getById(id)));
	}
	
	
	/**
	 * 新增评论
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<CommentVO> add(@RequestBody @Validated CommentVO vo) {
		boolean result = commentService.save(vo.convert());
		if(result) {
			return AjaxResult.success("新增成功");
		}
		
		return AjaxResult.failed("新增失败");	
	}
	
	/**
	 * 修改评论
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<CommentVO> modify(@RequestBody @Validated CommentVO vo) {
		boolean result = commentService.updateById(vo.convert());
		if(result) {
			return AjaxResult.success("修改成功");
		}
		
		return AjaxResult.failed("修改失败");	
	}
	
	/**
	 * 删除评论
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = commentService.removeById(id);
		if(result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}
	
	private BasePage<CommentVO> convert(BasePage<Comment> basePage) {
		List<CommentVO> resultList = new ArrayList<CommentVO>();
					
		for (Comment comment : basePage.getRecords()) {
			resultList.add(convert(comment));
		}
		BasePage<CommentVO> result = new BasePage<CommentVO>(basePage.getPage(),
				basePage.getPageSize(), basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}
	private CommentVO convert(Comment comment){
			CommentVO vo = CommentVO.newInstance(comment);
			//TODO
			return vo;
	}
	
}
