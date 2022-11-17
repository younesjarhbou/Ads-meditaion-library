package com.adslibrary.jarhbou;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class function {



    public static void openlink(Context context, String link) {


        context.startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse(link)).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public  static void loadpicture(Context context, ImageView imageView, String link){

        //  Picasso.get().load(link).placeholder(R.drawable.loading1).into(imageView);
        Glide.with(context).load(link).placeholder(R.drawable.loading1).into(imageView);
    }

}
