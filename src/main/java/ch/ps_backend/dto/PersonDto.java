package ch.ps_backend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link ch.ps_backend.model.Person} entity
 */
@Data
public class PersonDto implements Serializable {
    private String middlenames;
    private String likes;
    private String dislikes;
    private Long roleId;
    private Long typeId;
    private Long userId;
    private Integer id;
    private String firstname;
    private String lastname;
    private Boolean fronting;
    private String pronouns;
    private LocalDate birthday;
    private Integer age;
    private RoleDto role;
    private PersonTypeDto type;

    public PersonDto(String middlenames, String likes, String dislikes, Long roleId, Long typeId, Long userId, Integer id, String firstname, String lastname, Boolean fronting, String pronouns, LocalDate birthday, Integer age, RoleDto role, PersonTypeDto type) {
        this.middlenames = middlenames;
        this.likes = likes;
        this.dislikes = dislikes;
        this.roleId = roleId;
        this.typeId = typeId;
        this.userId = userId;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fronting = fronting;
        this.pronouns = pronouns;
        this.birthday = birthday;
        this.age = age;
        this.role = role;
        this.type = type;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonDto;
    }

}