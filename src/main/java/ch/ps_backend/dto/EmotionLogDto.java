package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link ch.ps_backend.model.EmotionLog} entity
 */
@Data
@NoArgsConstructor
public class EmotionLogDto implements Serializable {
    private TrackerDto tracker;
    private EmotionDto emotion;
    private Integer id;
    private OffsetDateTime datetime;

    public EmotionLogDto(TrackerDto tracker, EmotionDto emotion, Integer id, OffsetDateTime datetime) {
        this.tracker = tracker;
        this.emotion = emotion;
        this.id = id;
        this.datetime = datetime;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmotionLogDto;
    }

}