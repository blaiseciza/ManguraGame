package com.blaiseciza.manguragame;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class isigActivity extends Activity {
    WebView netview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isig);
        netview = (WebView) findViewById(R.id.netv);
        netview.loadUrl("https://www.isig.ac.cd");
    }
}
