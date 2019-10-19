package cn.jx.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {


        try {
            String rootPath = ResourceUtils.getURL("classpath:").getPath();


            System.out.println(rootPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
