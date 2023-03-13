package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link ch.ps_backend.model.SoberTracker} entity
 */
@Data
@NoArgsConstructor
public class SoberTrackerDto implements Serializable {
    private TrackerDto tracker;
    private Integer id;
    private Boolean soberLog;
    private OffsetDateTime datetime;

    public SoberTrackerDto(TrackerDto tracker, Integer id, Boolean soberLog, OffsetDateTime datetime) {
        this.tracker = tracker;
        this.id = id;
        this.soberLog = soberLog;
        this.datetime = datetime;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SoberTrackerDto;
    }

}