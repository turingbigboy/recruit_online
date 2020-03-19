package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Resume;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeBO implements IBaseBO<Resume>{
	
	@Override
	public void accpet(QueryWrapper<Resume> queryWrapper) {
		
	}
	
	public  Resume convert() {
  		 Resume  resume = new  Resume();
  	  BeanUtils.copyProperties(this,  resume);
  	  return  resume;
  	}
}
    