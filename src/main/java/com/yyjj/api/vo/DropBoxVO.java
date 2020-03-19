package com.yyjj.api.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.yyjj.service.bo.DropBoxBO;
import com.yyjj.db.model.DropBox;
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
public class DropBoxVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投递箱
     */
    private Integer id;

    /**
     * 职位id
     */
    private Integer positionId;

    /**
     * 简历id
     */
    private Integer resumeId;

    /**
     * 投递状态 0:未审阅 1：已阅读 
     */
    private Integer state;
     
    public static  DropBoxVO newInstance( DropBox  dropbox) {
        if(Objects.isNull( dropbox)) {
  	    return null;
  	  }        
         DropBoxVO  dropboxVO = new  DropBoxVO();
        BeanUtils.copyProperties( dropbox,  dropboxVO);
        return  dropboxVO;
  	}
    
    public static  DropBoxVO newInstance( DropBoxBO  dropbox) {
        if(Objects.isNull( dropbox)) {
  	    return null;
  	  }        
         DropBoxVO  dropboxVO = new  DropBoxVO();
        BeanUtils.copyProperties( dropbox,  dropboxVO);
        return  dropboxVO;
  	}
  	    
  	public  DropBox convert() {
  		 DropBox  dropbox = new  DropBox();
  	  BeanUtils.copyProperties(this,  dropbox);
  	  return  dropbox;
  	}
  	
  	public  DropBoxBO  DropBoxBO() {
  		 DropBoxBO  dropbox = new  DropBoxBO();
  	  BeanUtils.copyProperties(this,  dropbox);
  	  return  dropbox;
  	}
  	
  }