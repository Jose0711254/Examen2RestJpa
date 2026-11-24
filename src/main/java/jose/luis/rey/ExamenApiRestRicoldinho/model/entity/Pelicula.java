package jose.luis.rey.ExamenApiRestRicoldinho.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Long id;

    @Column(length = 150, nullable = false, unique = true)
    private String titulo;

    @Column(length = 100, nullable = false)
    private String director;

    @Column(nullable = false)
    private int anio;

    @Column(nullable = false)
    private int minutos;

}
