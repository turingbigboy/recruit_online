package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyjj.db.model.Classify;
import com.yyjj.service.bo.ClassifyBO;

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
public class ClassifyVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 一级类别Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 一级类别名称
     */
    private String name;
    
    /**
     * 二级类别
     */
    private List<SortVO> sorts;
    public static  ClassifyVO newInstance( Classify  classify) {
        if(Objects.isNull( classify)) {
  	    return null;
  	  }        
         ClassifyVO  classifyVO = new  ClassifyVO();
        BeanUtils.copyProperties( classify,  classifyVO);
        return  classifyVO;
  	}
    
    public static  ClassifyVO newInstance( ClassifyBO  classify) {
        if(Objects.isNull( classify)) {
  	    return null;
  	  }        
         ClassifyVO  classifyVO = new  ClassifyVO();
        BeanUtils.copyProperties( classify,  classifyVO);
        return  classifyVO;
  	}
  	    
  	public  Classify convert() {
  		 Classify  classify = new  Classify();
  	  BeanUtils.copyProperties(this,  classify);
  	  return  classify;
  	}
  	
  	public  ClassifyBO  ClassifyBO() {
  		 ClassifyBO  classify = new  ClassifyBO();
  	  BeanUtils.copyProperties(this,  classify);
  	  return  classify;
  	}
  	
  }