package com.example.aliyevorkhan.karakterozellestirme;

public class Insan {
    int boy;
    int kilo;
    int enerji;
    int yas;
    String isim;

    public String  yemek(){
        kilo = kilo + 1;
        enerji = enerji + 1;
        return isim + " yemek yedi";
    }

    public String spor(){
        kilo = kilo - 1;
        enerji = enerji - 1;
        boy = boy + 1;
        return isim + " spor yapti";
    }

    public String uyumak(){
        enerji = enerji + 1;
        boy = boy + 1;
        kilo = kilo - 1;
        return isim + "uyudu";
    }

}
