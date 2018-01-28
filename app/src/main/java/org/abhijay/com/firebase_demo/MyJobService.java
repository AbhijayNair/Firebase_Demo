package org.abhijay.com.firebase_demo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;





import static android.content.ContentValues.TAG;

/**
 * Created by ABHIJAY on 1/28/2018.
 */

public class MyJobService extends com.firebase.jobdispatcher.JobService {
    @Override
    public boolean onStartJob(com.firebase.jobdispatcher.JobParameters jobParameters) {
        Log.d(TAG, "Performing long running task in scheduled job");
        return false;
    }

    @Override
    public boolean onStopJob(com.firebase.jobdispatcher.JobParameters jobParameters) {
        return false;
    }
}
