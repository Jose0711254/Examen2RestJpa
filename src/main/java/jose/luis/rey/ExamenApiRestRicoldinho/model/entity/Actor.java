package jose.luis.rey.ExamenApiRestRicoldinho.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private Long id;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 60, nullable = false)
    private String nacionalidad;

    @OneToMany(mappedBy = "actor")
    private List<Reparto> reparto;

    public Actor() {
    }

    public Actor(String nombre, String nacionalidad, List<Reparto> reparto) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.reparto = reparto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Reparto> getReparto() {
        return reparto;
    }

    public void setReparto(List<Reparto> reparto) {
        this.reparto = reparto;
    }

}
