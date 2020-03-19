package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Sort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortBO implements IBaseBO<Sort>{
	
	@Override
	public void accpet(QueryWrapper<Sort> queryWrapper) {
		
	}
	
	public  Sort convert() {
  		 Sort  sort = new  Sort();
  	  BeanUtils.copyProperties(this,  sort);
  	  return  sort;
  	}
}
    