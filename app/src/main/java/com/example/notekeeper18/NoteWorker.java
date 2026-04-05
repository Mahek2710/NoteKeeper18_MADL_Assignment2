package com.example.notekeeper18;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NoteWorker extends Worker {

    public NoteWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {

        sendNotification();

        return Result.success();
    }

    private void sendNotification() {

        String channelId = "note_channel";

        NotificationManager manager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Notes Reminder",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getApplicationContext(), channelId)
                        .setContentTitle("Reminder")
                        .setContentText("Review your saved notes today")
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setAutoCancel(true);

        manager.notify(1, builder.build());
    }
}