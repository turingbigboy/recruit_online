package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Sensitive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensitiveBO implements IBaseBO<Sensitive>{
	
	@Override
	public void accpet(QueryWrapper<Sensitive> queryWrapper) {
		
	}
	
	public  Sensitive convert() {
  		 Sensitive  sensitive = new  Sensitive();
  	  BeanUtils.copyProperties(this,  sensitive);
  	  return  sensitive;
  	}
}
    