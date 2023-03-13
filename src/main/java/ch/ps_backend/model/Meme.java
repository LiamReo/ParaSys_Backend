package ch.ps_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meme", schema = "ps_default")
public class Meme implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "meme_file", nullable = false)
    private byte[] memeFile;

    @ManyToMany(mappedBy = "memes", fetch = FetchType.LAZY)
    List<User> users;

}