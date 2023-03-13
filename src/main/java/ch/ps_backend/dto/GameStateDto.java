package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.GameState} entity
 */
@Data
public class GameStateDto implements Serializable {
    private Long userId;
    private Long gameId;
    private Integer id;
    private byte[] fileState;

    public GameStateDto(Long userId, Long gameId, Integer id, byte[] fileState) {
        this.userId = userId;
        this.gameId = gameId;
        this.id = id;
        this.fileState = fileState;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GameStateDto;
    }

}