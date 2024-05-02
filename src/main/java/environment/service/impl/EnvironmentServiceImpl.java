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
    private final VideoRepository videorepositori;
    private final ViewRepository viwesrepository;
    
    //Metodos
    public EnvironmentServiceImpl(VideoRepository videorepositori, ViewRepository viwesrepository){
      this.videorepositori = videorepositori;
      this.viwesrepository = viwesrepository;
    }

    @Override
    public List<Video> findAllVideos() throws VideoNotFoundException{
        List<Video> videos = videorepositori.findAll();
        if(videorepositori.findAll().isEmpty()){
            throw new VideoNotFoundException();
        }
        return  videos;
    }

    @Override
    public Video add(Video video) {
        return videorepositori.add(video);
    }

    @Override
    public View add(View view) {
        return viwesrepository.add(view);
    }
}
