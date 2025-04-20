package com.example.demoproject.demo;

public class StaticBolckDemo {

    public static void main(String[] args) {

        People p1 = new People();
        People p2 = new People();
        People p3 = new People();

        /*
        输出结果: this is People class 只会输出一次
        原因：   1.在 Java 里，static 代码块也被称作静态代码块，它属于类的一部分，而非对象的一部分。
                静态代码块的执行规则和特点决定了它只会在类被加载时执行一次，
                下面来详细解释你给出的代码里 static 代码块仅执行一次的原因。
                2.在 Java 程序运行期间，当 JVM 首次使用某个类时，会对这个类进行加载、
                连接和初始化操作。类加载指的是把类的字节码文件加载到内存中；连接包含验证、
                准备和解析三个步骤；初始化则是执行类的静态代码块和静态变量赋值操作.
                3.静态代码块会在类被加载时执行，而且只会执行一次。无论后续创建多少个该类的实例对象，
                静态代码块都不会再次执行。这是因为类的加载过程在 JVM 中是一次性的，一旦类被加载，
                就不会再次加载，所以静态代码块也不会重复执行。
         */
    }

    public static class People{

        //静态代码块和静态变量只会在JVM进行类加载时，初始化一次。
        static {
            System.out.println("this is People class");
        }

        public People(){

        }
    }
}
