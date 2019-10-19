package cn.jx.blog.dao;

import cn.jx.blog.entity.Note;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.ArrayList;

@Mapper
public interface NoteMapper {
    int deleteByPrimaryKey(Integer notekey);

    int insert(Note record);

    @Options(useGeneratedKeys = true,keyProperty = "notekey")
    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer notekey);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    ArrayList<Note> findNoteList(Note note);
}