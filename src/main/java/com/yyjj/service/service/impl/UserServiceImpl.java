package com.yyjj.service.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yyjj.db.dao.UserMapper;
import com.yyjj.db.model.User;
import com.yyjj.service.service.UserService;

/**
 * 
 * @author yml
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> 
implements UserService
{
	

}
