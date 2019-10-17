package com.github.jumpbyte.practice.gof.decoratormode.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * IO流操作演示
 *
 * @className: Client
 * @author: yuanjinan
 * @create: 2018/12/27
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        //流式读取文件
        DataInputStream din = null;
        String filePath = Client.class.getClassLoader().getResource("").getPath();
        try {

            din = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath+"/io_test.txt")));
            //然后就可以获取文件内容了
            byte bs[] = new byte[din.available()];
            din.read(bs);
            String content = new String(bs);
            System.out.println("文件内容====");
            System.out.println(content);
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            din.close();
        }

        //流式输出文件
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(
                new EncryptOutputStream(new FileOutputStream(filePath+"/io_encrypte.txt"))));
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();

         //换个位置
//        DataOutputStream dout1 = new DataOutputStream(
//                new EncryptOutputStream (
//                        new BufferedOutputStream(
//                                new FileOutputStream(filePath+"/io_encrypte.txt"))));
//        dout1.write("abcdxyz".getBytes());
//        dout1.close();

    }

}
