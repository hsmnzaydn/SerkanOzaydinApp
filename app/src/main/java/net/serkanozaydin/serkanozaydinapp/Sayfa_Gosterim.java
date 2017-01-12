package net.serkanozaydin.serkanozaydinapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebView;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by dvcc on 1/11/17.
 */

public class Sayfa_Gosterim extends Fragment {
    WebView webview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.sayfa_gosterimi, container, false);
        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Model obj = gson.fromJson(json, Model.class);
        webview = (WebView) root.findViewById(R.id.contant);
        webview.getSettings().setJavaScriptEnabled(true);


        Sayfa_Cek veri = new Sayfa_Cek(getContext(), obj.getGidilecek_url(), webview);
        veri.WebViewAktar();


        return root;
    }


}
