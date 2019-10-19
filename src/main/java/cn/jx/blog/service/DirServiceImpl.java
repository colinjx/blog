package cn.jx.blog.service;

import cn.jx.blog.entity.Note;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.jx.blog.entity.Dir;
import cn.jx.blog.dao.DirMapper;
import cn.jx.blog.service.DirService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DirServiceImpl implements DirService {

    @Resource
    private DirMapper dirMapper;

    @Resource NoteService noteService;

    @Override
    public int deleteByPrimaryKey(Integer dirkey) {
        return dirMapper.deleteByPrimaryKey(dirkey);
    }

    @Override
    public int insert(Dir record) {
        return dirMapper.insert(record);
    }

    @Override
    public int insertSelective(Dir record) {
        return dirMapper.insertSelective(record);
    }

    @Override
    public Dir selectByPrimaryKey(Integer dirkey) {
        return dirMapper.selectByPrimaryKey(dirkey);
    }

    @Override
    public int updateByPrimaryKeySelective(Dir record) {
        return dirMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dir record) {
        return dirMapper.updateByPrimaryKey(record);
    }

    @Override
    public ArrayList<Dir> findDirs() {
        return dirMapper.findDirs();
    }

    @Override
    public List getDirsAndNotes() {
        ArrayList<Dir> dirs = dirMapper.findDirs();
        for (Dir dir:
                dirs) {
            Note note = new Note();
            note.setDirkey(dir.getDirkey());
            ArrayList<Note> noteList = noteService.findNoteList(note);
            dir.setNoteList(noteList);
        }
        return dirs;
    }
}



