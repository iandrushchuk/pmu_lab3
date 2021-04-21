package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AddPhoto extends Fragment
{

    ImageView photo;
    Uri imageUri;

    public static int mojno=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_add_photo, container, false);

        photo = view.findViewById(R.id.PreView);
        Button AddImageButton = (Button) view.findViewById(R.id.Browse_Image);
        Button CloseButton = (Button) view.findViewById(R.id.Close);
        Button AddButton = (Button) view.findViewById(R.id.Add_Image);

        AddImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
                startActivityForResult(intent, 0);
            }

        });

        CloseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.fr_dad);
                fm.beginTransaction() .remove(fragment) .commit();
                Galery.mojpls = 0;
            }

        });

        AddButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (mojno == 1)
                {
                    Galery.AddImagePLS(imageUri);
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    Fragment fragment = fm.findFragmentById(R.id.fr_dad);
                    fm.beginTransaction().remove(fragment).commit();
                    mojno = 0;
                    Galery.mojpls = 0;
                }
            }

        });

        return view;
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode)
            {
                case 0:
                    imageUri = data.getData();
                    photo.setImageURI(imageUri);
                    mojno = 1;
                    break;
            }
    }

}
