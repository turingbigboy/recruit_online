package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentBO implements IBaseBO<Department>{
	
	@Override
	public void accpet(QueryWrapper<Department> queryWrapper) {
		
	}
	
	public  Department convert() {
  		 Department  department = new  Department();
  	  BeanUtils.copyProperties(this,  department);
  	  return  department;
  	}
}
    