package environment.controller;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.repository.impl.VideoRepositoryImpl;
import environment.repository.impl.ViewsRepositoryImpl;
import environment.service.impl.EnvironmentServiceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {
    
    private final EnvironmentServiceImpl environmentService;
    
    public EnvironmentController(EnvironmentServiceImpl environmentService) {
        this.environmentService = new EnvironmentServiceImpl(new VideoRepositoryImpl(), new ViewsRepositoryImpl());
    }
    
    @GetMapping(value = "/video")
    public ResponseEntity<List<Video>> findAllVideos() throws VideoNotFoundException {
        try {
            return ResponseEntity.status( HttpStatus.OK ).body( environmentService.findAllVideos() );
        }catch (VideoNotFoundException e) {
            return ResponseEntity.status ( HttpStatus.BAD_REQUEST)
                .header( "Error_name", e.getMessage() )
                .body(Collections.emptyList());
        }
    }
    
    @PostMapping( value = "/video")
    public ResponseEntity<Video> add(@RequestBody Video video) {
        return ResponseEntity.status( HttpStatus.OK ).body(environmentService.add(video));
    }
}
