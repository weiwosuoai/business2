package com.allen.dao;

import com.allen.pojo.BusinessRequest;
import com.allen.pojo.BusinessRequestExample;

import java.util.List;

import com.allen.pojo.vo.BusinessRequestVo;
import org.apache.ibatis.annotations.Param;

public interface BusinessRequestMapper {
    int countByExample(BusinessRequestExample example);

    int deleteByExample(BusinessRequestExample example);

    int deleteByPrimaryKey(Integer requestId);

    int insert(BusinessRequest record);

    int insertSelective(BusinessRequest record);

    List<BusinessRequestVo> selectByExample(BusinessRequestExample example);

    BusinessRequestVo selectByPrimaryKey(Integer requestId);

    int updateByExampleSelective(@Param("record") BusinessRequest record, @Param("example") BusinessRequestExample example);

    int updateByExample(@Param("record") BusinessRequest record, @Param("example") BusinessRequestExample example);

    int updateByPrimaryKeySelective(BusinessRequest record);

    int updateByPrimaryKey(BusinessRequest record);
}