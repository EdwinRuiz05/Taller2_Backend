package serviceImpl;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.repository.VideoRepository;
import environment.repository.ViewRepository;
import environment.service.EnvironmentService;
import environment.service.impl.EnvironmentServiceImpl;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;


import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doReturn;

public class EnvironmentServiceImplTest {
    VideoRepository videoRepository = Mockito.mock();
    ViewRepository viewsRepository = Mockito.mock();
    EnvironmentService environmentService = new EnvironmentServiceImpl(videoRepository, viewsRepository);
    List<Video> videos = List.of(
            new Video("01", "video 1", "This is a new video", 3.5),
            new Video("02", "video 2", "This is a new video", 4.5),
            new Video("03", "short 3", "This is a new video", 3.4),
            new Video("04", "short 4", "This is a new video", 2.0),
            new Video("05", "video 5", "This is a new video", 5.1)
    );

    @Test
    void fidAllException() {
        assertThrows(VideoNotFoundException.class, () -> environmentService.findAllVideos());
    }

    @Test
    void findAll() throws VideoNotFoundException {
        doReturn(videos).when(videoRepository).findAll();
        var target = videos.containsAll(environmentService.findAllVideos());
        assertTrue(target);
    }

    @Test
    void findByTitleVideoException() {
        assertThrows(VideoNotFoundException.class, () -> environmentService.find("title"));
    }

    @Test
    void findByDurationVideoException() {
        assertThrows(VideoNotFoundException.class, () -> environmentService.find(0.0, 5.0));
    }

    @Test
    void findByTitleVideo() throws VideoNotFoundException {
        var parameter = "video";
        var expected = videos.stream().filter(p -> p.title().contains(parameter)).toList();
        doReturn(expected).when(videoRepository).find(parameter);
        var result = environmentService.find(parameter).containsAll(expected);
        assertTrue(result);
    }

    @Test
    void findByDurationVideo() throws VideoNotFoundException {
        var expected = videos.stream().filter(p -> p.duration() <= 5.0 && p.duration() >= 3.0).toList();
        doReturn(expected).when(videoRepository).find(3.0, 5.0);
        var target = environmentService.find(3.0, 5.0).containsAll(expected);
        assertTrue(target);
    }
}