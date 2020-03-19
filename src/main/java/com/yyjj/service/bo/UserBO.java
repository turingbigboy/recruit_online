package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBO implements IBaseBO<User>{
	
	@Override
	public void accpet(QueryWrapper<User> queryWrapper) {
		
	}
	
	public  User convert() {
  		 User  user = new  User();
  	  BeanUtils.copyProperties(this,  user);
  	  return  user;
  	}
}
    