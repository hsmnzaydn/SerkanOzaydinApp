package net.serkanozaydin.serkanozaydinapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dvcc on 1/10/17.
 */

public class Adapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<Model> yazilar;
    Context context;

    public Adapter(Context context, List<Model> yazilar) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.yazilar = yazilar;
        this.context = context;
    }
    @Override
    public int getCount() {
        return yazilar.size();
    }

    @Override
    public Object getItem(int position) {
        return yazilar.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list_satir;
        list_satir=layoutInflater.inflate(R.layout.satir_layout,null);
        TextView baslik= (TextView) list_satir.findViewById(R.id.txtBaslik);
        TextView tarih= (TextView) list_satir.findViewById(R.id.txtTarih);
        TextView kategori= (TextView) list_satir.findViewById(R.id.txtKategori);
        TextView icerik= (TextView) list_satir.findViewById(R.id.txtIcerik);
        ImageView resim= (ImageView) list_satir.findViewById(R.id.ImgRes);
        TextView gidilecek_url= (TextView) list_satir.findViewById(R.id.txtGidilecekUrl);

        Model model=yazilar.get(position);

        kategori.setText(model.getKategori());
        baslik.setText(model.getBaslik());
        tarih.setText(model.getTarih());
        icerik.setText(model.Icerik_Degis());
        gidilecek_url.setText(model.getGidilecek_url());


        Picasso.with(context).load(model.getResim_url()).into(resim);
        return list_satir;
    }

}
