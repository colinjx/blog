package cn.jx.blog.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private static final long serialVersionUID = 1L;
}