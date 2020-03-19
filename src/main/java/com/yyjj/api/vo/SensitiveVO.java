package com.yyjj.api.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.yyjj.db.model.Sensitive;
import com.yyjj.service.bo.SensitiveBO;

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
public class SensitiveVO implements Serializable {

    private static final long serialVersionUID = 1L;
    

    /**
     * 敏感词id
     */
    private Integer id;

    /**
     * 敏感词
     */
    private String sensitive;
    public static  SensitiveVO newInstance( Sensitive  sensitive) {
        if(Objects.isNull( sensitive)) {
  	    return null;
  	  }        
         SensitiveVO  sensitiveVO = new  SensitiveVO();
        BeanUtils.copyProperties( sensitive,  sensitiveVO);
        return  sensitiveVO;
  	}
    
    public static  SensitiveVO newInstance( SensitiveBO  sensitive) {
        if(Objects.isNull( sensitive)) {
  	    return null;
  	  }        
         SensitiveVO  sensitiveVO = new  SensitiveVO();
        BeanUtils.copyProperties( sensitive,  sensitiveVO);
        return  sensitiveVO;
  	}
  	    
  	public  Sensitive convert() {
  		 Sensitive  sensitive = new  Sensitive();
  	  BeanUtils.copyProperties(this,  sensitive);
  	  return  sensitive;
  	}
  	
  	public  SensitiveBO  SensitiveBO() {
  		 SensitiveBO  sensitive = new  SensitiveBO();
  	  BeanUtils.copyProperties(this,  sensitive);
  	  return  sensitive;
  	}
  	
  }