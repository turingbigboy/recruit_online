package com.yyjj.api.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Position;
import com.yyjj.db.model.User;
import com.yyjj.service.bo.UserBO;

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
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer userId;
    @NotNull
    private String account;
    @NotNull
    private String password;

    private String name;

    private Integer gender;

    private Integer birthYear;

    private String nickname;

    private String email;

    private String province;

    private String city;

    private String eduDegree;

    private String graduation;

    private Integer graYear;

    private String major;

    private Integer dirDesire;
    
    private Integer state;
    
    private List<Position> markPositions;
    
    private List<DropBoxVO> dropBoxs;
    
    private ResumeVO resume;
    
    private LocalDateTime createTime;
    public static  UserVO newInstance( User  user) {
        if(Objects.isNull( user)) {
  	    return null;
  	  }        
         UserVO  userVO = new  UserVO();
        BeanUtils.copyProperties( user,  userVO);
        return  userVO;
  	}
    
    public static  UserVO newInstance( UserBO  user) {
        if(Objects.isNull( user)) {
  	    return null;
  	  }        
         UserVO  userVO = new  UserVO();
        BeanUtils.copyProperties( user,  userVO);
        return  userVO;
  	}
  	    
  	public  User convert() {
  		 User  user = new  User();
  	  BeanUtils.copyProperties(this,  user);
  	  return  user;
  	}
  	
  	public  UserBO  UserBO() {
  		 UserBO  user = new  UserBO();
  	  BeanUtils.copyProperties(this,  user);
  	  return  user;
  	}
  	
  }