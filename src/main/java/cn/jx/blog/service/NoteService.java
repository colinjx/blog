package cn.jx.blog.service;

import cn.jx.blog.entity.Note;

import java.util.ArrayList;

public interface NoteService {


    int deleteByPrimaryKey(Integer notekey);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer notekey);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    ArrayList<Note> findNoteList(Note note);

}



