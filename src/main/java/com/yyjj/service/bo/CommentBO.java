package com.yyjj.service.bo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import com.yyjj.db.model.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentBO implements IBaseBO<Comment>{
	
	@Override
	public void accpet(QueryWrapper<Comment> queryWrapper) {
		
	}
	
	public  Comment convert() {
  		 Comment  comment = new  Comment();
  	  BeanUtils.copyProperties(this,  comment);
  	  return  comment;
  	}
}
    