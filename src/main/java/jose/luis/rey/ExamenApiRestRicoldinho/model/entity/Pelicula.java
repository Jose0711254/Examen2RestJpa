package jose.luis.rey.ExamenApiRestRicoldinho.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reparto> reparto;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, int anio, int minutos, List<Reparto> reparto) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.minutos = minutos;
        this.reparto = reparto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public List<Reparto> getReparto() {
        return reparto;
    }

    public void setReparto(List<Reparto> reparto) {
        this.reparto = reparto;
    }

    public void addReparto(Reparto reparto) {
        this.reparto.add(reparto);
        reparto.setPelicula(this);

    }

}
