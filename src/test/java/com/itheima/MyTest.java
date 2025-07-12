package com.itheima;

import com.itheima.pojo.MyClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class MyTest {

    @Test
    void test1(){

        List<MyClass> data = buildData();
        List<MyClass> collect = data.stream().sorted(
                new Comparator<MyClass>() {
                    @Override
                    public int compare(MyClass o1, MyClass o2) {
                        if (o1.getA() == o2.getB()) {
                            return o1.getB() - o2.getB();
                        } else {
                            return o1.getA() - o2.getA();
                        }
                    }
                }
        ).collect(Collectors.toList());

        for(MyClass myClass : collect){
            System.out.print(myClass.getA() + "->"+myClass.getB());
            System.out.println();
        }


    }

    List<MyClass> buildData(){
        List<MyClass> myClasses = new ArrayList<>();
        myClasses.add(new MyClass(1,3));
        myClasses.add(new MyClass(1,4));
        myClasses.add(new MyClass(5,1));
        myClasses.add(new MyClass(4,0));
        return myClasses;
    }
}
