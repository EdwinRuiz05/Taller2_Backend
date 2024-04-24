package environment.repository;

import environment.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> findAll();
    Video add(Video video);
    Video save(Video save);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
    
}
