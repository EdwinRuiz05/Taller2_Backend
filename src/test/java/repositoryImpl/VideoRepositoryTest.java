package repositoryImpl;

import environment.model.Video;
import environment.repository.VideoRepository;
import environment.repository.impl.VideoRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VideoRepositoryTest {
    private VideoRepository videoRepository;
    
    @BeforeEach
    void setUp(){
        videoRepository = new VideoRepositoryImpl();
    }
    
    @Test
    void getAllVideos(){
        List<Video> videos = videoRepository.findAll();
        List<Video> expectedVideos = new ArrayList<>();
        assertEquals(expectedVideos, videos);
    }
    
    @Test
    void add(){
        Video video = new Video("444", "Title", "description", 5.2);
        Video result = videoRepository.add(video);
        assertEquals(video, result);
    }
    
    @Test
    void searchByTitle() {
        List<Video> videos = videoRepository.find("title");
        List<Video> expectedVideos = new ArrayList<>();  
        assertEquals(expectedVideos, videos);
    }
    
    @Test
    void searchByDuration() {
        List<Video> videos = videoRepository.find(1.0, 3.5);
        List<Video> expectedVideos = new ArrayList<>(); 
        assertEquals(expectedVideos, videos);
    }
}
