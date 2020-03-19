package com.yyjj.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yyjj.db.dao.CommentMapper;
import com.yyjj.db.model.Comment;
import com.yyjj.service.service.CommentService;

/**
 * 
 * @author yml
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> 
implements CommentService
{
	

}
