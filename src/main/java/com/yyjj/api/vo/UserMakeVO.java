package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.UserMake;
import com.yyjj.service.bo.UserMakeBO;

import lombok.Getter;
import lombok.Setter;

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
public class UserMakeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户收藏id
     */
    private Integer id;

    /**
     * 用户收藏id
     */
    private Integer userId;

    /**
     * 职位id
     */
    private Integer positionId;
    
    /**
     * 职位
     */
    private PositionVO position;
    
    /**
     * 用户
     */
    private UserVO user; 
    public static  UserMakeVO newInstance( UserMake  usermake) {
        if(Objects.isNull( usermake)) {
  	    return null;
  	  }        
         UserMakeVO  usermakeVO = new  UserMakeVO();
        BeanUtils.copyProperties( usermake,  usermakeVO);
        return  usermakeVO;
  	}
    
    public static  UserMakeVO newInstance( UserMakeBO  usermake) {
        if(Objects.isNull( usermake)) {
  	    return null;
  	  }        
         UserMakeVO  usermakeVO = new  UserMakeVO();
        BeanUtils.copyProperties( usermake,  usermakeVO);
        return  usermakeVO;
  	}
  	    
  	public  UserMake convert() {
  		 UserMake  usermake = new  UserMake();
  	  BeanUtils.copyProperties(this,  usermake);
  	  return  usermake;
  	}
  	
  	public  UserMakeBO  UserMakeBO() {
  		 UserMakeBO  usermake = new  UserMakeBO();
  	  BeanUtils.copyProperties(this,  usermake);
  	  return  usermake;
  	}
  	
  }