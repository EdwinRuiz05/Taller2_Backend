package environment.repository.impl;

import environment.model.View;
import environment.repository.ViewRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewsRepositoryImpl implements ViewRepository {
    List<View> views = new ArrayList<>();

    @Override
    public View add(View view) {
        if(views.add(view)){
            return view;
        }
        return null;
    }
}