package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminBO implements IBaseBO<Admin>{
	
	@Override
	public void accpet(QueryWrapper<Admin> queryWrapper) {
		
	}
	
	public  Admin convert() {
  		 Admin  admin = new  Admin();
  	  BeanUtils.copyProperties(this,  admin);
  	  return  admin;
  	}
}
    