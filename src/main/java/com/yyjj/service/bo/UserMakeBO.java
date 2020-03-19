package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.UserMake;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMakeBO implements IBaseBO<UserMake>{
	
	@Override
	public void accpet(QueryWrapper<UserMake> queryWrapper) {
		
	}
	
	public  UserMake convert() {
  		 UserMake  usermake = new  UserMake();
  	  BeanUtils.copyProperties(this,  usermake);
  	  return  usermake;
  	}
}
    