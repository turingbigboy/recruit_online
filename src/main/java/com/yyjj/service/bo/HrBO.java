package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Hr;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrBO implements IBaseBO<Hr>{
	
	@Override
	public void accpet(QueryWrapper<Hr> queryWrapper) {
		
	}
	
	public  Hr convert() {
  		 Hr  hr = new  Hr();
  	  BeanUtils.copyProperties(this,  hr);
  	  return  hr;
  	}
}
    