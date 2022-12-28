package org.eu.trixtertempdrive.gxtrm.utils;


import static org.eu.trixtertempdrive.gxtrm.utils.IndexUtils.refreshIndex;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.eu.trixtertempdrive.gxtrm.database.DatabaseClient;
import org.eu.trixtertempdrive.gxtrm.model.IndexLink;

import java.util.List;

public class RefreshWorker extends Worker {
    Context ctxt ;
    public RefreshWorker(
            @NonNull Context mContext,
            @NonNull WorkerParameters params)
    {
        super(mContext, params);
        ctxt = mContext;
    }

    @Override
    public Result doWork() {

        // Do the work here--in this case, upload the images.

        if(isNetworkAvailable()){
            List<IndexLink> indexLinkList = DatabaseClient.getInstance(ctxt).getAppDatabase().indexLinksDao().getAllEnabled();
            for (IndexLink indexLink:indexLinkList) {
                refreshIndex(ctxt, indexLink);
            }
            return Result.success();
        }
      return Result.failure();
        // Indicate whether the work finished successfully with the Result
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
