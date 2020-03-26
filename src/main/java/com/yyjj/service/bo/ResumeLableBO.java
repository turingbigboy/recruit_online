package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.ResumeLable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeLableBO implements IBaseBO<ResumeLable>{
	
	@Override
	public void accpet(QueryWrapper<ResumeLable> queryWrapper) {
		
	}
	
	public  ResumeLable convert() {
  		 ResumeLable  resumelable = new  ResumeLable();
  	  BeanUtils.copyProperties(this,  resumelable);
  	  return  resumelable;
  	}
}
    