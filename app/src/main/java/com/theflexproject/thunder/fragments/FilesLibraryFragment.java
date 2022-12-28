package org.eu.trixtertempdrive.gxtrm.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.eu.trixtertempdrive.gxtrm.R;
import org.eu.trixtertempdrive.gxtrm.adapter.FileItemAdapter;
import org.eu.trixtertempdrive.gxtrm.adapter.ScaleCenterItemLayoutManager;
import org.eu.trixtertempdrive.gxtrm.database.DatabaseClient;
import org.eu.trixtertempdrive.gxtrm.model.Movie;
import org.eu.trixtertempdrive.gxtrm.model.MyMedia;

import java.util.List;


public class FilesLibraryFragment extends BaseFragment {

    RecyclerView recyclerViewFiles;
    FileItemAdapter fileItemAdapter;
    List<MyMedia> files;
    List<Movie> movieList;

    public FilesLibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_files_library , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view , savedInstanceState);
        showFileLibrary();
    }

    private void showFileLibrary() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(" " , "in thread");
                movieList = DatabaseClient
                        .getInstance(mActivity)
                        .getAppDatabase()
                        .movieDao()
                        .getFilesWithNoTitle();
                showRecyclerFiles(movieList);
            }
        });
        thread.start();



    }

    private void showRecyclerFiles(List<Movie> movieList) {
        mActivity.runOnUiThread(() -> {
            recyclerViewFiles = mActivity.findViewById(R.id.recyclerAvailableFiles);
            if(recyclerViewFiles!=null){
                ScaleCenterItemLayoutManager linearLayoutManager = new ScaleCenterItemLayoutManager(mActivity, LinearLayoutManager.VERTICAL , false);
                recyclerViewFiles.setLayoutManager(linearLayoutManager);
                recyclerViewFiles.setHasFixedSize(true);
                fileItemAdapter = new FileItemAdapter(mActivity ,(List<MyMedia>)(List<?>) movieList);
                recyclerViewFiles.setAdapter(fileItemAdapter);
                fileItemAdapter.notifyDataSetChanged();
            }
        });
    }
}