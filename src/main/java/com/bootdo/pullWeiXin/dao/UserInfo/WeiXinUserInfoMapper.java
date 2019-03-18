package com.bootdo.pullWeiXin.dao.UserInfo;

import org.apache.ibatis.annotations.Mapper;

import com.bootdo.pullWeiXin.pojo.UserWxInfo.WeiXinUserInfo;

@Mapper
public interface WeiXinUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeiXinUserInfo record);

    int insertSelective(WeiXinUserInfo record);

    WeiXinUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeiXinUserInfo record);

    int updateByPrimaryKey(WeiXinUserInfo record);
}