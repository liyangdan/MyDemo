import com.chen.ChenApplication;
import com.chen.entity.User;
import com.chen.service.UserService;
import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChenApplication.class)

public class MyTest {


    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        //根据键获取数据
        User user=userService.getUserById(15100);
        System.out.println("---------*****"+user);
    }

    @Test
    public void test2() {
        //获取所有数据
        java.util.List<User> list=userService.getAllUser();
        System.out.println("&&&&&&"+list);

    }


    @Test
    public void test3() throws ParseException {
        //修改
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(sdf.format(new Date()));
        User new_user=new User();
        new_user.setUsername("hh");
        new_user.setScore(90.1);
        new_user.setId(15109);
        new_user.setCreatedata(date);
        userService.updateUser(new_user);
    }

    @Test
    public void test4() {
        //删除数据
        userService.delUser(15109);
    }

    @Test
    public void test5()throws ParseException  {
        //添加数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(sdf.format(new Date()));
        User new_user=new User();
        new_user.setUsername("李阳丹");
        new_user.setScore(93.6);
        new_user.setId(15103);
        new_user.setCreatedata(date);
        userService.addUser(new_user);
    }
}
