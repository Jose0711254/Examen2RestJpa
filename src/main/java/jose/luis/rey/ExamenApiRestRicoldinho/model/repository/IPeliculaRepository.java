package jose.luis.rey.ExamenApiRestRicoldinho.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jose.luis.rey.ExamenApiRestRicoldinho.model.entity.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Long> {
    boolean existsByTituloIgnoreCase(String titulo);

    List<Pelicula> findByAnioGreaterThanOrderByAnioAsc(Integer anio);
}
