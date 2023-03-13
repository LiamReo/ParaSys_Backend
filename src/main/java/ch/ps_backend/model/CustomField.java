package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "custom_field", schema = "ps_default")
public class CustomField implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "declaration", nullable = false, length = 100)
    private String declaration;

    @Column(name = "input_type", nullable = false, length = 10)
    private String inputType;

    @ManyToMany(mappedBy = "customFields", fetch = FetchType.LAZY)
    List<Person> people;

}