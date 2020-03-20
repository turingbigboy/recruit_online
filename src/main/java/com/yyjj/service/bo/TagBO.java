package com.yyjj.service.bo;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yyjj.db.model.Tag;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagBO implements IBaseBO<Tag>{
	
	@Override
	public void accpet(QueryWrapper<Tag> queryWrapper) {
		
	}
	
	public  Tag convert() {
  		 Tag  tag = new  Tag();
  	  BeanUtils.copyProperties(this,  tag);
  	  return  tag;
  	}
}
    