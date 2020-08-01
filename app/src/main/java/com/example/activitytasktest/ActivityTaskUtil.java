package com.example.activitytasktest;

import java.util.List;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

/**
 * author: xujiajia
 * created on: 2020/7/31 5:57 PM
 * description:
 */
public class ActivityTaskUtil {
  //constants
  private static final String TAG = "ActivityTaskUtil";

  public static void showTaskInfo(Context context) {
    Log.i(TAG, "showTaskInfo");
    if (context == null) {
      return;
    }
    ActivityManager activityManager =
        (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    if (activityManager == null) {
      return;
    }
    List<ActivityManager.AppTask> tasks = activityManager.getAppTasks();
    for (ActivityManager.AppTask task : tasks) {
      ActivityManager.RecentTaskInfo info = task.getTaskInfo();
      Log.i(TAG, info.toString());
    }
  }
}
