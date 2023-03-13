package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Data
public class AnswerDto implements Serializable {
    private Long userId;
    private Long questionId;
    private Integer id;
    private String title;
    private String answerText;

    public AnswerDto(Long userId, Long questionId, Integer id, String title, String answerText) {
        this.userId = userId;
        this.questionId = questionId;
        this.id = id;
        this.title = title;
        this.answerText = answerText;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerDto;
    }

}