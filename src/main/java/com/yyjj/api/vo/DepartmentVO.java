package com.yyjj.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.yyjj.service.bo.DepartmentBO;
import com.yyjj.db.model.Department;
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
public class DepartmentVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
     
    public static  DepartmentVO newInstance( Department  department) {
        if(Objects.isNull( department)) {
  	    return null;
  	  }        
         DepartmentVO  departmentVO = new  DepartmentVO();
        BeanUtils.copyProperties( department,  departmentVO);
        return  departmentVO;
  	}
    
    public static  DepartmentVO newInstance( DepartmentBO  department) {
        if(Objects.isNull( department)) {
  	    return null;
  	  }        
         DepartmentVO  departmentVO = new  DepartmentVO();
        BeanUtils.copyProperties( department,  departmentVO);
        return  departmentVO;
  	}
  	    
  	public  Department convert() {
  		 Department  department = new  Department();
  	  BeanUtils.copyProperties(this,  department);
  	  return  department;
  	}
  	
  	public  DepartmentBO  DepartmentBO() {
  		 DepartmentBO  department = new  DepartmentBO();
  	  BeanUtils.copyProperties(this,  department);
  	  return  department;
  	}
  	
  }