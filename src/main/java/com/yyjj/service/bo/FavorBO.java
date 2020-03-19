package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Favor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavorBO implements IBaseBO<Favor>{
	
	@Override
	public void accpet(QueryWrapper<Favor> queryWrapper) {
		
	}
	
	public  Favor convert() {
  		 Favor  favor = new  Favor();
  	  BeanUtils.copyProperties(this,  favor);
  	  return  favor;
  	}
}
    