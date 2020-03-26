package com.yyjj.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.yyjj.service.bo.ResumeLableBO;
import com.yyjj.db.model.ResumeLable;
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
public class ResumeLableVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
     
    public static  ResumeLableVO newInstance( ResumeLable  resumelable) {
        if(Objects.isNull( resumelable)) {
  	    return null;
  	  }        
         ResumeLableVO  resumelableVO = new  ResumeLableVO();
        BeanUtils.copyProperties( resumelable,  resumelableVO);
        return  resumelableVO;
  	}
    
    public static  ResumeLableVO newInstance( ResumeLableBO  resumelable) {
        if(Objects.isNull( resumelable)) {
  	    return null;
  	  }        
         ResumeLableVO  resumelableVO = new  ResumeLableVO();
        BeanUtils.copyProperties( resumelable,  resumelableVO);
        return  resumelableVO;
  	}
  	    
  	public  ResumeLable convert() {
  		 ResumeLable  resumelable = new  ResumeLable();
  	  BeanUtils.copyProperties(this,  resumelable);
  	  return  resumelable;
  	}
  	
  	public  ResumeLableBO  ResumeLableBO() {
  		 ResumeLableBO  resumelable = new  ResumeLableBO();
  	  BeanUtils.copyProperties(this,  resumelable);
  	  return  resumelable;
  	}
  	
  }