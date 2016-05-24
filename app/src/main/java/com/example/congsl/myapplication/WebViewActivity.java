package com.example.congsl.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = (WebView) this.findViewById(R.id.webView);
//        webView.setVerticalScrollbarOverlay(true);
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "file:///android_asset/demo.html";
        webView.loadUrl(url);
        webView.addJavascriptInterface(new JsInterface(this), "AndroidWebView");
        webView.setWebChromeClient(new WebChromeClient());
        Button btn = (Button) this.findViewById(R.id.funToJs);
        final WebViewActivity self = this;
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println(v);
                self.sendInfoToJs(v);
            }
        });
    }

    private class JsInterface {
        private Context context;

        public JsInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public void showInfoFromJs(String name) {
            System.out.println(name);
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
        }
    }

    public void sendInfoToJs(View view) {
        webView.loadUrl("javascript:funFromJs('from java"+new Date()+"')");
    }
}
