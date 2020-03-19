package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Lable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LableBO implements IBaseBO<Lable>{
	
	@Override
	public void accpet(QueryWrapper<Lable> queryWrapper) {
		
	}
	
	public  Lable convert() {
  		 Lable  lable = new  Lable();
  	  BeanUtils.copyProperties(this,  lable);
  	  return  lable;
  	}
}
    