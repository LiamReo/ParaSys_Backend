package ch.ps_backend.dto;

import ch.ps_backend.model.Todo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * A DTO for the {@link Todo} entity
 */
@Data
public class TodoDto implements Serializable {
    private Long listId;
    private Integer id;
    private String title;
    private String description;
    private Boolean reminder;
    private OffsetDateTime remindertime;
    private Boolean done;

    public TodoDto(Long listId, Integer id, String title, String description, Boolean reminder, OffsetDateTime remindertime, Boolean done) {
        this.listId = listId;
        this.id = id;
        this.title = title;
        this.description = description;
        this.reminder = reminder;
        this.remindertime = remindertime;
        this.done = done;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TodoDto;
    }

}