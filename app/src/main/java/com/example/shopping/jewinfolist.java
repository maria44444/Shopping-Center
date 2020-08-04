package com.example.shopping;


import java.io.Serializable;

public class jewinfolist implements Serializable {






    int img;
    String nam;
    String pri;
    int total;
    String id1;
    jewinfolist(int img,String nam,String pri,int total,String id1)
    {

        this.img=img;
        this.nam=nam;
        this.pri=pri;
        this.total=total;
        this.id1=id1;
    }

    void setImg(int img)
    {
        this.img=img;
    }
    void setId1(String id1)
    {
        this.id1=id1;
    }
    void setNam(String nam)
    {
        this.nam=nam;
    }
    void setPri(String pri)
    {
        this.pri=pri;
    }
    void setTotal(int total)
    {
        this.total=total;

    }
    int getImg()
    {
        return img;
    }
    String getNam()
    {
        return nam;
    }
    String getPri()
    {
        return pri;
    }
    int getTotal()
    {
        return total;
    }
    String getId1()
    {
        return id1;
    }
}





