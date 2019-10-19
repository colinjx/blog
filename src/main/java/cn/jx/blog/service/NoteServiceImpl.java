package cn.jx.blog.service;

import cn.jx.blog.dao.NoteMapper;
import cn.jx.blog.entity.Note;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteMapper noteMapper;

    @Override
    public int deleteByPrimaryKey(Integer notekey) {
        return noteMapper.deleteByPrimaryKey(notekey);
    }

    @Override
    public int insert(Note record) {
        return noteMapper.insert(record);
    }

    @Override
    public int insertSelective(Note record) {
        return noteMapper.insertSelective(record);
    }

    @Override
    public Note selectByPrimaryKey(Integer notekey) {
        return noteMapper.selectByPrimaryKey(notekey);
    }

    @Override
    public int updateByPrimaryKeySelective(Note record) {
        return noteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Note record) {
        return noteMapper.updateByPrimaryKey(record);
    }

    public ArrayList<Note> findNoteList(Note note) {
        return noteMapper.findNoteList(note);
    }
}



