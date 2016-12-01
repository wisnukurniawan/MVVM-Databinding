package com.bloonerd.mvvm_databinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailViewModel {


    private final GoTCharacter gotCharacter;
    private final Context context;

    public DetailViewModel(GoTCharacter gotCharacter, Context context) {
        this.gotCharacter = gotCharacter;
        this.context = context;
    }


    public String getTitle() {
        return gotCharacter.getFullName() != null && gotCharacter.getFullName().startsWith("A") ?
                "Sir " + gotCharacter.getFullName() : gotCharacter.getFullName();
    }

    public String getHouseName() {
        return gotCharacter.house != null && gotCharacter.house.equals("Stark") ?
                "Chateau " + gotCharacter.house : gotCharacter.house;
    }

    public int getCharacterDetailsColor() {
        return gotCharacter.alive ? Color.GREEN : Color.RED;
    }

    public String getCharacterDetails() {
        return gotCharacter.description != null ? gotCharacter.description : "";
    }

    public Drawable getImageHouse() {
        return ContextCompat.getDrawable(context, gotCharacter.houseResId);
    }

    public String getImageCharacter() {
        return gotCharacter.fullUrl != null ? gotCharacter.fullUrl : "";
    }

    @BindingAdapter("app:imgUrl")
    public static void setImgUrl(ImageView view, String url) {
        Picasso.with(view.getContext())
                .load(Uri.parse(url))
                .placeholder(R.drawable.profile_placeholder_full)
                .error(R.drawable.profile_placeholder_error_full)
                .into(view);
    }
}
