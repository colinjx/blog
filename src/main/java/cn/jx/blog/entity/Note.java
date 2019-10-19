package cn.jx.blog.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class Note implements Serializable {
    /**
     * 主键
     */

    private Integer notekey;

    /**
     * 文章标题
     */
    private String title;

    /**
     *
     */
    private String content;

    /**
     * 文件夹
     */
    private Integer dirkey;

    /**
     *
     */
    private String contentHtml;

    private static final long serialVersionUID = 1L;
}