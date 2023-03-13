package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person", schema = "ps_default")
public class Person implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstname;
    @Column(name = "middlenames")
    private String middlenames;

    @Column(name = "lastname", length = 100)
    private String lastname;

    @Column(name = "fronting", nullable = false)
    private Boolean fronting = false;

    @Column(name = "pronouns", length = 20)
    private String pronouns;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "age")
    private Integer age;
    @Column(name = "likes")
    private String likes;
    @Column(name = "dislikes")
    private String dislikes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private PersonType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_has_character_traits",
            joinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "character_trait_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    List<CharacterTraits> characterTraits;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_has_custom_field",
            joinColumns = {
                    @JoinColumn(name = "person_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "custom_field_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    List<CustomField> customFields;

    /*
    TODO [JPA Buddy] create field to map the 'middlenames' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    private Object middlenames;
*/
/*
    TODO [JPA Buddy] create field to map the 'likes' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    private Object likes;
*/
/*
    TODO [JPA Buddy] create field to map the 'dislikes' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    private Object dislikes;
*/
}