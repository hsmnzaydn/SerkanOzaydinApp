package net.serkanozaydin.serkanozaydin;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dvcc on 1/11/17.
 */

public class Veri_Cek {
    private ProgressDialog progressDialog;
    private String url;
    private Context context;
    private ListView liste;

    public Veri_Cek(Context context,String url,ListView liste){
        this.url=url;
        this.context=context;
        this.liste=liste;
    }

    public void Yazilari_Cek(){
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("SerkanOzaydin.net");
        progressDialog.setMessage("Yazılar Çekiliyor...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                List<Model> model=new ArrayList<Model>();
                try{
                    byte[] u = response.toString().getBytes(
                            "ISO-8859-1");
                    response = new String(u, "UTF-8");
                    Veritabani db=new Veritabani(context);
                 Document doc = Jsoup.parse(response);


                    //ilk yazı için
                    Elements anasayfa=doc.select("div[class=post-inner post-hover]");
                    Elements ilk_yazi_baslik=anasayfa.select("h2[class=post-title entry-title]");
                    Elements ilk_yazi_tarih=anasayfa.select("time[class=published updated]");
                    Elements ilk_yazi_icerik=anasayfa.select("div[class=entry excerpt entry-summary]");
                    Elements ilk_yazi_resim=anasayfa.select("img[src]");


                    Elements ilk_yazi_gidilecek_url=ilk_yazi_baslik.select("a[href]");

                        if(model.size()==0)
                        for (int i = 0; i < anasayfa.size(); i++) {

                            db.KayitEkle(new Model(ilk_yazi_baslik.get(i).text(), ilk_yazi_tarih.get(i).text(), ilk_yazi_icerik.get(i).text(), ilk_yazi_resim.get(i).attr("src"), ilk_yazi_gidilecek_url.get(i).attr("href")));

                        }
                    else{

                            for (int i = 0; i < anasayfa.size(); i++) {

                                db.KayitEkle(new Model(ilk_yazi_baslik.get(i).text(), ilk_yazi_tarih.get(i).text(), ilk_yazi_icerik.get(i).text(), ilk_yazi_resim.get(i).attr("src"), ilk_yazi_gidilecek_url.get(i).attr("href")));

                            }
                        }



                    model=db.TumKayitlariGetir();

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                Adapter adapter=new Adapter(context,model);
                liste.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressDialog.cancel();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "Some error occurred", Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(context);
        rQueue.add(request);



    }

}
