package org.eu.trixtertempdrive.gxtrm.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.eu.trixtertempdrive.gxtrm.fragments.FilesLibraryFragment;
import org.eu.trixtertempdrive.gxtrm.fragments.MovieLibraryFragment;
import org.eu.trixtertempdrive.gxtrm.fragments.TvShowsLibraryFragment;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {


    public FragmentViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
                return new MovieLibraryFragment();
        }else if(position==1){
                return new TvShowsLibraryFragment();
        }else {
                return new FilesLibraryFragment();
        }
    }



    @Override
    public int getItemCount() {
        return 3;
    }


}
