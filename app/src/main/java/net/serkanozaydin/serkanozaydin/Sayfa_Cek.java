package net.serkanozaydin.serkanozaydin;

import android.content.Context;
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


/**
 * Created by dvcc on 1/11/17.
 */

public class Sayfa_Cek  {

    private Context context;
    private WebView webView;
    private String url;
    public String veriler;


    public Sayfa_Cek(Context context, String url, WebView webView) {
        this.context = context;
        this.webView = webView;
        this.url = url;

    }

    public void WebViewAktar(){




        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try{
                    byte[] u = response.toString().getBytes(
                            "ISO-8859-1");
                    response = new String(u, "UTF-8");

                    Document doc = Jsoup.parse(response);

                    Elements anasayfa = doc.select("div[class=entry themeform]");


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
                Toast.makeText(context, "Lütfen internet bağlantınızın kontrollerini yapınız", Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(context);
        rQueue.add(request);





    }



}
