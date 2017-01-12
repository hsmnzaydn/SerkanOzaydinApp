package net.serkanozaydin.serkanozaydin;

/**
 * Created by dvcc on 1/10/17.
 */

public class Model {
    private String baslik;
    private String tarih;
    private String Kategori;
    private String resim_url;
    private String icerik;
    private String gidilecek_url;

    public Model(){

    }

    public Model(String baslik,String tarih,String icerik,String resim_url,String gidilecek_url){
        this.setBaslik(baslik);
        this.tarih=tarih;

        this.icerik=icerik;
        this.resim_url=resim_url;
        this.gidilecek_url=gidilecek_url;

    }
    public Model(String gidilecek_url){
        this.gidilecek_url=gidilecek_url;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getResim_url() {
        return resim_url;
    }

    public void setResim_url(String resim_url) {
        this.resim_url = resim_url;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getGidilecek_url() {
        return gidilecek_url;
    }

    public void setGidilecek_url(String gidilecek_url) {
        this.gidilecek_url = gidilecek_url;
    }

    public String Icerik_Degis(){
        String[] dizi=getIcerik().split(" ");


        return dizi[0]+" "+dizi[1]+" "+dizi[2]+" "+dizi[3]+" "+dizi[4]+" "+dizi[5]+" "+dizi[6]+" "+dizi[7]+" "+dizi[8]+" "+dizi[9]+" "+dizi[10]+" "+dizi[11]+" "+dizi[12]+" "+dizi[13]+" "+dizi[14]+" .....";
    }

    public String getKategori() {
        return Kategori;
    }

    public void setKategori(String kategori) {
        Kategori = kategori;
    }
}