package environment.model;

import java.time.LocalDateTime;

public record View(String userFullName, LocalDateTime starPlayingTime, Integer age, Video video) {
}
