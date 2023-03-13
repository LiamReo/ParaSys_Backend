package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo", schema = "ps_default")
public class Todo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "reminder", nullable = false)
    private Boolean reminder = false;

    @Column(name = "remindertime")
    private OffsetDateTime remindertime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "list_id", nullable = false)
    private Todolist list;

    @Column(name = "done", nullable = false)
    private Boolean done = false;

}