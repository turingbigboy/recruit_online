package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.HrMake;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrMakeBO implements IBaseBO<HrMake>{
	
	@Override
	public void accpet(QueryWrapper<HrMake> queryWrapper) {
		
	}
	
	public  HrMake convert() {
  		 HrMake  hrmake = new  HrMake();
  	  BeanUtils.copyProperties(this,  hrmake);
  	  return  hrmake;
  	}
}
    