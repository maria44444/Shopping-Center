package com.example.shopping;

import java.io.Serializable;

public class iteminfolist implements Serializable {
    int img;
    String nam;
    String pri;
    int total;
    String id1;
    public iteminfolist(int img, String nam, String pri, int total, String id1)
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
    public void setTotal(int total)
    {
        this.total=total;

    }
    public int getImg()
    {
        return img;
    }
    public String getNam()
    {
        return nam;
    }
    public String getPri()
    {
        return pri;
    }
    public int getTotal()
    {
        return total;
    }
    public String getId1()
    {
        return id1;
    }
}
