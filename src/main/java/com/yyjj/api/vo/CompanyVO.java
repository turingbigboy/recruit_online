package com.yyjj.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.yyjj.service.bo.CompanyBO;
import com.yyjj.db.model.Company;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;

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
public class CompanyVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
     
    public static  CompanyVO newInstance( Company  company) {
        if(Objects.isNull( company)) {
  	    return null;
  	  }        
         CompanyVO  companyVO = new  CompanyVO();
        BeanUtils.copyProperties( company,  companyVO);
        return  companyVO;
  	}
    
    public static  CompanyVO newInstance( CompanyBO  company) {
        if(Objects.isNull( company)) {
  	    return null;
  	  }        
         CompanyVO  companyVO = new  CompanyVO();
        BeanUtils.copyProperties( company,  companyVO);
        return  companyVO;
  	}
  	    
  	public  Company convert() {
  		 Company  company = new  Company();
  	  BeanUtils.copyProperties(this,  company);
  	  return  company;
  	}
  	
  	public  CompanyBO  CompanyBO() {
  		 CompanyBO  company = new  CompanyBO();
  	  BeanUtils.copyProperties(this,  company);
  	  return  company;
  	}
  	
  }