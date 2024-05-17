package environment.repository;

import environment.model.Video;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video save);
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
    
}
