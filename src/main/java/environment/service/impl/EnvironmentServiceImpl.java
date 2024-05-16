package environment.service.impl;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.model.View;
import environment.repository.VideoRepository;
import environment.repository.ViewRepository;
import environment.service.EnvironmentService;

import java.util.List;

public class EnvironmentServiceImpl implements EnvironmentService {
    //Atributos
    private final VideoRepository videorepository;
    private final ViewRepository viwesrepository;

    //Metodos
    public EnvironmentServiceImpl(VideoRepository videorepository, ViewRepository viwesrepository) {
        this.videorepository = videorepository;
        this.viwesrepository = viwesrepository;
    }

    @Override
    public List<Video> findAllVideos() throws VideoNotFoundException {
        List<Video> videos = videorepository.findAll();
        if(videos.isEmpty()){
            throw new VideoNotFoundException();
        }
        else{
            return videos;
        }
    }

    @Override
    public Video add(Video video) {
        Video videoAdd = videorepository.save(video);
        return videoAdd;
    }

    @Override
    public View add(View view) {
        View viewAdd = viwesrepository.add(view);
        return viewAdd;
    }

    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        List<Video> videos = videorepository.find(title);
        if(videos.isEmpty()){
            throw new VideoNotFoundException();
        }
        else{
            return videos;
        }
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> videos = videorepository.find(fromDuration, toDuration);
        if(videos.isEmpty()){
            throw new VideoNotFoundException();
        }
        else{
            return videos;
        }
    }
}

