package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Lable;
import com.yyjj.db.model.Sort;
import com.yyjj.service.bo.LableBO;

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
public class LableVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer lableClassId;

    private Integer lableSortId;
    
    private Sort sort;
    private Integer positionId;
     
    public static  LableVO newInstance( Lable  lable) {
        if(Objects.isNull( lable)) {
  	    return null;
  	  }        
         LableVO  lableVO = new  LableVO();
        BeanUtils.copyProperties( lable,  lableVO);
        return  lableVO;
  	}
    
    public static  LableVO newInstance( LableBO  lable) {
        if(Objects.isNull( lable)) {
  	    return null;
  	  }        
         LableVO  lableVO = new  LableVO();
        BeanUtils.copyProperties( lable,  lableVO);
        return  lableVO;
  	}
  	    
  	public  Lable convert() {
  		 Lable  lable = new  Lable();
  	  BeanUtils.copyProperties(this,  lable);
  	  return  lable;
  	}
  	
  	public  LableBO  LableBO() {
  		 LableBO  lable = new  LableBO();
  	  BeanUtils.copyProperties(this,  lable);
  	  return  lable;
  	}
  	
  }