package com.yyjj.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
import com.yyjj.api.vo.CommentVO;
import com.yyjj.api.vo.CompanyVO;
import com.yyjj.api.vo.HrVO;
import com.yyjj.api.vo.PositionVO;
import com.yyjj.db.model.Comment;
import com.yyjj.db.model.Company;
import com.yyjj.db.model.Hr;
import com.yyjj.db.model.Lable;
import com.yyjj.db.model.Position;
import com.yyjj.db.model.Sort;
import com.yyjj.db.model.Tag;
import com.yyjj.db.model.User;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.CommentService;
import com.yyjj.service.service.CompanyService;
import com.yyjj.service.service.HrService;
import com.yyjj.service.service.LableService;
import com.yyjj.service.service.PositionService;
import com.yyjj.service.service.SortService;
import com.yyjj.service.service.TagService;
import com.yyjj.service.service.UserMakeService;
import com.yyjj.service.service.UserService;

/**
 * 职位
 * 
 * @author yml
 *
 */
@SuppressWarnings("unchecked")
@RestController
@RequestMapping("/position")
public class PositionController {

	@Autowired
	PositionService positionService;

	@Autowired
	HrService hrService;

	@Autowired
	CompanyService companyService;

	@Autowired
	TagService tagService;
	
	@Autowired
	LableService lableService;
	@Autowired
	SortService sortService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMakeService userMakeService;
	/**
	 * 分页查询职位列表
	 * 
	 * @param vo
	 * @return
	 */
	@GetMapping
	public AjaxResult<PositionVO> listBasePage(PositionVO vo) {
		return AjaxResult.success("",
				positionService.listPage(new QueryWrapper<Position>(vo.convert())).converterAll(this::convert));
	}
	/**
	 * 根据分类查询职位列表
	 * 
	 * @param vo
	 * @return
	 */
	@GetMapping("/sort/{sortId:\\d+}")
	public AjaxResult<PositionVO> listBasePageBySort(@PathVariable Integer sortId,PositionVO vo) {
		return AjaxResult.success("",
				positionService.listPage(new QueryWrapper<Position>(vo.convert()).lambda().inSql(Position::getId
						, "select position_id from Lable where lable_sort_id ="+sortId))
				.converterAll(this::convert));
	}
	/**
	 * 根据标题查询职位列表
	 * 
	 * @param vo
	 * @return
	 */
	@GetMapping("/title")
	public AjaxResult<PositionVO> listBasePageBySort(PositionVO vo) {
		
		if(Objects.isNull(vo)||Objects.isNull(vo.getTitle())) {
			vo = new PositionVO();
			vo.setTitle("");
		}
		return AjaxResult.success("",
				positionService.listPage(new QueryWrapper<Position>().lambda().like(Position::getTitle, vo.getTitle()))
				.converterAll(this::convert));
	}
	/**
	 * 职位详情
	 * 
	 * @param id Positionid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<PositionVO> Detail(@PathVariable Integer id) {
		Position position = positionService.getById(id);
		position.setHits(position.getHits()+1);
		positionService.updateById(position);
		return AjaxResult.success("", convert(position));
	}

	/**
	 * 新增职位
	 * 
	 * @param vo
	 * @return
	 * 
	 */
	@PostMapping
	public AjaxResult<PositionVO> add(@RequestBody @Validated PositionVO vo) {
		boolean result = positionService.save(vo.convert());
		if (result) {
			return AjaxResult.success("新增成功");
		}

		return AjaxResult.failed("新增失败");
	}

	/**
	 * 修改职位
	 * 
	 * @param vo
	 * @return
	 * 
	 */
	@PutMapping
	public AjaxResult<PositionVO> modify(@RequestBody @Validated PositionVO vo) {
		boolean result = positionService.updateById(vo.convert());
		if (result) {
			return AjaxResult.success("修改成功");
		}

		return AjaxResult.failed("修改失败");
	}

	/**
	 * 删除职位
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id:\\d+}")
	public AjaxResult<Boolean> remove(@PathVariable Integer id) {
		boolean result = positionService.removeById(id);
		if (result) {
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.failed("删除失败");
	}

	private BasePage<PositionVO> convert(BasePage<Position> basePage) {
		List<PositionVO> resultList = new ArrayList<PositionVO>();

		for (Position position : basePage.getRecords()) {
			resultList.add(convert(position));
		}
		BasePage<PositionVO> result = new BasePage<PositionVO>(basePage.getPage(), basePage.getPageSize(),
				basePage.getCurrent(), basePage.getTotal(), resultList);
		return result;
	}

	private PositionVO convert(Position position) {
		PositionVO vo = PositionVO.newInstance(position);
		
		Hr hr = hrService.getById(vo.getHrId());
		if (Objects.nonNull(hr)) {
			Company company = companyService.getById(hr.getCompanyId());
			if (Objects.nonNull(company)) {
				vo.setCompanyId(company.getId());
				vo.setCompanyName(company.getCompanyName());
			}
			vo.setCompany(CompanyVO.newInstance(company));
			vo.setHr(HrVO.newInstance(hr));
			List<Lable> list = lableService.lambdaQuery().eq(Lable::getPositionId, vo.getId()).list();
			if(!CollectionUtils.isEmpty(list)) {
				vo.setSorts(sortService.lambdaQuery().in(Sort::getId, list.stream().map(Lable::getLableSortId).collect(Collectors.toList())).list());
			}			
			List<Comment> Comments = commentService.lambdaQuery().eq(Comment::getPositionId, vo.getId()).list();
			List<CommentVO> commentVos = new ArrayList<CommentVO>();
			for (Comment comment : Comments) {
				CommentVO commentvo = CommentVO.newInstance(comment);
				User user = userService.getById(comment.getUserId());
				commentvo.setUser(user);
				commentVos.add(commentvo);
			}

			vo.setReviews(commentVos);
		}
		vo.setTags(tagService.lambdaQuery().eq(Tag::getTagType, 1).eq(Tag::getTypeId, vo.getId()).list());
		return vo;
	}

}
