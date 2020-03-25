package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyjj.db.model.Company;
import com.yyjj.service.bo.CompanyBO;

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
public class CompanyVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 公司id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
   
    private String companyName;


    private Integer companyLogo;

    /**
     * 公司描述
     */
    private String description;

    /**
     * 公司状态
     */
    private Integer state;

    /**
     * 公司代码
     */

    private String companyCode;
     
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