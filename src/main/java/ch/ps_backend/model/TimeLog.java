package ch.ps_backend.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "time_log", schema = "ps_default")
public class TimeLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tracker_id", nullable = false)
    private Tracker tracker;

    @Column(name = "start", nullable = false)
    private OffsetTime start;

    @Column(name = "\"end\"")
    private OffsetTime end;

    @Column(name = "result", nullable = false)
    private LocalTime result;

    @Column(name = "date", nullable = false)
    private LocalDate date;

}