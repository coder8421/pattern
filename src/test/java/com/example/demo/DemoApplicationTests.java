package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest(classes = DemoApplication.class)
@Slf4j
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello ");
    }
    @Test
   public void streamTest() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
/*

  斐波纳契数列示例(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...数列中开始的两个数字是0和1，后续的每个数字都是前两个数字之和
*/      @Test
         public void  Test(){

              Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]}).limit(20)
             .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
            //打印斐波纳契数列：
             Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
             .limit(10).map(t -> t[0]).forEach(System.out::println);
         }

    @Test
    public void  StringTest(){
        String s1 = "aabb";
        String s2 = "aabb";
        log.info(" ==  {}",s1.equals(s2));
        log.info(" ==  {}",s1 == s2.intern());

    }

}
