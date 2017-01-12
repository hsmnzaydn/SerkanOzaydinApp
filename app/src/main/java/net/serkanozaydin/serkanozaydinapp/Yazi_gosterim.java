package net.serkanozaydin.serkanozaydinapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;

/**
 * Created by dvcc on 1/12/17.
 */

public class Yazi_gosterim extends Fragment {
    WebView webView;
    FragmentManager fragmentManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.yazi_gosterim,container,false);
        webView= (WebView) root.findViewById(R.id.WebYazi);


        SharedPreferences mPrefs = getActivity().getPreferences(getActivity().MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Model obj = gson.fromJson(json, Model.class);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Yazi_Cek veri=new Yazi_Cek(getContext(),obj.getGidilecek_url(),webView);
        veri.Yazilari_Cek();








        return root;
    }





}
