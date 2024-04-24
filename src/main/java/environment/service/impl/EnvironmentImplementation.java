package environment.service.impl;

import environment.model.Video;
import environment.model.View;
import environment.service.EnviromentService;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentImplementation implements EnviromentService{
    
    private List<Video> videos = new ArrayList<>();
    private List<View> views = new ArrayList<>();

    @Override
    public List<Video> findAllVideos() {
        return videos;
    }

    @Override
    public Video add(Video video) {
        return video;
    }

    @Override
    public View add(View view) {
        return view;
    }
}
