package ch.ps_backend.dto;

import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link ch.ps_backend.model.AmountLog} entity
 */
@Data
@NoArgsConstructor
public class AmountLogDto implements Serializable {
    private TrackerDto tracker;
    private Integer id;
    private Integer amount;
    private OffsetDateTime datetime;

    public AmountLogDto(TrackerDto tracker, Integer id, Integer amount, OffsetDateTime datetime) {
        this.tracker = tracker;
        this.id = id;
        this.amount = amount;
        this.datetime = datetime;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AmountLogDto;
    }

}