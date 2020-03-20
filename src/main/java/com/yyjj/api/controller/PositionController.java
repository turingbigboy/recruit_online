package com.yyjj.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import com.yyjj.db.model.Company;
import com.yyjj.db.model.Hr;
import com.yyjj.db.model.Position;
import com.yyjj.db.model.Tag;
import com.yyjj.domain.context.AjaxResult;
import com.yyjj.domain.service.BasePage;
import com.yyjj.service.service.CompanyService;
import com.yyjj.service.service.HrService;
import com.yyjj.service.service.PositionService;
import com.yyjj.service.service.TagService;

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
	 * 职位详情
	 * 
	 * @param id Positionid
	 * @return
	 */
	@GetMapping("/{id:\\d+}")
	public AjaxResult<PositionVO> Detail(@PathVariable Integer id) {
		return AjaxResult.success("", convert(positionService.getById(id)));
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
		}
		vo.setTags(tagService.lambdaQuery().eq(Tag::getTagType, 1).eq(Tag::getTypeId, vo.getId()).list());
		return vo;
	}

}
