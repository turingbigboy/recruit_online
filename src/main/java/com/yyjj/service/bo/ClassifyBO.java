package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Classify;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassifyBO implements IBaseBO<Classify>{
	
	@Override
	public void accpet(QueryWrapper<Classify> queryWrapper) {
		
	}
	
	public  Classify convert() {
  		 Classify  classify = new  Classify();
  	  BeanUtils.copyProperties(this,  classify);
  	  return  classify;
  	}
}
    