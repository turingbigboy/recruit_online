package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyjj.db.model.Sort;
import com.yyjj.service.bo.SortBO;

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
public class SortVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 类别ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 附属一级类别Id
     */
    private Integer classId;
     
    public static  SortVO newInstance( Sort  sort) {
        if(Objects.isNull( sort)) {
  	    return null;
  	  }        
         SortVO  sortVO = new  SortVO();
        BeanUtils.copyProperties( sort,  sortVO);
        return  sortVO;
  	}
    
    public static  SortVO newInstance( SortBO  sort) {
        if(Objects.isNull( sort)) {
  	    return null;
  	  }        
         SortVO  sortVO = new  SortVO();
        BeanUtils.copyProperties( sort,  sortVO);
        return  sortVO;
  	}
  	    
  	public  Sort convert() {
  		 Sort  sort = new  Sort();
  	  BeanUtils.copyProperties(this,  sort);
  	  return  sort;
  	}
  	
  	public  SortBO  SortBO() {
  		 SortBO  sort = new  SortBO();
  	  BeanUtils.copyProperties(this,  sort);
  	  return  sort;
  	}
  	
  }