package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;

/**
 * A DTO for the {@link ch.ps_backend.model.TimeLog} entity
 */
@Data
@NoArgsConstructor
public class TimeLogDto implements Serializable {
    private TrackerDto tracker;
    private Integer id;
    private OffsetTime start;
    private OffsetTime end;
    private LocalTime result;
    private LocalDate date;

    public TimeLogDto(TrackerDto tracker, Integer id, OffsetTime start, OffsetTime end, LocalTime result, LocalDate date) {
        this.tracker = tracker;
        this.id = id;
        this.start = start;
        this.end = end;
        this.result = result;
        this.date = date;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TimeLogDto;
    }

}