package com.litetech.tuby.utils;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;

import com.litetech.tuby.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import androidx.core.app.NotificationCompat;


public class Notifications {
    private Context mContext;
    public static final String NOTIFICATION = "notification";
    private static final String NOTIFICATION_CHANNEL_ID = "20005";
    private static final String GROUP_KEY = "202400";


    public static Notifications getInstance(Context context) {
        return new Notifications(context);
    }

    private Notifications(Context context) {
        mContext = context;
    }

    @SuppressLint("StaticFieldLeak")
    private void createNotification(final String title, final String message, String profileImg) {
        final int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        /*Creates an explicit intent for an Activity in your app**/
//        Intent resultIntent = new Intent(mContext, BaseHome.class);
        Intent resultIntent = null;
        resultIntent.putExtra(NOTIFICATION, true);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        final PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext,
                0 /* Request code */, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, NOTIFICATION_CHANNEL_ID);
        mBuilder.setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup(GROUP_KEY)
                .setColor(mContext.getResources().getColor(R.color.colorPrimaryDark))
                .setStyle(new NotificationCompat.BigTextStyle())
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setContentIntent(resultPendingIntent)
                .setGroupSummary(true);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        }

        NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Riviws Channel ID", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert mNotificationManager != null;
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            mBuilder.setGroup(GROUP_KEY);
            mBuilder.setGroupSummary(true);
//            mBuilder.setSmallIcon(R.drawable.ic_notifcation);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(mContext.getString(R.string.app_name), m /* Request Code */, mBuilder.build());
    }


    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

