package com.example.orkhan.myapplication;

public class karakter {
    int kilo;
    int enerji;
    int saldiriGucu;
    String isim;
    public String yemek(){
        if (enerji > 0){
            kilo = kilo + 3;
            enerji = enerji +8;
            saldiriGucu = saldiriGucu + 3;
            return isim + " yemek yedi ve statistikleri artti";
        }
        else
            return "Yeterli enerji yok";
    }
    public String uyumak() {
        if (enerji > 0) {
            enerji = enerji + 18;
            saldiriGucu = saldiriGucu + 1;
            kilo = kilo - 3;
            return isim + " uyudu";
        }
        else
            return "Yeterli enerji yok";
    }
    public String savas(){
        if (enerji > 0) {
            kilo = kilo - 3;
            enerji = enerji - 3;
            saldiriGucu = saldiriGucu - 2;
            return isim + " savasdi ve statistikleri azaldi";
        }
        else
            return "Yeterli enerji yok";
    }
    public String toString(){
        return "Isim: " + isim
                + "\n Kilo: " + kilo
                +"\n Enerji: " + enerji
                +"\n Saldiri gucu: " + saldiriGucu;
    }
}
