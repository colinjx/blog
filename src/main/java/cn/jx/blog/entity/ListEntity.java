package cn.jx.blog.entity;

import lombok.Data;

import java.util.List;


@Data
public class ListEntity {
    private String code = "";

    private String msg = "";
    private Integer count ;

    private List data;



}
