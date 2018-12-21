package com.litetech.tuby.utils;

import android.app.AlertDialog;
import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import com.litetech.tuby.R;


public class UICreator {
    private AppCompatActivity activity;
    private int FRAG = R.id.container;

    private UICreator(AppCompatActivity activity) {
        this.activity = activity;
    }

    public static UICreator getInstance(AppCompatActivity activity) {
        return new UICreator(activity);
    }



    public void createFragment(Fragment fragment, String tag) {
        FragmentManager fm = activity.getSupportFragmentManager();
        fm.beginTransaction().replace(FRAG, fragment, tag).commit();

    }

    public void Share(String message) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        activity.startActivity(Intent.createChooser(sendIntent, "Share to"));
    }


    public void setFRAG(int FRAG) {
        this.FRAG = FRAG;
    }



    public  void createDialog(DialogFragment fragment, String tag){
        fragment.setStyle(DialogFragment.STYLE_NORMAL,R.style.NoActionBar);
        fragment.show(activity.getSupportFragmentManager(),tag);
    }


    public  void createMinDialog(DialogFragment fragment,String tag){
        fragment.show(activity.getSupportFragmentManager(),tag);
    }

    public void ShowAlert(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("Dismiss",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
