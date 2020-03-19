package com.yyjj.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.yyjj.service.bo.FavorBO;
import com.yyjj.db.model.Favor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yml
 * 
 */
@Getter
@Setter
public class FavorVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
     
    public static  FavorVO newInstance( Favor  favor) {
        if(Objects.isNull( favor)) {
  	    return null;
  	  }        
         FavorVO  favorVO = new  FavorVO();
        BeanUtils.copyProperties( favor,  favorVO);
        return  favorVO;
  	}
    
    public static  FavorVO newInstance( FavorBO  favor) {
        if(Objects.isNull( favor)) {
  	    return null;
  	  }        
         FavorVO  favorVO = new  FavorVO();
        BeanUtils.copyProperties( favor,  favorVO);
        return  favorVO;
  	}
  	    
  	public  Favor convert() {
  		 Favor  favor = new  Favor();
  	  BeanUtils.copyProperties(this,  favor);
  	  return  favor;
  	}
  	
  	public  FavorBO  FavorBO() {
  		 FavorBO  favor = new  FavorBO();
  	  BeanUtils.copyProperties(this,  favor);
  	  return  favor;
  	}
  	
  }