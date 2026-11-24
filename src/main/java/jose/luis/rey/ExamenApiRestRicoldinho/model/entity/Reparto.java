package jose.luis.rey.ExamenApiRestRicoldinho.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reparto")
public class Reparto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reparto")
    private Long id;

    @Column(length = 100, nullable = false)
    private String personaje;

    @Column(nullable = false)
    private Double salario;

    @Column(name = "pelicula_id", nullable = false)
    private Long peliculaId;

    @Column(name = "actor_id", nullable = false)
    private Long actorId;

}
