package environment.repository;

import org.springframework.stereotype.Repository;

import environment.model.View;

public interface ViewRepository {
    View add(View view);
}
