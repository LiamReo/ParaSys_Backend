package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetTime;

/**
 * A DTO for the {@link ch.ps_backend.model.Routine} entity
 */
@Data
public class RoutineDto implements Serializable {
    private Long typeId;
    private Long userId;
    private Long partId;
    private Integer id;
    private Boolean reminder;
    private OffsetTime reminderTime;

    public RoutineDto(Long typeId, Long userId, Long partId, Integer id, Boolean reminder, OffsetTime reminderTime) {
        this.typeId = typeId;
        this.userId = userId;
        this.partId = partId;
        this.id = id;
        this.reminder = reminder;
        this.reminderTime = reminderTime;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoutineDto;
    }

}