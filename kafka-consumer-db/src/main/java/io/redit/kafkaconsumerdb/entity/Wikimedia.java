package io.redit.kafkaconsumerdb.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "wikimedia_db")
public class Wikimedia {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob // @Lob enables the storing of large data
    private String wikimediaData;

    public Wikimedia(String wikimediaData) {
        this.wikimediaData = wikimediaData;
    }

    public Wikimedia() {}
}
