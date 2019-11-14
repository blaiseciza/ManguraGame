package com.blaiseciza.manguragame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class EndPage extends Activity implements View.OnClickListener {
//    Button btnContinuer,btnQuitter;
//    String resultat,niveau;
//    TextView txtResultat;
WebView netview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);
//        Bundle gotBasket=getIntent().getExtras();
//        resultat=gotBasket.getString("resultat");
//        niveau=gotBasket.getString("niveau");
//        btnContinuer=(Button)findViewById(R.id.btnContinuer);
//        btnQuitter=(Button)findViewById(R.id.btnQuiter);
//        txtResultat=(TextView)findViewById(R.id.txtResultat);
//        txtResultat.setText("*"+resultat+"*");
//        btnContinuer.setOnClickListener(this);
//        btnQuitter.setOnClickListener(this);
        netview = (WebView) findViewById(R.id.netview);
        netview.loadUrl("https://www.facebook.com/Mangura-Game-1927547477556406/");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_end_page, menu);
        return true;
    }



    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnContinuer:
//           Bundle basket1=new Bundle();
//            basket1.putString("niveau","2");
//                Intent end=new Intent(EndPage.this,PageGame.class);
//                end.putExtras(basket1);
//                startActivity(end);
//                finish();
//                break;
//            case R.id.btnQuiter:
//                finish();
//        }
    }
}
