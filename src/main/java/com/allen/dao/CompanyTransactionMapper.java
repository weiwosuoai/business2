package com.allen.dao;

import com.allen.pojo.CompanyTransaction;
import com.allen.pojo.CompanyTransactionExample;

import java.util.List;

import com.allen.pojo.vo.CompanyTransactionVo;
import org.apache.ibatis.annotations.Param;

public interface CompanyTransactionMapper {
    int countByExample(CompanyTransactionExample example);

    int deleteByExample(CompanyTransactionExample example);

    int deleteByPrimaryKey(Integer transId);

    int insert(CompanyTransaction record);

    int insertSelective(CompanyTransaction record);

    List<CompanyTransaction> selectByExampleWithBLOBs(CompanyTransactionExample example);

    List<CompanyTransactionVo> selectByExample(CompanyTransactionExample example);

    CompanyTransactionVo selectByPrimaryKey(Integer transId);

    int updateByExampleSelective(@Param("record") CompanyTransaction record, @Param("example") CompanyTransactionExample example);

    int updateByExampleWithBLOBs(@Param("record") CompanyTransaction record, @Param("example") CompanyTransactionExample example);

    int updateByExample(@Param("record") CompanyTransaction record, @Param("example") CompanyTransactionExample example);

    int updateByPrimaryKeySelective(CompanyTransaction record);

    int updateByPrimaryKeyWithBLOBs(CompanyTransaction record);

    int updateByPrimaryKey(CompanyTransaction record);
}