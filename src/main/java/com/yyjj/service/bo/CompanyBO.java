package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyBO implements IBaseBO<Company>{
	
	@Override
	public void accpet(QueryWrapper<Company> queryWrapper) {
		
	}
	
	public  Company convert() {
  		 Company  company = new  Company();
  	  BeanUtils.copyProperties(this,  company);
  	  return  company;
  	}
}
    