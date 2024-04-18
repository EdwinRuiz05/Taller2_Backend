package environment.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends Exception{
    
    public VideoNotFoundException(){
        super("Video not found");
    }
    
    public VideoNotFoundException(String title){
        super(MessageFormat.format("Video not found whith this title; {9}",title));
    }
}
