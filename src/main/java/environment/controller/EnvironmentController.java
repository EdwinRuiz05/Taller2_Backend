package environment.controller;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.service.impl.EnvironmentServiceImpl;
import java.util.List;

public class EnvironmentController {
    
    private final EnvironmentServiceImpl environmentService;
    
    public EnvironmentController(EnvironmentServiceImpl environmentService) {
        this.environmentService = environmentService;
    }
    
    public List<Video> findllVideos() throws VideoNotFoundException {
        List<Video> videos = environmentService.findAllVideos();
        return videos;
    }
}
