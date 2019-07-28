/*
package com.example.administrator.stepdemo;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.administrator.utils.TimeAndShareUtils;

@SuppressLint("NewApi")
public class NFReceiver extends BroadcastReceiver {
    private NotificationManager nm;
    public static String dataString = "xiaolajiao";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String string = intent.getDataString();
        String[] split = string.split(":");
        if (action == AlarmService.SUCCESS_NOTIFI) {
            sendNotification(context, split[1], false);
        } else if (action == AlarmService.FAIL_NOTIFI) {
            sendNotification(context, split[1], true);
        }
    }

    protected void sendNotification(Context context, String steps,
                                    Boolean isFail) {
        if (nm == null) {
            nm = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
        }

        Intent intent1 = new Intent(context, PedometerActivity.class);
        @SuppressLint("WrongConstant") PendingIntent pendingIntent = PendingIntent.getActivity(context, 1,
                intent1, Intent.FLAG_ACTIVITY_NEW_TASK);

        android.support.v4.app.NotificationCompat.Builder nf = new NotificationCompat.Builder(
                context);
        RemoteViews rv = new RemoteViews(context.getPackageName(),
                R.layout.nf_view);
        rv.setImageViewBitmap(R.id.steps, BitmapFactory.decodeResource(
                context.getResources(), R.mipmap.icon_step));
        if (isFail) {
            String[] split = steps.split("-");
            // title.setContentTitle("您今天走了" + split[0] + "步").setContentText(
            // "还有" + split[1] + "步就可以完成今日任务，快去完成目标吧");
            rv.setTextViewText(R.id.xiaolajiao_steps_title, "您今天走了" + split[0]
                    + "步");
            rv.setTextViewText(R.id.xiaolajiao_steps_msg, "还有" + split[1]
                    + "步就可以完成今日任务，快去完成目标吧");
        } else {
            // title.setContentTitle("您今天走了" + steps + "步");
            // title.setContentText("完成今日目标。          点击查看");
            rv.setTextViewText(R.id.xiaolajiao_steps_title, "您今天走了" + steps
                    + "步");
            rv.setTextViewText(R.id.xiaolajiao_steps_msg,
                    "完成今日目标。          点击查看");
        }

        rv.setTextViewText(R.id.xiaolajiao_steps_time,
                TimeAndShareUtils.getCreateMinute());
        // if (isFail) {
        // String[] split = steps.split("-");
        // title.setContentTitle("您今天走了" + split[0] + "步").setContentText(
        // "还有" + split[1] + "步就可以完成今日任务，快去完成目标吧");
        // } else {
        // title.setContentTitle("您今天走了" + steps + "步");
        // title.setContentText("完成今日目标。          点击查看");
        // }

        Notification noti = nf
                .setSmallIcon(R.mipmap.icon_step)
                .setContentIntent(pendingIntent)
                // .setLargeIcon(
                // BitmapFactory.decodeResource(context.getResources(),
                // R.drawable.icon_step))
                // .setColor(Color.parseColor("#00000000"))
                .setContent(rv).setDefaults(Notification.DEFAULT_ALL).build();
        noti.flags = NotificationCompat.FLAG_AUTO_CANCEL;
        nm.notify(1, noti);
        Log.e("NFReceiver", "SEND_NOTIFICATION");
    }

}
*/
