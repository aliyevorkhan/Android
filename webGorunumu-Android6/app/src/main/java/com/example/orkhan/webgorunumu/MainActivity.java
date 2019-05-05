package com.example.orkhan.webgorunumu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //tariyici referansi olusturalim
       WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tarayicimizi tanitalim
        webView = (WebView)findViewById(R.id.webView);

        //javascriptleri calismasini saglayalim
        webView.getSettings().setJavaScriptEnabled(true);

        //bu kodu yazmazsak telefon tarayicisinda aciyor
        webView.setWebViewClient(new WebViewClient());

        //bu kod youtube.com tarzi sitelerde video oynatmasi icin
        webView.setWebChromeClient(new WebChromeClient());

        //bir url calistimasini istiyoruz
        webView.loadUrl("http://www.orkhub.wordpress.com");
    }
}
