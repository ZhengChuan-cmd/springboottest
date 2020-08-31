package com.example.springboottest.controllerTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program: springboottest
 * @description: testcontroller测试
 * @Auther: zhengchuan
 * @Createdate: 2020-08-27-17-07
 */
public class TestControllerTest {

    public static void main(String[] args) {
        try {

            String url = "http://192.168.43.127:8080/getTestService";
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setRequestMethod("POST");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                String a = inputStreamToString(inputStream, "Utf-8");
                System.out.println(a);
            }
            connection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static  String inputStreamToString(InputStream in,String chaeset) throws IOException {
        int buffersize=1024;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] data=new byte[buffersize];
        int count;
        while((count=in.read(data,0,buffersize))!=-1)
            outputStream.write(data,0,count);

        return new String(outputStream.toByteArray(),chaeset);
    }

}
