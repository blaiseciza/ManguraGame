package com.blaiseciza.manguragame;
import java.lang.Thread;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;


public class PageGame extends Activity implements View.OnClickListener {
    int[] machine=new int[16];
    int[] person =new int[16];
    int Grand=0;
    int scorePersonne=0;
    int indiceMach;
    Button lm1,lm2,lm3,lm4,lm5,lm6,lm7,lm8,lm9,lm10,lm11,lm12,lm13,lm14,lm15,lm16,
    lp1,lp2,lp3,lp4,lp5,lp6,lp7,lp8,lp9,lp10,lp11,lp12,lp13,lp14,lp15,lp16;
    Button btnNiveau;
    LinearLayout btnNegative,btnPositive;
    int conteneur=0,compte=0;
    private ProgressBar prog;
    String niv="1",lang="francais",music="stop";
    String result1;
    String sens="normal";
    boolean allowR=false;
    Drawable bak;
    Drawable assistbck;
    //element d'animation
    Button b;Animation animation;
    MediaPlayer mySong1;

    private void BtMachine(){
        lm1=(Button)findViewById(R.id.lm1);
        lm2=(Button)findViewById(R.id.lm2);
        lm3=(Button)findViewById(R.id.lm3);
        lm4=(Button)findViewById(R.id.lm4);
        lm5=(Button)findViewById(R.id.lm5);
        lm6=(Button)findViewById(R.id.lm6);
        lm7=(Button)findViewById(R.id.lm7);
        lm8=(Button)findViewById(R.id.lm8);
        lm9=(Button)findViewById(R.id.lm9);
        lm10=(Button)findViewById(R.id.lm10);
        lm11=(Button)findViewById(R.id.lm11);
        lm12=(Button)findViewById(R.id.lm12);
        lm13=(Button)findViewById(R.id.lm13);
        lm14=(Button)findViewById(R.id.lm14);
        lm15=(Button)findViewById(R.id.lm15);
        lm16=(Button)findViewById(R.id.lm16);
    }
    private void BtPerson(){
        lp1=(Button)findViewById(R.id.lp1);
        lp2=(Button)findViewById(R.id.lp2);
        lp3=(Button)findViewById(R.id.lp3);
        lp4=(Button)findViewById(R.id.lp4);
        lp5=(Button)findViewById(R.id.lp5);
        lp6=(Button)findViewById(R.id.lp6);
        lp7=(Button)findViewById(R.id.lp7);
        lp8=(Button)findViewById(R.id.lp8);
        lp9=(Button)findViewById(R.id.lp9);
        lp10=(Button)findViewById(R.id.lp10);
        lp11=(Button)findViewById(R.id.lp11);
        lp12=(Button)findViewById(R.id.lp12);
        lp13=(Button)findViewById(R.id.lp13);
        lp14=(Button)findViewById(R.id.lp14);
        lp15=(Button)findViewById(R.id.lp15);
        lp16=(Button)findViewById(R.id.lp16);

    }
    private void setONdclic(){
        lp1.setOnClickListener(this);
        lp2.setOnClickListener(this);
        lp3.setOnClickListener(this);
        lp4.setOnClickListener(this);
        lp5.setOnClickListener(this);
        lp6.setOnClickListener(this);
        lp7.setOnClickListener(this);
        lp8.setOnClickListener(this);
        lp9.setOnClickListener(this);
        lp10.setOnClickListener(this);
        lp11.setOnClickListener(this);
        lp12.setOnClickListener(this);
        lp13.setOnClickListener(this);
        lp14.setOnClickListener(this);
        lp15.setOnClickListener(this);
        lp16.setOnClickListener(this);
        //btnRetour.setOnClickListener(this);
//        btnNegative.setOnClickListener(this);
//        btnPositive.setOnClickListener(this);
    }
    private void setBack(int jn,int[] tab,View view){
        switch (tab[jn]){
            case 0:view.setBackground(getResources().getDrawable(R.drawable.backtr));break;
            case 1:view.setBackground(getResources().getDrawable(R.drawable.bckun));break;
            case 2:view.setBackground(getResources().getDrawable(R.drawable.bckdeux));break;
            case 3:view.setBackground(getResources().getDrawable(R.drawable.bcktrois));break;
            case 4:view.setBackground(getResources().getDrawable(R.drawable.bckquatre));break;
            case 5:view.setBackground(getResources().getDrawable(R.drawable.bckcinq));break;
            case 6:view.setBackground(getResources().getDrawable(R.drawable.bcksix));break;
            case 7:view.setBackground(getResources().getDrawable(R.drawable.bcksept));break;
            case 8:view.setBackground(getResources().getDrawable(R.drawable.bckhuit));break;
            case 9:view.setBackground(getResources().getDrawable(R.drawable.bckneuf));break;
            case 10:view.setBackground(getResources().getDrawable(R.drawable.bckonze));break;
            case 11:view.setBackground(getResources().getDrawable(R.drawable.bckonze));break;
            case 12:view.setBackground(getResources().getDrawable(R.drawable.bckdouse));break;
            default:view.setBackground(getResources().getDrawable(R.drawable.bckdouse));break;

        }
    }
    private void valPerson(int[] tab){
        BtMachine();BtPerson();
        Button btnComp=(Button)findViewById(R.id.btnCompte);
        btnComp.setText(String.valueOf(conteneur));
        prog.setProgress(conteneur*5);

        for (int x=0;x<tab.length;x++){
          switch (x){
              case 0:lp1.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp1);
                  break;
              case 1:lp2.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp2);
                  break;
              case 2:lp3.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp3);
                  break;
              case 3:lp4.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp4);
                  break;
              case 4:lp5.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp5);
                  break;
              case 5:lp6.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp6);
                  break;
              case 6:lp7.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp7);
                  break;
              case 7:lp8.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp8);
                  break;
              case 8:lp9.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp9);
                  break;
              case 9:lp10.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp10);
                  break;
              case 10:lp11.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp11);
                  break;
              case 11:lp12.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp12);
                  break;
              case 12:lp13.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp13);
                  break;
              case 13:lp14.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp14);
                  break;
              case 14:lp15.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp15);
                  break;
              case 15:lp16.setText(String.valueOf(tab[x]));
                  setBack(x,tab,lp16);
                  break;

          }
        }

    }
    private void valMachine(final int[] tab){
        BtMachine();BtPerson();
        for (int x=0;x<tab.length;x++){

            switch (x){

                case 0:lm1.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm1);
                    break;
                case 1:lm2.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm2);
                    break;
                case 2:lm3.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm3);
                    break;
                case 3:lm4.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm4);
                    break;
                case 4:lm5.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm5);
                    break;
                case 5:lm6.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm6);
                    break;
                case 6:lm7.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm7);
                    break;
                case 7:lm8.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm8);
                    break;
                case 8:lm9.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm9);
                    break;
                case 9:lm10.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm10);
                    break;
                case 10:lm11.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm11);
                    break;
                case 11:lm12.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm12);
                    break;
                case 12:lm13.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm13);
                    break;
                case 13:lm14.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm14);
                    break;
                case 14:lm15.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm15);
                    break;
                case 15:lm16.setText(String.valueOf(tab[x]));
                    setBack(x,tab,lm16);
                    break;

            }
        }

    }
    private void setEnPerson(boolean b){
        lp1.setEnabled(b);
        lp2.setEnabled(b);
        lp3.setEnabled(b);
        lp4.setEnabled(b);
        lp5.setEnabled(b);
        lp6.setEnabled(b);
        lp7.setEnabled(b);
        lp8.setEnabled(b);
        lp9.setEnabled(b);
        lp10.setEnabled(b);
        lp11.setEnabled(b);
        lp12.setEnabled(b);
        lp13.setEnabled(b);
        lp14.setEnabled(b);
        lp15.setEnabled(b);
        lp16.setEnabled(b);
    }
    private void setAssistbackPers(Drawable drwbl){
        lp1.setBackground(drwbl);
        lp2.setBackground(drwbl);
        lp3.setBackground(drwbl);
        lp4.setBackground(drwbl);
        lp5.setBackground(drwbl);
        lp6.setBackground(drwbl);
        lp7.setBackground(drwbl);
        lp8.setBackground(drwbl);
        lp9.setBackground(drwbl);
        lp10.setBackground(drwbl);
        lp11.setBackground(drwbl);
        lp12.setBackground(drwbl);
        lp13.setBackground(drwbl);
        lp14.setBackground(drwbl);
        lp15.setBackground(drwbl);
        lp16.setBackground(drwbl);
    }
    private void initialiseComp(){
        for(int x=0;x<8;x++){person[x]=4;}
        for(int x=8;x<16;x++){person[x]=0;}
        for(int x=0;x<8;x++){machine[x]=4;}
        for(int x=8;x<16;x++){machine[x]=0;}
        conteneur=0;
        valMachine(machine);
        valPerson(person);
    setEnPerson(true);
    }
    private void perdu(){

        int s=0,m=0;
        for(int k=0;k<=15;k++){
            if(person[k]<2){
                s++;
            }
            if(machine[k]<2){m++; }
        }
//        if(s>11){dangerPersonne();}
//        else{
//            sauverPersonne();
//        }
//        if(m>11){dangerMachine();}
//        else{sauverMachine();}
        if(s==16){
            showCustomToast("GAME OVER");
            initialiseComp();
            result1=getResources().getString(R.string.resultat_Echec);
            showMyAlertDialogResultNeg(this,result1);
        }
    }
    private void gagner(){

        int s=0;
        for(int k=0;k<=15;k++){
            if(machine[k]<2){
                s++;
            }}
        if(s==16){
            showCustomToast("CONGRATULATION");
            initialiseComp();
            result1=getResources().getString(R.string.resultat_Reussi);
            showMyAlertDialogResult(this,result1);


        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_game);
        prog=(ProgressBar)findViewById(R.id.progressBar);
        btnNiveau=(Button)findViewById(R.id.btnNiveau);
//        btnNegative=(LinearLayout) findViewById(R.id.btnNegative);
//        btnPositive=(LinearLayout) findViewById(R.id.btnPositive);
        initialiseComp();
        setONdclic();
        //Bundle gotBasket=getIntent().getExtras();
        //niv=gotBasket.getString("niveau");
        btnNiveau.setText("# "+niv);
        assistbck=getResources().getDrawable(R.drawable.assistanceback);
        bak=getResources().getDrawable(R.drawable.backtr);
        allowR=false;
        mySong1 = MediaPlayer.create(PageGame.this, R.raw.sondepot);
        //mySong1.start();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_game, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //super.onOptionsItemSelected(item);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.action_settings:showMyAlertDialogSettings(this);return true;
//            PopupMenu popup = new PopupMenu(
//                    PageGame.this,view);
//            MenuInflater inflater = popup.getMenuInflater();
//            inflater.inflate(R.menu.menu_page_game, popup.getMenu());
//            popup.show();
           case R.id.action_help:showMyAlertDialogHelp(this); break;
            case R.id.action_apropos:showMyAlertDialogAbout(this); break;
            case R.id.action_media:showSocialMedia();return true;
            case R.id.action_isig:showIsigPage();return true;
            case R.id.action_exit:finish();return true;
            default:
                return super.onContextItemSelected(item);
        }
    return false;
    }

    private void pauseRun() {

         }
    public void ToursMachine(final int i){
//        Thread pz=new Thread(){
//            public void run(){
                try{
                    int t;
                    int y = i+1;t=machine[i];
                    machine[i]=0;
                    for(int c=1;c<=t;c++,y++){
                        if((y>15)&&(y<=31)){y=y-16;}
                        else if((y>31)&&(y<=47)){y=y-32;}
                        else if((y>47)&&(y<=63)){y=y-48;}

                        machine[y]+=1;
                        valMachine(machine);
                        //sleep(500);
                        if(c==t){

                            if(machine[y]>1){
                                if((y>=0)&&(y<=7)){
                                    int m1=7-y,m2=15-m1;

                                    if((person[m2]>0)&&(person[m1])>0){
                                        t=person[m1]+person[m2];person[m1]=0;person[m2]=0;valPerson(person);
                                        y=16+y-c;
                                        c=0;

                                    }

                                    else if((person[m1]==0)||(person[m2]==0)){
                                        c=0;
                                        t=machine[y];
                                        machine[y]=0;
                                    }



                                }else if((y>=8)&&(y<=15)){
                                    c=0;t=machine[y];machine[y]=0;
                                }}
                            else if(machine[y]<=1){
                                c=t;
                            }}

                    }

                }catch (Exception e){
                    e.printStackTrace();

                }finally {
                    gagner();perdu();

                }
//            }
//        };pz.start();
        }

   public void ToursTESTbcMachine(int i){
        int Q=0;
        int[] machineT=new int[16];
        int[] personneT=new int[16];
        for(int k=0;k<=15;k++){
            machineT[k]=0+machine[k];
            personneT[k]=0+person[k];
        }
        int t=machineT[i];

        int y = i+1;
        machineT[i]=0;
        for(int c=1;c<=t;c++,y++){

            if((y>15)&&(y<=31)){y=y-16;}
            else if((y>31)&&(y<=47)){y=y-32;}
            else if((y>47)&&(y<=63)){y=y-48;}

            machineT[y]+=1;

            if(c==t){

                if(machineT[y]>1){
                    if((y>=0)&&(y<=7)){
                        int m1=7-y,m2=15-m1;

                        if((personneT[m2]>0)&&(personneT[m1])>0){
                            t=personneT[m1]+personneT[m2];personneT[m1]=0;personneT[m2]=0;
                            Q=Q+t;
                            y=16+y-c;
                            c=0;

                        }

                        else if((personneT[m1]==0)||(personneT[m2]==0)){
                            c=0;
                            t=machineT[y];
                            machineT[y]=0;
                        }



                    }else if((y>=8)&&(y<=15)){
                        c=0;t=machineT[y];machineT[y]=0;
                    }}
                else if(machineT[y]<=1){
                    c=t;
                }}
        }
        if(Q>=Grand){Grand=Q;indiceMach=i;}

    }
    public void MachineFantom(){
        int s=0;
        for(int j=0;j<=15;j++){
            if(machine[j]>1){
                ToursTESTbcMachine(j);

            }
            else{s++;}
        }Grand=0;
        if(s==16){
            Toast.makeText(getApplicationContext(),"CONGRATULATION!!!\\n===VOUS AVEZ GAGNER !===",Toast.LENGTH_LONG).show();
            initialiseComp();
            result1=getResources().getString(R.string.resultat_Reussi);
            showMyAlertDialogResult(this,result1);
        }else{
            ToursMachine(indiceMach);

        }

    }
     public void Machine(){

        int s=0;
        int k = 0,G=2,d=0;

        for(int i=0;i<=15;i++){
            int lower=0;
            int higher=15;
            higher++;
            int random=(int)(Math.random()*(higher-lower))+lower;
            if(machine[random]>=G){

                k=random;

            }
            else{s++;}
        }
        if(s==16){
            Toast.makeText(getApplicationContext(),"CONGRATULATION!!!\\n===VOUS AVEZ GAGNER !===",Toast.LENGTH_LONG).show();
            initialiseComp();
            result1=getResources().getString(R.string.resultat_Reussi);
            showMyAlertDialogResult(this,result1);
        }else{

            ToursMachine(k);
}

    }
    //===========================tours personne joueur avec clic==============================
    public void ToursCz(int i){
               int y = i ;
                conteneur--;

               person[y] += 1;
               valPerson(person);
                valMachine(machine);
        setAssistbckSpecifiq(i,assistbck);
        setENspecifiqPerson(i,true);

               if (conteneur==0) {

                   if (person[y] > 1) {
                       if ((y >= 0) && (y <= 7)) {
                           int m1 = 7 - y, m2 = 15 - m1;

                           if ((machine[m2] > 0) && (machine[m1]) > 0) {
                               conteneur = machine[m1] + machine[m2];
                               scorePersonne+=conteneur;
                               machine[m1] = 0;
                               machine[m2] = 0;
                               valMachine(machine);
                               valPerson(person);
                               setAssbakPerduMachine(m1,assistbck);
                               setAssbakPerduMachine(m2,assistbck);

                               setEnPerson(false);
                               //setAssistbackPers(bak);

                               if(sens=="normal"){i = 16 + i - compte;}
                               else if(sens=="reba"){i = i + compte;}
                                   //allowReba(i,conteneur);
                                  // if(allowR){
                                    //   allowR=false;
                                   //}else{
                                     //  sens="normal";
                                     //  setENspecifiqPerson(i,true);
                                      // setAssistbckSpecifiq(i,assistbck);
                                   //}
                               sens="normal";
                               setENspecifiqPerson(i,true);
                               setAssistbckSpecifiq(i,assistbck);


                               compte = 0;


                           } else if ((machine[m1] == 0) || (machine[m2] == 0)) {
                               compte = 0;
                               conteneur = person[y];
                               person[y] = 0;
                               valPerson(person);
                               setENspecifiqPerson(i,true);
                               setAssistbckSpecifiq(i,assistbck);
                           }


                       } else if ((y >= 8) && (y <= 15)) {
                           compte = 0;
                           conteneur = person[y];
                           person[y] = 0;
                           valPerson(person);
                           setENspecifiqPerson(i,true);
                           setAssistbckSpecifiq(i,assistbck);
                       }
                   } else if (person[y] <= 1) {
                       compte = 0;
                       conteneur=0;
                       //setEnPerson(false);

                   }
               }

               compte++;
        gagner();perdu();
        if(conteneur==0){
            //resetbakPerduMachine();
            valMachine(machine);
           if(niv.equals("2")){
            MachineFantom();}else{
               Machine();
           }setEnPerson(true);valPerson(person);
            //setAssistbackPers(bak);
            }}

    private void setENspecifiqPerson(int p,boolean tf){

              if ((p > 15) && (p <= 31)) {
                  p = p - 16;
              } else if ((p > 31) && (p <= 47)) {
                  p = p - 32;
              } else if ((p > 47) && (p <= 63)) {
                  p = p - 48;
             }
        if(sens=="normal"){
        switch (p){
            case 0:lp2.setEnabled(tf) ;break;
            case 1:lp3.setEnabled(tf);break;
            case 2:lp4.setEnabled(tf);break;
            case 3:lp5.setEnabled(tf);break;
            case 4:lp6.setEnabled(tf);break;
            case 5:lp7.setEnabled(tf);break;
            case 6:lp8.setEnabled(tf);break;
            case 7:lp9.setEnabled(tf);break;
            case 8:lp10.setEnabled(tf);break;
            case 9:lp11.setEnabled(tf);break;
            case 10:lp12.setEnabled(tf);break;
            case 11:lp13.setEnabled(tf);break;
            case 12:lp14.setEnabled(tf);break;
            case 13:lp15.setEnabled(tf);break;
            case 14:lp16.setEnabled(tf);break;
            case 15:lp1.setEnabled(tf);break;
        }}else if(sens=="reba"){
        switch (p){
            case 0:lp16.setEnabled(tf) ;break;
            case 1:lp1.setEnabled(tf);break;
            case 2:lp2.setEnabled(tf);break;
            case 3:lp3.setEnabled(tf);break;
            case 4:lp4.setEnabled(tf);break;
            case 5:lp5.setEnabled(tf);break;
            case 6:lp6.setEnabled(tf);break;
            case 7:lp7.setEnabled(tf);break;
            case 8:lp8.setEnabled(tf);break;
            case 9:lp9.setEnabled(tf);break;
            case 10:lp10.setEnabled(tf);break;
            case 11:lp11.setEnabled(tf);break;
            case 12:lp12.setEnabled(tf);break;
            case 13:lp13.setEnabled(tf);break;
            case 14:lp14.setEnabled(tf);break;
            case 15:lp15.setEnabled(tf);break;
        }}
    }
    private void setAssistbckSpecifiq(int p,Drawable drwbl){
        if ((p > 15) && (p <= 31)) {
            p = p - 16;
        } else if ((p > 31) && (p <= 47)) {
            p = p - 32;
        } else if ((p > 47) && (p <= 63)) {
            p = p - 48;
        }
        if(sens=="normal"){

        switch (p){
            case 0:lp2.setBackground(drwbl);
                if(conteneur !=0){
                 b = (Button) findViewById(R.id.lp2);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 1:lp3.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp3);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 2:lp4.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp4);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 3:lp5.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp5);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 4:lp6.setBackground(drwbl);
                if(conteneur !=0) {
                    b = (Button) findViewById(R.id.lp6);
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animator);
                    b.startAnimation(animation);
                }
                break;
            case 5:lp7.setBackground(drwbl);
                if(conteneur !=0) {
                    b = (Button) findViewById(R.id.lp7);
                    animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animator);
                    b.startAnimation(animation);
                }
                break;
            case 6:lp8.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp8);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 7:lp9.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp9);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 8:lp10.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp10);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 9:lp11.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp11);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 10:lp12.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp12);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 11:lp13.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp13);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 12:lp14.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp14);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 13:lp15.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp15);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 14:lp16.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp16);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 15:lp1.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp1);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
        }}else if(sens=="reba"){
        switch (p){
            case 0:lp16.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp16);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 1:lp1.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp1);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 2:lp2.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp2);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 3:lp3.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp3);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 4:lp4.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp4);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 5:lp5.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp5);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 6:lp6.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp6);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 7:lp7.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp7);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 8:lp8.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp8);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 9:lp9.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp9);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 10:lp10.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp10);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 11:lp11.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp11);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 12:lp12.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp12);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 13:lp13.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp13);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 14:lp14.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp14);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
            case 15:lp15.setBackground(drwbl);
                if(conteneur !=0){
                b = (Button) findViewById(R.id.lp15);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);}
                break;
        }}
    }
    private void setAssbakPerduMachine(int p,Drawable drwbl){
        if ((p > 15) && (p <= 31)) {
            p = p - 16;
        } else if ((p > 31) && (p <= 47)) {
            p = p - 32;
        } else if ((p > 47) && (p <= 63)) {
            p = p - 48;
        }
        switch (p){
            case 0:lm1.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm1);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 1:lm2.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm2);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 2:lm3.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm3);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 3:lm4.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm4);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 4:lm5.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm5);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 5:lm6.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm6);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 6:lm7.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm7);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 7:lm8.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm8);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 8:lm9.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm9);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 9:lm10.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm10);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 10:lm11.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm11);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 11:lm12.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm12);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 12:lm13.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm13);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 13:lm14.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm14);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 14:lm15.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm15);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
            case 15:lm16.setBackground(drwbl);
                b = (Button) findViewById(R.id.lm16);
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animator);
                b.startAnimation(animation);
                break;
        }
    }
    private void resetbakPerduMachine(){
        for (int i=0;i<=15;i++){
            setAssbakPerduMachine(i,bak);
        }
    }
    private void allowReba(int j,int h){
        int jr=j-h;
        if (jr < 0){jr=jr+16;}
        if((jr>=0)&&(jr<=7)){
            int n1=7-jr,n2=15-n1;
            if((machine[n1]>0)&&(machine[n2]>0)){
                showMyAlertDialog(this,j);

            }
        }
        setAssistbckSpecifiq(j,assistbck);
        setENspecifiqPerson(j,true);
    }

////////////////////////////////////special clic//////////////////////////////////////////////////////
    @Override
    public void onClick(View v) {
//        LayoutInflater layoutInflater=(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//        View popUpView=layoutInflater.inflate(R.layout.activity_help,null);
//        final PopupWindow popup = new PopupWindow(popUpView, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
//            //WindowInflater inflater = popup.getInflater();
//           // inflater.inflate(R.layout.activity_page_game, popup.getClass());
//            //popup.showAtLocation(findViewById(R.layout.activity_page_game), Gravity.CENTER,0,0);
//        popup.showAtLocation(popUpView,Gravity.CENTER,0,0);

        String pasSuff="pas suffisant pour faire un tour!";
        if(conteneur==0){
            ((Vibrator) getSystemService(Context.VIBRATOR_SERVICE)).vibrate(300);
//            setAssistbackPers(bak);
            sens="normal";

        if(v.getId()==R.id.lp1){
            if(person[0]<=1){
                showCustomToast(pasSuff);}else {
            conteneur=person[0];
            person[0]=0;
                valPerson(person);
            setEnPerson(false);
                setAssistbckSpecifiq(15,bak);
                setAssistbckSpecifiq(0,assistbck);
                setENspecifiqPerson(0,true);
                //lp2.setEnabled(true);
            }

        }
        else if(v.getId()==R.id.lp2){
            if(person[1]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[1];
                    person[1]=0;
                valPerson(person);
            setEnPerson(false);
                //lp3.setEnabled(true);
                setAssistbckSpecifiq(0,bak);
                setAssistbckSpecifiq(1,assistbck);
                setENspecifiqPerson(1,true);
            }

        }
        else if(v.getId()==R.id.lp3){
            if(person[2]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[2];
            person[2]=0;
                valPerson(person);
                setEnPerson(false);
                //lp4.setEnabled(true);
                setAssistbckSpecifiq(1,bak);
                setAssistbckSpecifiq(2,assistbck);
                setENspecifiqPerson(2,true);
            }

        }
        else if(v.getId()==R.id.lp4){
            if(person[3]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[3];
            person[3]=0;
                valPerson(person);
                setEnPerson(false);
                //lp5.setEnabled(true);
                setAssistbckSpecifiq(2,bak);
                setAssistbckSpecifiq(3,assistbck);
                setENspecifiqPerson(3,true);
            }

        }
        else if(v.getId()==R.id.lp5){
            if(person[4]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[4];
            person[4]=0;
                valPerson(person);
                setEnPerson(false);
                //lp6.setEnabled(true);
                setAssistbckSpecifiq(3,bak);
                setAssistbckSpecifiq(4,assistbck);
                setENspecifiqPerson(4,true);
            }

        }

        else if(v.getId()==R.id.lp6){
            if(person[5]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[5];
            person[5]=0;
                valPerson(person);
                setEnPerson(false);
                //lp7.setEnabled(true);
                setAssistbckSpecifiq(4,bak);
                setAssistbckSpecifiq(5,assistbck);
                setENspecifiqPerson(5,true);
            }

        }
        else if(v.getId()==R.id.lp7){
            if(person[6]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[6];
                setEnPerson(false);
                allowReba(6,person[6]);
                person[6]=0;
                valPerson(person);
                setAssistbckSpecifiq(5,bak);
                if(!allowR){
                    setAssistbckSpecifiq(6,assistbck);
                    setENspecifiqPerson(6,true);
                    allowR=false;
                }



            }

        }
        else if(v.getId()==R.id.lp8){
            if(person[7]<=1){
                showCustomToast(pasSuff);}else{
            conteneur=person[7];
            person[7]=0;
                valPerson(person);
                setEnPerson(false);
                //lp9.setEnabled(true);
                setAssistbckSpecifiq(6,bak);
                setAssistbckSpecifiq(7,assistbck);
                setENspecifiqPerson(7,true);
            }

        }
        else if(v.getId()==R.id.lp9){
            if(person[8]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[8];
                setEnPerson(false);
                allowReba(8,person[8]);
                person[8]=0;
                valPerson(person);

                setAssistbckSpecifiq(7,bak);
                if(!allowR){
                    setAssistbckSpecifiq(8,assistbck);
                    setENspecifiqPerson(8,true);
                    allowR=false;
                }


            }

        }
        else if(v.getId()==R.id.lp10){
            if(person[9]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[9];
            person[9]=0;
                valPerson(person);
                setEnPerson(false);
                //lp11.setEnabled(true);
                setAssistbckSpecifiq(8,bak);
                setAssistbckSpecifiq(9,assistbck);
                setENspecifiqPerson(9,true);
            }

        }
        else if(v.getId()==R.id.lp11){
            if(person[10]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[10];
            person[10]=0;
                valPerson(person);
                setEnPerson(false);
                //lp12.setEnabled(true);
                setAssistbckSpecifiq(9,bak);
                setAssistbckSpecifiq(10,assistbck);
                setENspecifiqPerson(10,true);
            }

        }
        else if(v.getId()==R.id.lp12){
            if(person[11]<=1){
                showCustomToast(pasSuff); }else{
            conteneur=person[11];
            person[11]=0;
                valPerson(person);
                setEnPerson(false);
                //lp13.setEnabled(true);
                setAssistbckSpecifiq(10,bak);
                setAssistbckSpecifiq(11,assistbck);
                setENspecifiqPerson(11,true);
            }

        }
        else if(v.getId()==R.id.lp13){
            if(person[12]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[12];
            person[12]=0;
                valPerson(person);
                setEnPerson(false);
                //lp14.setEnabled(true);
                setAssistbckSpecifiq(11,bak);
                setAssistbckSpecifiq(12,assistbck);
                setENspecifiqPerson(12,true);
            }

        }
        else if(v.getId()==R.id.lp14){
            if(person[13]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[13];
            person[13]=0;
                valPerson(person);
                setEnPerson(false);
                //lp15.setEnabled(true);
                setAssistbckSpecifiq(12,bak);
                setAssistbckSpecifiq(13,assistbck);
                setENspecifiqPerson(13,true);
            }

        }
        else if(v.getId()==R.id.lp15){
            if(person[14]<=1){
                showCustomToast(pasSuff);  }else{
            conteneur=person[14];
            person[14]=0;
                valPerson(person);
                setEnPerson(false);
                //lp16.setEnabled(true);
                setAssistbckSpecifiq(13,bak);
                setAssistbckSpecifiq(14,assistbck);
                setENspecifiqPerson(14,true);
            }

        }
        else if(v.getId()==R.id.lp16){
            if(person[15]<=1){
                showCustomToast(pasSuff);
            }else{
            conteneur=person[15];
            person[15]=0;
                valPerson(person);
                setEnPerson(false);
                //lp1.setEnabled(true);
                setAssistbckSpecifiq(14,bak);
                setAssistbckSpecifiq(15,assistbck);
                setENspecifiqPerson(15,true);
            }

        }
           // valPerson(person);

//            if(conteneur>1){showCustomToast(distrib);}

        }else{///////////////////////////clic distribuer
            mySong1.stop();
            mySong1 = MediaPlayer.create(PageGame.this, R.raw.sondepot);
            mySong1.start();

            if(v.getId()==R.id.lp1){
                setEnPerson(false);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(0,assistbck);
//                setENspecifiqPerson(0,true);
                ToursCz(0);
            }
            else if(v.getId()==R.id.lp2){
                setEnPerson(false);
                //lp3.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(1,assistbck);
//                setENspecifiqPerson(1,true);
                ToursCz(1);

            }
            else if(v.getId()==R.id.lp3){
                setEnPerson(false);
                //lp4.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(2,assistbck);
//                setENspecifiqPerson(2,true);
                ToursCz(2);
            }
            else if(v.getId()==R.id.lp4){
                setEnPerson(false);
                //lp5.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(3,assistbck);
//                setENspecifiqPerson(3,true);
                ToursCz(3);
            }
            else if(v.getId()==R.id.lp5){
                setEnPerson(false);
                //lp6.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(4,assistbck);
//                setENspecifiqPerson(4,true);
                ToursCz(4);
            }

            else if(v.getId()==R.id.lp6){
                setEnPerson(false);
                //lp7.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(5,assistbck);
//                setENspecifiqPerson(5,true);
                ToursCz(5);
            }
            else if(v.getId()==R.id.lp7){
                setEnPerson(false);
                //lp8.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(6,assistbck);
//                setENspecifiqPerson(6,true);
                ToursCz(6);

            }
            else if(v.getId()==R.id.lp8){
                setEnPerson(false);
                //lp9.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(7,assistbck);
//                setENspecifiqPerson(7,true);
                ToursCz(7);

            }
            else if(v.getId()==R.id.lp9){
                setEnPerson(false);
                //lp10.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(8,assistbck);
//                setENspecifiqPerson(8,true);
                ToursCz(8);

            }
            else if(v.getId()==R.id.lp10){
                setEnPerson(false);
                //lp11.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(9,assistbck);
//                setENspecifiqPerson(9,true);
                ToursCz(9);

            }
            else if(v.getId()==R.id.lp11){
                setEnPerson(false);
                //lp12.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(10,assistbck);
//                setENspecifiqPerson(10,true);
                ToursCz(10);

            }
            else if(v.getId()==R.id.lp12){
                setEnPerson(false);
                //lp13.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(11,assistbck);
//                setENspecifiqPerson(11,true);
                ToursCz(11);


            }
            else if(v.getId()==R.id.lp13){
                setEnPerson(false);
                //lp14.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(12,assistbck);
//                setENspecifiqPerson(12,true);
                ToursCz(12);

            }
            else if(v.getId()==R.id.lp14){
                setEnPerson(false);
                //lp15.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(13,assistbck);
//                setENspecifiqPerson(13,true);
                ToursCz(13);

            }
            else if(v.getId()==R.id.lp15){
                setEnPerson(false);
                //lp16.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(14,assistbck);
//                setENspecifiqPerson(14,true);
                ToursCz(14);

            }
            else if(v.getId()==R.id.lp16){
                setEnPerson(false);
                //lp1.setEnabled(true);
//                setAssistbackPers(bak);
//                setAssistbckSpecifiq(15,assistbck);
//                setENspecifiqPerson(15,true);
                ToursCz(15);

            }
//            valPerson(person);

        }
//        if(v.getId()==R.id.btnNegative){
//            sens="reba";
//            allowR=true;
////            setAssistbckSpecifiq(f,assistbck);
////            setENspecifiqPerson(f,true);
//        }else if(v.getId()==R.id.btnPositive){
//            sens="normal";
//            allowR=false;}

    }
    /////////////////////////////////--------------////////////////////
///////custom toast
public void showCustomToast(String v){
// /////////////////////////////////////////////////
// this fragment creates a custom Toast showing
// image + text + shaped_background
    Toast customToast = makeCustomToast(this,v);
    customToast.show();
}
    private Toast makeCustomToast(Context context,String v) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.custom_toast, null);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText("*"+v);
        Toast toast = new Toast(context);
        toast.setMargin(0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        return toast;
    }//makeCustomToast

    private void showMyAlertDialog(PageGame pageGame, final int f){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.orientation_layout, null);
//        TextView text = (TextView) layout.findViewById(R.id.toast_text);
//        text.setText("  <<<============>>>  ");
        new AlertDialog.Builder(pageGame)
                .setTitle("ORIENTATION")
                .setView(layout)
                .setPositiveButton("   +  ",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    sens="normal";
//                        setAssistbckSpecifiq(f,assistbck);
//                        setENspecifiqPerson(f,true);
                        allowR=false;
                    }
                })
                .setNegativeButton("   -   ",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    sens="reba";
                        allowR=true;
                        setAssistbckSpecifiq(f,assistbck);
                        setENspecifiqPerson(f,true);
                    }
                })
                .create()
                .show();
    }
    //menu dialog
    private void showMyAlertDialogSettings(PageGame pageGame)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.parametre, null);
//        TextView text = (TextView) layout.findViewById(R.id.toast_text);
//        text.setText(""+getResources().getString(R.string.niveau));
        new AlertDialog.Builder(pageGame)
                .setTitle(""+getResources().getString(R.string.niveau))
                .setView(layout)
                .setPositiveButton(""+getResources().getString(R.string.facile),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        niv="1";
                        initialiseComp();
                        btnNiveau.setText("# "+niv);

                    }
                })
                .setNegativeButton(""+getResources().getString(R.string.difficile),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        niv="2";
                        initialiseComp();
                        btnNiveau.setText("# "+niv);

                    }
                })

                .create()
                .show();
    }
    private void showMyAlertDialogResult(PageGame pageGame,String Reslt){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.endfelicitation, null);
//        TextView text = (TextView) layout.findViewById(R.id.toast_text);
//        text.setText(""+Reslt);
        new AlertDialog.Builder(pageGame)
                .setTitle("***"+Reslt+"***\nTotal gains: "+scorePersonne +" graines")
                .setView(layout)
                .setPositiveButton(""+getResources().getString(R.string.continuer),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initialiseComp();
                    }
                })
                .setNegativeButton(""+getResources().getString(R.string.quitter),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })

                .create()
                .show();
    }
    //resultat quand il ya echec
    private void showMyAlertDialogResultNeg(PageGame pageGame,String Reslt){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.endgameover, null);
//        TextView text = (TextView) layout.findViewById(R.id.toast_text);
//        text.setText(""+Reslt);
        new AlertDialog.Builder(pageGame)
                .setTitle("***"+Reslt+"***\nTotal gains : "+scorePersonne +" graines")
                .setView(layout)
                .setPositiveButton(""+getResources().getString(R.string.continuer),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initialiseComp();
                    }
                })
                .setNegativeButton(""+getResources().getString(R.string.quitter),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                })

                .create()
                .show();
    }

    private void showMyAlertDialogHelp(PageGame pageGame){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.activity_help, null);
       // TextView text = (TextView) layout.findViewById(R.id.toast_text);
        //text.setText(""+Reslt);
        new AlertDialog.Builder(pageGame)
                .setTitle(""+getResources().getString(R.string.aide))
                .setView(layout)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
//                .setNegativeButton(""+getResources().getString(R.string.quitter),new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//
//                    }
//                })

                .create()
                .show();
    }
    private void showMyAlertDialogAbout(PageGame pageGame){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.apropos, null);
        // TextView text = (TextView) layout.findViewById(R.id.toast_text);
        //text.setText(""+Reslt);
        new AlertDialog.Builder(pageGame)
                .setTitle(""+getResources().getString(R.string.apropos))
                .setView(layout)
                .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
//                .setNegativeButton(""+getResources().getString(R.string.quitter),new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//
//                    }
//                })

                .create()
                .show();
    }
    private void showSocialMedia(){
        try{
            Intent op=new Intent(PageGame.this,EndPage.class);
            startActivity(op);
        }catch (Exception e){System.out.println(e.getMessage());}

        //finish();
    }
    private void showIsigPage(){
        Intent openActivity=new Intent(PageGame.this,isigActivity.class);
        startActivity(openActivity);
        //finish();
    }

}

