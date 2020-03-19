package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Admin;
import com.yyjj.service.bo.AdminBO;

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
public class AdminVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

    private String account;

    private String password;

    private String name;

    private String email;
     
    public static  AdminVO newInstance( Admin  admin) {
        if(Objects.isNull( admin)) {
  	    return null;
  	  }        
         AdminVO  adminVO = new  AdminVO();
        BeanUtils.copyProperties( admin,  adminVO);
        return  adminVO;
  	}
    
    public static  AdminVO newInstance( AdminBO  admin) {
        if(Objects.isNull( admin)) {
  	    return null;
  	  }        
         AdminVO  adminVO = new  AdminVO();
        BeanUtils.copyProperties( admin,  adminVO);
        return  adminVO;
  	}
  	    
  	public  Admin convert() {
  		 Admin  admin = new  Admin();
  	  BeanUtils.copyProperties(this,  admin);
  	  return  admin;
  	}
  	
  	public  AdminBO  AdminBO() {
  		 AdminBO  admin = new  AdminBO();
  	  BeanUtils.copyProperties(this,  admin);
  	  return  admin;
  	}
  	
  }