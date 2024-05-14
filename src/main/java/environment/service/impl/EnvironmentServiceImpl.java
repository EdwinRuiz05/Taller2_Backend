package environment.service.impl;

import environment.exception.VideoNotFoundException;
import environment.model.Video;
import environment.model.View;
import environment.repository.VideoRepository;
import environment.repository.ViewRepository;

import java.util.ArrayList;
import java.util.List;
import environment.service.EnvironmentService;

public class EnvironmentServiceImpl implements EnvironmentService{
    //Atributos
    private final VideoRepository videorepository;
    private final ViewRepository viwesrepository;
    
    //Metodos
    public EnvironmentServiceImpl(VideoRepository videorepository, ViewRepository viwesrepository){
      this.videorepository = videorepository;
      this.viwesrepository = viwesrepository;
    }

    @Override
    public List<Video> findAllVideos() throws VideoNotFoundException{
        List<Video> videos = videorepository.findAll();
        if(videorepository.findAll().isEmpty()){
            throw new VideoNotFoundException();
        }
        return  videos;
    }

    @Override
    public Video add(Video video) {
        return videorepository.add(video);
    }

    @Override
    public View add(View view) {
        return viwesrepository.add(view);
    }

    @Override
    public List<Video> find(String title) throws VideoNotFoundException {
        if(videorepository.find(title).isEmpty()){
            throw new VideoNotFoundException();
        }
        return videorepository.find(title);
    }

    @Override
    public List<Video> find(Double fromDuration, Double toDuration) throws VideoNotFoundException{
        if(videorepository.find(fromDuration, toDuration).isEmpty()){
            throw new VideoNotFoundException();
        }
        return videorepository.find(fromDuration, toDuration);
    }
}
