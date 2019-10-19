package cn.jx.blog.service;

import cn.jx.blog.entity.Dir;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DirService {


    int deleteByPrimaryKey(Integer dirkey);

    int insert(Dir record);

    int insertSelective(Dir record);

    Dir selectByPrimaryKey(Integer dirkey);

    int updateByPrimaryKeySelective(Dir record);

    int updateByPrimaryKey(Dir record);

    ArrayList<Dir> findDirs();

    List getDirsAndNotes ();

}



