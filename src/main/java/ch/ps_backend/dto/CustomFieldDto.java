package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link ch.ps_backend.model.CustomField} entity
 */
@Data
public class CustomFieldDto implements Serializable {
    private Integer id;
    private String declaration;
    private String inputType;

    public CustomFieldDto(Integer id, String declaration, String inputType) {
        this.id = id;
        this.declaration = declaration;
        this.inputType = inputType;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CustomFieldDto;
    }

}