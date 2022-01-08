package com.xiaohuajun.wonderful.web;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/1/8 下午3:33
 * @description PictureTest 照片解析
 */
public class PictureTest {


  public static  void readPic() {
    System.out.println("开始读取图片信息...");
    String path = "/Users/xiaohuajun/xiaohuajun/private/project/wonderful/src/main/resources/pic/IMG_9432.JPG";
    File jpegFile = new File(path);
    try {
      Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
      for (Directory directory : metadata.getDirectories()) {
        for (Tag tag : directory.getTags()) {
          System.out.print(tag.getTagName() + " --> ");
          System.out.println(tag.getDescription());

        }
        if (directory.hasErrors()) {
          for (String error : directory.getErrors()) {
            System.err.println("ERROR: " + error);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    readPic();
  }

  /**
   * 经纬度坐标格式转换
   * @param Gps
   */
  private static double conversionUtil(String Gps) {
    String du = Gps.split("°")[0].replace(" ", "");
    String fen = Gps.split("°")[1].split("'")[0].replace(" ", "");
    String miao = Gps.split("°")[1].split("'")[1].replace(" ", "").replace("\"", "");
    return Double.parseDouble(du)+Double.parseDouble(fen)/60 + Double.parseDouble(miao)/3600;
  }


  private  static  void  sendGetRequest(){
    String url = "http://restapi.amap.com/v3/geocode/regeo?key=adbda67c40bbe332e1d18b5ddb03d721&location=116.345214,39.975525&radius=500&extensions=base&batch=false&roadlevel=1";
    OkHttpClient okHttpClient = new OkHttpClient();
    final Request request = new Request.Builder()
        .url(url)
        .get()//默认就是GET请求，可以不写
        .build();
    Call call = okHttpClient.newCall(request);
    call.enqueue(new Callback() {
      @Override
      public void onFailure(Request request, IOException e) {
        System.err.println("error");
      }
      @Override
      public void onResponse(Response response) throws IOException {
        System.out.println( "onResponse: " + response.body().string());
      }
    });

  }

}
