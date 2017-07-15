package com.example.dell.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * Created by dell on 6/24/2017.
 */

public class Fragment extends android.support.v4.app.Fragment {
    public static ArrayList<Data> myList;

    public static Fragment newInstance(int count, ArrayList<Data> list) {
        myList = list;
        Bundle args = new Bundle();
        args.putInt("count", count);
        Fragment fragment = new Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    private static final String TAG = "APP";
    private final int REQ_CODE = 7190;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = null;
        if (getArguments().getInt("count") == 0)
        {
            v=inflater.inflate(R.layout.activity_fragment0, container, false);
            Button button=(Button)v.findViewById(R.id.buttoncamera);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQ_CODE);
                }
            });
            Log.d(TAG,"Count"+getArguments().getInt("count"));
            return v;
        }
        if (getArguments().getInt("count") == 1) {
            v = inflater.inflate(R.layout.android_fragment1, container, false);
            ListView list = (ListView) v.findViewById(R.id.list_view1);
            list.setAdapter(new FragmentAdapter1(myList, getContext()));
            Log.d(TAG,"Count"+getArguments().getInt("count"));
        }
        if (getArguments().getInt("count") == 2) {
            v = inflater.inflate(R.layout.android_fragment2, container, false);
            ListView list2 = (ListView) v.findViewById(R.id.list_view2);
            list2.setAdapter(new FragmentAdapter2(myList, getContext()));
            Log.d(TAG,"Count"+getArguments().getInt("count"));

        }
        if (getArguments().getInt("count") == 3) {
            v = inflater.inflate(R.layout.android_fragment3, container, false);
            ListView list3 = (ListView) v.findViewById(R.id.list_view3);
            list3.setAdapter(new FragmentAdapter3(myList, getContext()));
            Log.d(TAG,"Count"+getArguments().getInt("count"));

        }

        if (getArguments().getInt("count") == 4) {
            v = inflater.inflate(R.layout.activity_fragment4, container, false);
            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            if(imageBitmap!=null) {
                imageView.setImageBitmap(imageBitmap);
                Log.d(TAG,"Image Set!");
            }
            Log.d(TAG,"Count"+getArguments().getInt("count"));
        }
        return v;
    }

    private static Bitmap imageBitmap = null;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== REQ_CODE && resultCode == RESULT_OK ){
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            if(imageBitmap!=null)
                Log.d(TAG,"Image Saved!");
        }
    }
}
