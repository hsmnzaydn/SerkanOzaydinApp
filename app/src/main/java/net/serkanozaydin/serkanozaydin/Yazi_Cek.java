package net.serkanozaydin.serkanozaydin;

import android.content.Context;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dvcc on 1/12/17.
 */

public class Yazi_Cek {
    private Context context;
    private WebView webView;
    private String url;
    public String veriler;


    public Yazi_Cek(Context context, String url, WebView webView) {
        this.context = context;
        this.webView = webView;
        this.url = url;

    }

    public void Yazilari_Cek(){

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    byte[] u = response.toString().getBytes("ISO-8859-1");
                    response = new String(u, "UTF-8");

                    Document doc = Jsoup.parse(response);
                    Log.i(response,"deneme");


                    //ilk yazı için
                    Elements anasayfa=doc.select("div[class=post-inner group]");



                    veriler = anasayfa.outerHtml();

                    WebSettings settings = webView.getSettings();
                    settings.setDefaultTextEncodingName("utf-8");
                    webView.loadData(veriler, "text/html; charset=utf-8", "utf-8");


                }
                catch (Exception e){
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "Some error occurred", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            public Map<String,String> getHeaders(){
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("Authorization","ApplicationConstants.BASIC_AUTH");
                headers.put("User-agent", "My useragent");
                return headers;

            }
        };


        RequestQueue rQueue = Volley.newRequestQueue(context);
        rQueue.add(request);



    }
}
