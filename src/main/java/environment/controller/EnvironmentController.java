package environment.controller;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.service.impl.EnvironmentServiceImpl;
import java.util.List;

public class EnvironmentController {
    
    private final EnvironmentServiceImpl environmentService;
    
    public EnvironmentController(EnvironmentServiceImpl environmentServiceImpl) {
        this.environmentService = environmentServiceImpl;
    }
    
    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = environmentService.findAllVideos();
        return videos;
    }
}
