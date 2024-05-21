package environment.repository.impl;

import environment.model.View;
import environment.repository.ViewRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

//@Repository
public class ViewsRepositoryImpl implements ViewRepository {
    private final List<View> views;

    public ViewsRepositoryImpl(){
        this.views = new ArrayList<>();
    }

    @Override
    public View add(View view) {
        this.views.add(view);
        return view;
    }
}