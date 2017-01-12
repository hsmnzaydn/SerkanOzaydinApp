package net.serkanozaydin.serkanozaydinapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

public class Gosterim_Sayfasi extends AppCompatActivity {
    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gosterim__sayfasi);
         fragmentManager=getSupportFragmentManager();




        FragmentTransaction transaction=fragmentManager.beginTransaction();
        Anasayfa fragment=new Anasayfa();
        transaction.replace(R.id.container,fragment,"deneme");
        transaction.commit();



    }


}
