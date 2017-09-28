package com.eeepay.cn.zzq.demo.ui.materia_design.bean;
 /**
  * 描述：水果的实体类
  * 作者：zhuangzeqin
  * 时间: 2017/9/28-17:30
  * 邮箱：zzq@eeepay.cn
  */
public class Fruit {

    private String name;//水果的名称

    private int imageId;//水果对应图片的资源id

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

}