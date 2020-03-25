package com.yyjj.api.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Position;
import com.yyjj.db.model.Sort;
import com.yyjj.db.model.Tag;
import com.yyjj.db.model.User;
import com.yyjj.service.bo.PositionBO;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * 
 */
@Getter
@Setter
public class PositionVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * id
     */
    private Integer id;
    
    private Boolean mark;
    /**
     * 职位标题
     */
    private String title;

    /**
     * 职位要求
     */
    private String requirement;

    /**
     * 招聘数量
     */
    private Integer quantity;

    /**
     * 工作地点
     */
    private String workCity;

    /**
     * 最高薪资
     */
    private Integer salaryUp;

    /**
     * 最低薪资
     */
    private Integer salaryDown;

    /**
     * 发布时间
     */
    private LocalDate releaseDate;

    /**
     * 有效时间
     */
    private LocalDate validDate;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 阅读量
     */
    private Integer hits;

    /**
     * hrid
     */
    private Integer hrId;
     
    private Integer companyId;
    private String companyName;
    
    private List<Tag> tags;
    
    private CompanyVO company;
    private HrVO hr;
    private List<CommentVO> reviews;
    private List<Sort> sorts;
    private User user;
    public static  PositionVO newInstance( Position  position) {
        if(Objects.isNull( position)) {
  	    return null;
  	  }        
         PositionVO  positionVO = new  PositionVO();
        BeanUtils.copyProperties( position,  positionVO);
        return  positionVO;
  	}
    
    public static  PositionVO newInstance( PositionBO  position) {
        if(Objects.isNull( position)) {
  	    return null;
  	  }        
         PositionVO  positionVO = new  PositionVO();
        BeanUtils.copyProperties( position,  positionVO);
        return  positionVO;
  	}
  	    
  	public  Position convert() {
  		 Position  position = new  Position();
  	  BeanUtils.copyProperties(this,  position);
  	  return  position;
  	}
  	
  	public  PositionBO  PositionBO() {
  		 PositionBO  position = new  PositionBO();
  	  BeanUtils.copyProperties(this,  position);
  	  return  position;
  	}
  	
  }