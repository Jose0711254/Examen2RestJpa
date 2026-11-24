package jose.luis.rey.ExamenApiRestRicoldinho.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaDetalleDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaListadoDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaRequestDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.entity.Pelicula;
import jose.luis.rey.ExamenApiRestRicoldinho.model.repository.IPeliculaRepository;

@Service
@Transactional
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Override
    @Transactional
    public PeliculaDetalleDTO crear(PeliculaRequestDTO dto) {
        validarDatos(dto);

        if (peliculaRepository.existsByTituloIgnoreCase(dto.titulo())) {
            throw new IllegalStateException("Ya existe una película con este");
        }

        Pelicula pelicula = new Pelicula();
        mapearDtoAEntidad1(dto, pelicula);
        Pelicula guardada = peliculaRepository.save(pelicula);

        return convertirADetalleDTO(guardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaListadoDTO> listarTodas() {
        return null;

    }

    @Override
    @Transactional
    public PeliculaDetalleDTO obtenerPorId(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Película no encontrada"));
        return convertirADetalleDTO(pelicula);
    }

    @Override
    @Transactional
    public PeliculaDetalleDTO actualizar(Long id, PeliculaRequestDTO dto) {
        validarDatos(dto);

        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Película no encontrada"));

        if (peliculaRepository.findByAnioGreaterThanOrderByAnioAsc(dto.anio()) != null) {
            throw new IllegalStateException("El nuevo título ya lo tiene otra película");
        }

        mapearDtoAEntidad1(dto, pelicula);
        Pelicula actualizada = peliculaRepository.save(pelicula);

        return convertirADetalleDTO(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!peliculaRepository.existsById(id)) {

            throw new EntityNotFoundException("Película no encontrada");
        }
        peliculaRepository.deleteById(id);
    }

    private void mapearDtoAEntidad1(PeliculaRequestDTO dto, Pelicula entidad) {
        entidad.setTitulo(dto.titulo());
        entidad.setDirector(dto.director());
        entidad.setAnio(dto.anio());
        entidad.setDuracion(dto.duracion());
    }

    private void mapearDtoAEntidad(PeliculaRequestDTO dto, Pelicula pelicula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapearDtoAEntidad'");
    }

    private void validarDatos(PeliculaRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarDatos'");
    }

    private PeliculaDetalleDTO convertirADetalleDTO(Pelicula pelicula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertirADetalleDTO'");
    }

}
