package cn.jx.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Dir implements Serializable {
    /**
     * 主键
     */
    private Integer dirkey;

    /**
     * 文件夹名称
     */
    private String dirname;

    private Integer updir;

    private ArrayList<Note> NoteList;

    private static final long serialVersionUID = 1L;
}