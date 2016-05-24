package com.example.congsl.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button nextListViewButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextListViewButton = (Button) this.findViewById(R.id.nextListView);
        final Context self = this;
        nextListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                System.out.println(intent);
                intent.setClass(self, ListViewActivity.class);
                self.startActivity(intent);
            }
        });
        Button webView = (Button) this.findViewById(R.id.webview);
        webView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(self, WebViewActivity.class);
                self.startActivity(intent);
            }
        });
    }
}
