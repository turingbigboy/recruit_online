package com.yyjj.api.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yyjj.db.model.Comment;
import com.yyjj.db.model.User;
import com.yyjj.service.bo.CommentBO;

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
public class CommentVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 星数量
     */
    private Integer type;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private LocalDateTime releaseTime;
    
    private Integer userId;
    private User user;
    /**
     * 评论职位
     */
    private Integer positionId;
     
    public static  CommentVO newInstance( Comment  comment) {
        if(Objects.isNull( comment)) {
  	    return null;
  	  }        
         CommentVO  commentVO = new  CommentVO();
        BeanUtils.copyProperties( comment,  commentVO);
        return  commentVO;
  	}
    
    public static  CommentVO newInstance( CommentBO  comment) {
        if(Objects.isNull( comment)) {
  	    return null;
  	  }        
         CommentVO  commentVO = new  CommentVO();
        BeanUtils.copyProperties( comment,  commentVO);
        return  commentVO;
  	}
  	    
  	public  Comment convert() {
  		 Comment  comment = new  Comment();
  	  BeanUtils.copyProperties(this,  comment);
  	  return  comment;
  	}
  	
  	public  CommentBO  CommentBO() {
  		 CommentBO  comment = new  CommentBO();
  	  BeanUtils.copyProperties(this,  comment);
  	  return  comment;
  	}
  	
  }