package com.feng.boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.boot.entity.User;
import com.feng.boot.mapper.UserMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusStudy01ApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void testins(){
        int i = userMapper.insert(User.
                builder().
                name("zhangsan").
                age(18).
                email("2343453456").
                build());
//        User user = new User();
//        user.setAge(18);
//        user.setEmail("234");
//        user.setName("zhangsan");
//        int i = userMapper.insert(user);
        System.out.println("一共增加了："+i);
    }

    @Test
    void testdel(){
//        assertEquals(1,userMapper.deleteById(2L));
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zhangsan");
        assertEquals(0,userMapper.deleteByMap(map));
    }
    /*
    条件查询
     */
    @Test
    void wrapperTest(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /**
         * 这条件等于：
         * where(age = 18 or name = "tom")
         */
        //等值条件
        wrapper.eq("age",18).
                or().
                eq("name","Tom");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

    /**
     * 测试分页查询
     */
    @Test
    void testPage(){

        //创建Page对象封装分页查询条件
        IPage<User> Page = new Page<>(1, 2);

        IPage<User> userIPage = userMapper.selectPage(Page, null);
        System.out.println("一页有多少条："+userIPage.getRecords());
        System.out.println("分页总共的数量："+userIPage.getTotal());
        System.out.println("分页总共的页码数："+userIPage.getPages());
    }


}
