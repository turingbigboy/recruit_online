package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.DropBox;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DropBoxBO implements IBaseBO<DropBox>{
	
	@Override
	public void accpet(QueryWrapper<DropBox> queryWrapper) {
		
	}
	
	public  DropBox convert() {
  		 DropBox  dropbox = new  DropBox();
  	  BeanUtils.copyProperties(this,  dropbox);
  	  return  dropbox;
  	}
}
    