package net.serkanozaydin.serkanozaydin;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

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
