package jose.luis.rey.ExamenApiRestRicoldinho.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaDetalleDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaListadoDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaRequestDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.repository.IPeliculaRepository;

@Service
@Transactional
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private IPeliculaRepository peliculaRepository;

    @Override
    @Transactional
    public PeliculaDetalleDTO crear(PeliculaRequestDTO dto) {
        // TODO Auto-generated method stub */
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeliculaListadoDTO> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    @Transactional
    public PeliculaDetalleDTO obtenerPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    @Transactional
    public PeliculaDetalleDTO actualizar(Long id, PeliculaRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
