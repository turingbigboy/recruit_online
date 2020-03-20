package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Tag;
import com.yyjj.service.bo.TagBO;

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
public class TagVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
     
    public static  TagVO newInstance( Tag  tag) {
        if(Objects.isNull( tag)) {
  	    return null;
  	  }        
         TagVO  tagVO = new  TagVO();
        BeanUtils.copyProperties( tag,  tagVO);
        return  tagVO;
  	}
    
    public static  TagVO newInstance( TagBO  tag) {
        if(Objects.isNull( tag)) {
  	    return null;
  	  }        
         TagVO  tagVO = new  TagVO();
        BeanUtils.copyProperties( tag,  tagVO);
        return  tagVO;
  	}
  	    
  	public  Tag convert() {
  		 Tag  tag = new  Tag();
  	  BeanUtils.copyProperties(this,  tag);
  	  return  tag;
  	}
  	
  	public  TagBO  TagBO() {
  		 TagBO  tag = new  TagBO();
  	  BeanUtils.copyProperties(this,  tag);
  	  return  tag;
  	}
  	
  }