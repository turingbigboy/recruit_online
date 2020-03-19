package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.HrMake;
import com.yyjj.service.bo.HrMakeBO;

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
public class HrMakeVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * hr收藏id
     */
    private Integer id;

    /**
     * hrid
     */
    private Integer hrId;

    /**
     * 简历id
     */
    private Integer resumeId;
     
    public static  HrMakeVO newInstance( HrMake  hrmake) {
        if(Objects.isNull( hrmake)) {
  	    return null;
  	  }        
         HrMakeVO  hrmakeVO = new  HrMakeVO();
        BeanUtils.copyProperties( hrmake,  hrmakeVO);
        return  hrmakeVO;
  	}
    
    public static  HrMakeVO newInstance( HrMakeBO  hrmake) {
        if(Objects.isNull( hrmake)) {
  	    return null;
  	  }        
         HrMakeVO  hrmakeVO = new  HrMakeVO();
        BeanUtils.copyProperties( hrmake,  hrmakeVO);
        return  hrmakeVO;
  	}
  	    
  	public  HrMake convert() {
  		 HrMake  hrmake = new  HrMake();
  	  BeanUtils.copyProperties(this,  hrmake);
  	  return  hrmake;
  	}
  	
  	public  HrMakeBO  HrMakeBO() {
  		 HrMakeBO  hrmake = new  HrMakeBO();
  	  BeanUtils.copyProperties(this,  hrmake);
  	  return  hrmake;
  	}
  	
  }