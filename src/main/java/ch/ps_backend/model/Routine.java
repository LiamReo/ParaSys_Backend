package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routine", schema = "ps_default")
public class Routine implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)@JoinColumn(name = "type_id", nullable = false)
    private RoutineType type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)@JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)@JoinColumn(name = "part_id", nullable = false)
    private RoutinePart part;

    @Column(name = "reminder")
    private Boolean reminder;

    @Column(name = "reminder_time")
    private OffsetTime reminderTime;

}