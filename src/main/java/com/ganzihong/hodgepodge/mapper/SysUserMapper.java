package com.ganzihong.hodgepodge.mapper;

import com.ganzihong.hodgepodge.entity.SysUser;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public interface SysUserMapper extends Mapper<SysUser> {
}