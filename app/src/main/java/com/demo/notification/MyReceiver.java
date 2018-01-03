package com.demo.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Rachit Solanki on 3/1/18.
 */

public class MyReceiver extends BroadcastReceiver {


    String mTitle = "Notification Demo!";
    String mChannelId= "my_channel_02";

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Received !",Toast.LENGTH_LONG).show();
        if(intent.getAction().equals(Filters.ACTION_FILTER_DEMO)) {
            String description = intent.getStringExtra(Filters.KEY_DEMO);
            notification(context,mChannelId,mTitle,description );
        }

    }
    int notificationID = 1;

    private void notification(Context context,String channel_id,String title,String data) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // The id of the channel.
        // The user-visible name of the channel.
        CharSequence name = "Demo channel";
        // The user-visible description of the channel.
        String description = "Some description about channel";
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel mChannel = new NotificationChannel(channel_id, name, importance);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.RED);
        mChannel.setShowBadge(false);
        mChannel.setDescription(description);
        mNotificationManager.createNotificationChannel(mChannel);

        // create new Notification
        Notification notification = new NotificationCompat.Builder(context,channel_id)
                .setColor(Color.parseColor("#88FF8800"))
                .setContentTitle(title)
                .setContentText(data)
                // for tv support
                .setCategory(Notification.CATEGORY_RECOMMENDATION)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.account))
                .setSmallIcon(R.drawable.account)
                .setAutoCancel(true)
                .build();
        mNotificationManager.notify(notificationID++,notification);

    }


}
