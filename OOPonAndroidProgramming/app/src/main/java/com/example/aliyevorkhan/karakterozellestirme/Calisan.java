package com.example.aliyevorkhan.karakterozellestirme;


public class Calisan extends Insan {
    int maas;
    String id;
    int itibarOrani;

    public Calisan(int maas, int itibarOrani, int enerji, int boy, int kilo, int yas) {
        this.maas = maas;
        this.itibarOrani = itibarOrani;
        this.enerji = enerji;
        this.boy = boy;
        this.kilo = kilo;
        this.yas = yas;
    }

    public String calis(){
       enerji = enerji - 1;
       itibarOrani = itibarOrani + 1;
       return isim + " calisti";
    }

    public String  mola(){
       enerji = enerji + 1;
       itibarOrani = itibarOrani - 1;
       return isim + " mola verdi";
    }

    public String zamIste(){
       if (itibarOrani > 10){
          maas = maas + 10;
       }
       else{
          itibarOrani = itibarOrani - 1;
       }
       return isim + " zam istiyor";
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "\nmaas=" + maas +
                "\nid=" + id +
                "\nitibarOrani=" + itibarOrani +
                "\nboy=" + boy +
                "\nkilo=" + kilo +
                "\nenerji=" + enerji +
                "\nyas=" + yas +
                "\nisim='" + isim + '\'' +
                '}';
    }
}
