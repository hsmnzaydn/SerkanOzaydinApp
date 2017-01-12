package net.serkanozaydin.serkanozaydin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by dvcc on 1/11/17.
 */

public class Sosyal_Medya_Sayfa extends Fragment {

WebView webView;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.sosyal_medya_layout,container,false);
        webView= (WebView) root.findViewById(R.id.WebSosyal);

        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("MyObject", "");
        Model obj = gson.fromJson(json, Model.class);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(obj.getGidilecek_url());








        return root;
    }
}
