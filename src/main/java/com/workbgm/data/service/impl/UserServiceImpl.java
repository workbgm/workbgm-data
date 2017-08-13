package com.workbgm.data.service.impl;

import com.workbgm.data.dao.UserMapper;
import com.workbgm.data.model.User;
import com.workbgm.data.service.UserService;
import com.workbgm.gen.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by workbgm on 2017/08/12.
 */
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

}
