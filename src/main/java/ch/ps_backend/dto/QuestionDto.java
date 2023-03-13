package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.Question} entity
 */
@Data
public class QuestionDto implements Serializable {
    private Long userId;
    private Integer id;
    private String title;
    private String questionText;

    public QuestionDto(Long userId, Integer id, String title, String questionText) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.questionText = questionText;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof QuestionDto;
    }

}