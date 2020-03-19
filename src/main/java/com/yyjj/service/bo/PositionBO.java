package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Position;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionBO implements IBaseBO<Position>{
	
	@Override
	public void accpet(QueryWrapper<Position> queryWrapper) {
		
	}
	
	public  Position convert() {
  		 Position  position = new  Position();
  	  BeanUtils.copyProperties(this,  position);
  	  return  position;
  	}
}
    