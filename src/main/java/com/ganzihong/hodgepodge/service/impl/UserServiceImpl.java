package com.ganzihong.hodgepodge.service.impl;

import com.ganzihong.hodgepodge.entity.SysUser;
import com.ganzihong.hodgepodge.mapper.SysUserMapper;
import com.ganzihong.hodgepodge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public SysUser queryUserById(Integer userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
}
