package cn.jx.blog.controller;


import cn.jx.blog.entity.Dir;
import cn.jx.blog.entity.ListEntity;
import cn.jx.blog.entity.Note;
import cn.jx.blog.service.DirService;
import cn.jx.blog.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/manager")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    DirService dirService;

    @GetMapping("/note/{notekey}")
    public String getNote(@PathVariable("notekey") String notekey, Model model){
        Note note = noteService.selectByPrimaryKey(Integer.parseInt(notekey));
        model.addAttribute("note",note);
        return "/manager/note";
    }

    @ResponseBody
    @PostMapping("/note")
    public Note modifyNote(Note note){
        noteService.updateByPrimaryKeySelective(note);
        return note;
    }

    @ResponseBody
    @PutMapping("/note")
    public Note newNote(@RequestBody Note note){
        if(StringUtils.isEmpty(note.getTitle())){
            note.setTitle("新建笔记");
        }
        noteService.insert(note);
        return note;

    }



    @GetMapping("/noteShow/{notekey}")
    public String getNoteShow(@PathVariable("notekey") String notekey, Model model){
        Note note = noteService.selectByPrimaryKey(Integer.parseInt(notekey));
        model.addAttribute("note",note);
        return "/manager/note1";

    }

    @GetMapping("/dirs")
    public String getDirs(Map map){

        return "/manager/dirList";
    }

    @ResponseBody
    @PutMapping("/dir")
    public String updateDir(  @RequestBody Dir dir){
        System.out.println(dir.getNoteList());
        int num = dirService.updateByPrimaryKeySelective(dir);
        if(num == 1){
            return "success";
        }else {
            return "failed";
        }
    }
    @ResponseBody
    @PostMapping("/dir")
    public Dir newDir( @RequestBody Dir dir){
        dirService.insertSelective(dir);
        System.out.println(dir);
        return dir;
    }

    @ResponseBody
    @GetMapping("/dirs.json")
    public ListEntity getDirsJson(){

        List dirsAndNotes = dirService.getDirsAndNotes();
        ListEntity entity = new ListEntity();
        entity.setCode("0");
        entity.setData(dirsAndNotes);
        entity.setCount(dirsAndNotes.size());
        return entity;
    }
}
