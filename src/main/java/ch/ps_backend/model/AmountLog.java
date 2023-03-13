package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "amount_log", schema = "ps_default")
public class AmountLog {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tracker_id", nullable = false)
    private Tracker tracker;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "datetime", nullable = false)
    private OffsetDateTime datetime;

}