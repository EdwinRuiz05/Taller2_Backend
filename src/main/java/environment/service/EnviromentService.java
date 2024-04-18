package environment.service;

import environment.model.Video;
import environment.model.View;

import java.util.List;

public interface EnviromentService {
    List<Video> findAllVideos();
    Video add(Video video);
    View add(View view);
}
