package com.example.saumyamehta.myapplication;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

/**
 * Created by saumyamehta on 6/4/17.
 */

public class IntroManagerFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.intromanager,null);
        VideoView videoView = (VideoView)rootView.findViewById(R.id.animation_view);
        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.anim);
        videoView.setVideoURI(uri);
        videoView.start();
        return rootView;
    }
}
