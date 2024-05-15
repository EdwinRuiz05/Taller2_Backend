package environment.controller;

import environment.exception.VideoNotFoundException; 
import environment.model.Video;
import environment.service.impl.EnvironmentServiceImpl;
import java.util.List;

public class EnvironmentController {
    
    private final EnvironmentService environmentService;
    
    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentServiceImpl;
    }
    
    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = EnviromentService.findAllVideos;
        return videos;
    }
}
