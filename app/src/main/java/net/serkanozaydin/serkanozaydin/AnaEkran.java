package net.serkanozaydin.serkanozaydin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by dvcc on 1/10/17.
 */

public class AnaEkran extends Fragment {
    ListView postList;
    String url = "https://www.serkanozaydin.net/";

    FragmentManager fragmentManager;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.anasayfa_fragment_list,container,false);
        postList= (ListView) root.findViewById(R.id.liste);
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Model obj = gson.fromJson(json, Model.class);
        url=obj.getGidilecek_url();

        Veri_Cek veri=new Veri_Cek(getContext(),url,postList);
        veri.Yazilari_Cek();


        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View vg=view;
                TextView gidilecek_url= (TextView) vg.findViewById(R.id.txtGidilecekUrl);
                Log.i(gidilecek_url.getText().toString(),"link");


                Model model=new Model(gidilecek_url.getText().toString());


                SharedPreferences  mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(model);
                prefsEditor.putString("MyObject", json);
                prefsEditor.commit();

                fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                Yazi_gosterim fragment=new Yazi_gosterim();
                transaction.replace(R.id.container,fragment,"deneme");
                transaction.addToBackStack(null);
                transaction.commit();



            }
        });





        return root;
    }

}
