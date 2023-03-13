package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Todolist} entity
 */
@Data
public class TodolistDto implements Serializable {
    private Long userId;
    private Integer id;
    private String name;
    private String description;

    public TodolistDto(Long userId, Integer id, String name, String description) {
        this.userId = userId;
        this.id = id;
        this.name = name;
        this.description = description;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TodolistDto;
    }

}