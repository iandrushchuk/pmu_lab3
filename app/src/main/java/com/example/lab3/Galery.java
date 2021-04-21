package com.example.lab3;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Galery extends Fragment
{
    public static ImageView Im;
    public static ImageView Im2;
    public static ImageView Im3;
    public static ImageView Im4;
    public static ImageView Im5;
    public static ImageView Im6;
    public static ImageView Im7;
    public static ImageView Im8;
    public static ImageView Im9;
    public static ImageView Im10;
    public static int skok=6;
    public static int mojpls = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_galery, container, false);
        Button AddButton = (Button) view.findViewById(R.id.Add);

        Im = view.findViewById(R.id.I1);
        Im2 = view.findViewById(R.id.I2);
        Im3 = view.findViewById(R.id.I3);
        Im4 = view.findViewById(R.id.I4);
        Im5 = view.findViewById(R.id.I5);
        Im6 = view.findViewById(R.id.I6);
        Im7 = view.findViewById(R.id.I7);
        Im8 = view.findViewById(R.id.I8);
        Im9 = view.findViewById(R.id.I9);
        Im10 = view.findViewById(R.id.I10);

        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mojpls == 0)
                {
                    mojpls = 1;
                    Fragment fragment = null;
                    fragment = new AddPhoto();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    ft.add(R.id.fr_dad, fragment);
                    ft.commit();
                }
            }
        });

        return view;
    }

    public static void AddImagePLS(Uri image1)
    {
        switch (skok)
        {
            case 6:
                Im10.setImageURI(image1);
                skok += 1;
                break;
            case 7:
                Im9.setImageURI(image1);
                skok += 1;
                break;
            case 8:
                Im8.setImageURI(image1);
                skok += 1;
                break;
            case 9:
                Im7.setImageURI(image1);
                skok += 1;
                break;
            case 10:
                Im6.setImageURI(image1);
                skok += 1;
                break;
            case 11:
                Im5.setImageURI(image1);
                skok += 1;
                break;
            case 12:
                Im4.setImageURI(image1);
                skok += 1;
                break;
            case 13:
                Im3.setImageURI(image1);
                skok += 1;
                break;
            case 14:
                Im2.setImageURI(image1);
                skok += 1;
                break;
            case 15:
                Im.setImageURI(image1);
                skok += 1;
                break;
        }
    }

}
