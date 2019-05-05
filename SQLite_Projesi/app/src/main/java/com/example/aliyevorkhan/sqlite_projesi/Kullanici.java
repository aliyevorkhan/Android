package com.example.aliyevorkhan.sqlite_projesi;

public class Kullanici {
    String isim;
    int id;

    public Kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+id+"-"+isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
