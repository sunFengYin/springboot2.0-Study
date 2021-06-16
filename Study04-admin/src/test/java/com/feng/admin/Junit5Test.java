package com.feng.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5功能测试类")
public class Junit5Test {

    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterizedTest(int i){
        System.out.println(i);
    }


    /**
     * 前面的断言失败，则后面的代码就不会执行
     */
    @Test
    @DisplayName("断言测试")
    void assertTest(){
        int cal=cal(2,3);
        assertEquals(7,cal,"业务逻辑不合法");
    }

    int cal(int a,int b){
        return a+b;
    }

    @Test
    @DisplayName("组合断言")
    void Testall(){
        assertAll("test",
                ()->assertTrue(1==1),
                ()->assertEquals(1,3));
    }


//    @Disabled //表示不执行
    @Test
    @DisplayName("first test method")
    void testDisplayName(){
        System.out.println(11);
    }

    @Test
    @Timeout(value = 500,unit = TimeUnit.MICROSECONDS)
    void testTimeOut() throws InterruptedException {
        Thread.sleep(1000);
    }


    @BeforeEach
    void beforeTest(){
        System.out.println("before=====================");
    }

    @AfterEach
    void afterTest(){
        System.out.println("after=====================");
    }
}
