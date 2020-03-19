package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Hr;
import com.yyjj.service.bo.HrBO;

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
public class HrVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * hr账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 名称
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职位描述
     */
    private String description;

    /**
     * 职位
     */
    private String department;

    /**
     * 所属公司
     */
    private Integer companyId;
     
    public static  HrVO newInstance( Hr  hr) {
        if(Objects.isNull( hr)) {
  	    return null;
  	  }        
         HrVO  hrVO = new  HrVO();
        BeanUtils.copyProperties( hr,  hrVO);
        return  hrVO;
  	}
    
    public static  HrVO newInstance( HrBO  hr) {
        if(Objects.isNull( hr)) {
  	    return null;
  	  }        
         HrVO  hrVO = new  HrVO();
        BeanUtils.copyProperties( hr,  hrVO);
        return  hrVO;
  	}
  	    
  	public  Hr convert() {
  		 Hr  hr = new  Hr();
  	  BeanUtils.copyProperties(this,  hr);
  	  return  hr;
  	}
  	
  	public  HrBO  HrBO() {
  		 HrBO  hr = new  HrBO();
  	  BeanUtils.copyProperties(this,  hr);
  	  return  hr;
  	}
  	
  }