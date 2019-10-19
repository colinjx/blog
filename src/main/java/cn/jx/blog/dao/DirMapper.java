package cn.jx.blog.dao;

import cn.jx.blog.entity.Dir;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.ArrayList;

@Mapper
public interface DirMapper {
    int deleteByPrimaryKey(Integer dirkey);

    @Options(useGeneratedKeys = true,keyProperty = "dirkey")
    int insert(Dir record);

    @Options(useGeneratedKeys = true,keyProperty = "dirkey")
    int insertSelective(Dir record);

    Dir selectByPrimaryKey(Integer dirkey);

    int updateByPrimaryKeySelective(Dir record);

    int updateByPrimaryKey(Dir record);

    ArrayList<Dir> findDirs();
}