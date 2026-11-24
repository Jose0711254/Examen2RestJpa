package jose.luis.rey.ExamenApiRestRicoldinho.model.service;

import java.util.List;

import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaDetalleDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaListadoDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaRequestDTO;

public interface IPeliculaService {

    PeliculaDetalleDTO crear(PeliculaRequestDTO dto);

    List<PeliculaListadoDTO> listarTodas();

    PeliculaDetalleDTO obtenerPorId(Long id);

    PeliculaDetalleDTO actualizar(Long id, PeliculaRequestDTO dto);

    void eliminar(Long id);

}
