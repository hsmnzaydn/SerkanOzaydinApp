package net.serkanozaydin.serkanozaydinapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;

import android.widget.Toast;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by dvcc on 1/10/17.
 */

public class Anasayfa extends Fragment {


    public ImageButton Anasayfa, BenKimim, Projelerim, WebUgra, Yeteneklerim, Linux, Android, RaspberryPi, KisiselDeneyimlerim, Facebook, Twitter, Github, Instagram, Android_Sosyal, Youtube;
    FragmentManager fragmentManager;

    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.anasayfa_fragment, container, false);
        WebUgra = (ImageButton) root.findViewById(R.id.btnWebUgra);
        Anasayfa = (ImageButton) root.findViewById(R.id.btnAnasayfa);
        BenKimim = (ImageButton) root.findViewById(R.id.btnBenKimim);
        Projelerim = (ImageButton) root.findViewById(R.id.btnProjelerim);
        Yeteneklerim = (ImageButton) root.findViewById(R.id.btnYeteneklerim);
        Linux = (ImageButton) root.findViewById(R.id.btnLinux);
        Android = (ImageButton) root.findViewById(R.id.btnAndroid);
        RaspberryPi = (ImageButton) root.findViewById(R.id.btnRaspberryPi);
        KisiselDeneyimlerim = (ImageButton) root.findViewById(R.id.btnKisiselDeneyim);
        Facebook = (ImageButton) root.findViewById(R.id.btnFacebook);
        Twitter = (ImageButton) root.findViewById(R.id.btnTwitter);
        Github = (ImageButton) root.findViewById(R.id.btnGithub);
        Instagram = (ImageButton) root.findViewById(R.id.btnInstagram);
        Android_Sosyal = (ImageButton) root.findViewById(R.id.btnAndroidSosyal);
        Youtube = (ImageButton) root.findViewById(R.id.btnYoutube);


        Anasayfa.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Anasayfa", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AnaEkran fragment = new AnaEkran();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        BenKimim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Ben Kimim?", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sayfa_Gosterim fragment = new Sayfa_Gosterim();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/ben-kimim/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });

        Projelerim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Projelerim", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sayfa_Gosterim fragment = new Sayfa_Gosterim();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/projelerim/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });

        Yeteneklerim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Yeteneklerim", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sayfa_Gosterim fragment = new Sayfa_Gosterim();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/yeteneklerim/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });

        Facebook.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Facebook Hesabım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.facebook.com/serkanozayd");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        Twitter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Twitter Hesabım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://twitter.com/serkanzaydin");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        WebUgra.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Web Site Adresi", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        Instagram.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Instagram Hesabım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.instagram.com/serkan.zaydn/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });

        Github.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Github Hesabım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://github.com/hsmnzaydn");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });

        Youtube.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Youtube Kanalım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.youtube.com/channel/UCLd62Y1NkDNKMkqKtAfDKug");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        Android_Sosyal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Android Uygulamalarım", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        Sosyal_Medya_Sayfa fragment = new Sosyal_Medya_Sayfa();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://play.google.com/store/apps/developer?id=Hüseyin%20Serkan%20Özaydin&hl=tr");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        Linux.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Linux", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AnaEkran fragment = new AnaEkran();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/linux/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        Android.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Android", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AnaEkran fragment = new AnaEkran();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/android/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        RaspberryPi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Raspberry Pi", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AnaEkran fragment = new AnaEkran();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/raspberry-pi/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });


        KisiselDeneyimlerim.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP: {
                        Toast.makeText(getContext(), "Kişisel Deneyimlerim", Toast.LENGTH_SHORT).show();
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction transaction = fragmentManager.beginTransaction();
                        AnaEkran fragment = new AnaEkran();
                        transaction.replace(R.id.container, fragment, "deneme");
                        transaction.addToBackStack(null);
                        transaction.commit();
                        Model model = new Model("https://www.serkanozaydin.net/kisisel-deneyimler/");
                        SharedPreferences mPrefs = getActivity().getPreferences(MODE_PRIVATE);
                        SharedPreferences.Editor prefsEditor = mPrefs.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(model);
                        prefsEditor.putString("MyObject", json);
                        prefsEditor.commit();


                        break;
                    }
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;

                    }
                }


                return true;
            }
        });
        Veritabani db=new Veritabani(getContext());
        db.Sil();


        return root;


    }




}
