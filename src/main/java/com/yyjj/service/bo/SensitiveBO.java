package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Sensitives;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensitiveBO implements IBaseBO<Sensitives>{
	
	@Override
	public void accpet(QueryWrapper<Sensitives> queryWrapper) {
		
	}
	
	public  Sensitives convert() {
  		 Sensitives  sensitive = new  Sensitives();
  	  BeanUtils.copyProperties(this,  sensitive);
  	  return  sensitive;
  	}
}
    