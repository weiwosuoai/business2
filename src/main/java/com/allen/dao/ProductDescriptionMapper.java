package com.allen.dao;

import com.allen.pojo.ProductDescription;
import com.allen.pojo.ProductDescriptionExample;
import com.allen.pojo.ProductDescriptionWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDescriptionMapper {
    int countByExample(ProductDescriptionExample example);

    int deleteByExample(ProductDescriptionExample example);

    int deleteByPrimaryKey(Integer descId);

    int insert(ProductDescriptionWithBLOBs record);

    int insertSelective(ProductDescriptionWithBLOBs record);

    List<ProductDescriptionWithBLOBs> selectByExampleWithBLOBs(ProductDescriptionExample example);

    List<ProductDescription> selectByExample(ProductDescriptionExample example);

    ProductDescriptionWithBLOBs selectByPrimaryKey(Integer descId);

    int updateByExampleSelective(@Param("record") ProductDescriptionWithBLOBs record, @Param("example") ProductDescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductDescriptionWithBLOBs record, @Param("example") ProductDescriptionExample example);

    int updateByExample(@Param("record") ProductDescription record, @Param("example") ProductDescriptionExample example);

    int updateByPrimaryKeySelective(ProductDescriptionWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductDescriptionWithBLOBs record);

    int updateByPrimaryKey(ProductDescription record);
}