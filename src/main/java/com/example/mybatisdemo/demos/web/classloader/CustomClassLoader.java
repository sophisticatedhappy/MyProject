package com.example.mybatisdemo.demos.web.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CustomClassLoader extends ClassLoader {
    // 类文件所在的目录
    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 将类名转换为文件路径
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            // 使用 defineClass 方法将字节数组转换为 Class 对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        // 将类名转换为文件路径
        String path = classPath + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try (InputStream ins = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            // 读取文件内容到字节数组输出流
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 创建自定义类加载器实例
        CustomClassLoader classLoader = new CustomClassLoader("D:\\code\\Practice\\MybatisDemo\\src\\main\\java\\com\\example\\mybatisdemo\\demos\\web\\entity");
        // 加载指定类
        Class<?> clazz = classLoader.loadClass("com.example.mybatisdemo.demos.web.entity.Order");
        // 创建类的实例
        Object obj = clazz.newInstance();
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(obj.getClass().getName());
    }
}
