package environment.service;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.model.View;

import java.util.List;

public interface EnvironmentService {
    List<Video> findAllVideos() throws VideoNotFoundException;
    Video add(Video video);
    View add(View view);
    List<Video> find(String title) throws VideoNotFoundException;
    List<Video> find(double fromDuration, double toDuration) throws VideoNotFoundException;


}
