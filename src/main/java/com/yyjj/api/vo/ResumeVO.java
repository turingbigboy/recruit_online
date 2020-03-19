package com.yyjj.api.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyjj.db.model.Resume;
import com.yyjj.service.bo.ResumeBO;

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
public class ResumeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 专业能力
     */
    private String ability;

    /**
     * 实习经历
     */
    private String internship;

    /**
     * 工作经历
     */
    private String workExperience;

    /**
     * 荣获奖项
     */
    private String certificate;

    /**
     * 就职期望
     */
    @TableField("jobDesire")
    private String jobDesire;

    /**
     * 是否发布
     */
    private Integer publish;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 发布时间
     */
    private LocalDateTime publishTime;
     
    public static  ResumeVO newInstance( Resume  resume) {
        if(Objects.isNull( resume)) {
  	    return null;
  	  }        
         ResumeVO  resumeVO = new  ResumeVO();
        BeanUtils.copyProperties( resume,  resumeVO);
        return  resumeVO;
  	}
    
    public static  ResumeVO newInstance( ResumeBO  resume) {
        if(Objects.isNull( resume)) {
  	    return null;
  	  }        
         ResumeVO  resumeVO = new  ResumeVO();
        BeanUtils.copyProperties( resume,  resumeVO);
        return  resumeVO;
  	}
  	    
  	public  Resume convert() {
  		 Resume  resume = new  Resume();
  	  BeanUtils.copyProperties(this,  resume);
  	  return  resume;
  	}
  	
  	public  ResumeBO  ResumeBO() {
  		 ResumeBO  resume = new  ResumeBO();
  	  BeanUtils.copyProperties(this,  resume);
  	  return  resume;
  	}
  	
  }