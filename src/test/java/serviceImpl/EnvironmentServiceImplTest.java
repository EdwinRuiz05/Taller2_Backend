package serviceImpl;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.model.View;
import environment.repository.VideoRepository;
import environment.repository.ViewRepository;
import environment.repository.impl.VideoRepositoryImpl;
import environment.repository.impl.ViewsRepositoryImpl;
import environment.service.EnvironmentService;
import environment.service.impl.EnvironmentServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnvironmentServiceImplTest {
    EnvironmentService environmentservice;
    VideoRepository videorepository;
    ViewRepository viewsrepository;
    Video video;
    View views;
    
   @BeforeEach
   void setUp(){
       video = new Video("12345", "Title", "Description", 5.5);
       views = new View("Edwin Ruiz", LocalDateTime.now(), 19, video);
       videorepository = new VideoRepositoryImpl();
       viewsrepository = new ViewsRepositoryImpl();
       environmentservice = new EnvironmentServiceImpl(videorepository, viewsrepository);
   }
   
   @Test
    void findAllException() {
        assertThrows(VideoNotFoundException.class, () -> {
            environmentservice.findAllVideos();
        });
    }
    
    @Test
    void findAll() throws VideoNotFoundException{
        List<Video> expected = new ArrayList<>();
        expected.add(video);
        environmentservice.add(video);
        List<Video> videos = environmentservice.findAllVideos();
        assertEquals(expected, videos);
    }
}
