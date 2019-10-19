package cn.jx.blog.controller;


import cn.jx.blog.entity.User;
import cn.jx.blog.service.DirService;
import cn.jx.blog.service.NoteService;
import cn.jx.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    UserService userService;

    @Autowired
    DirService dirService;

    @Autowired
    NoteService noteService;

    @PostMapping(value = "/login")
    public String  login (User user, Map<String ,String> map, HttpSession session){
        User temp = userService.selectByPrimaryKey(user.getUsername());
        if(temp !=null && temp.getPassword().equals(user.getPassword())){
            session.setAttribute("loginUser",user.getUsername());
            return "redirect:index";
        }else{
            map.put("msg","账户或密码错误");
            return "/manager/login";
        }

    }

    @GetMapping(value = "/index")
    public String  index (Map map){
        List dirsAndNotes = dirService.getDirsAndNotes();
        map.put("dirs",dirsAndNotes);
        return "manager/index";
    }
   @GetMapping(value = "welcome")
    public String welcome (){
        return "/manager/welcome";
    }



}
