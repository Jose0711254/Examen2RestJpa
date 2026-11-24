package jose.luis.rey.ExamenApiRestRicoldinho.model.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaDetalleDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaListadoDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.dto.PeliculaRequestDTO;
import jose.luis.rey.ExamenApiRestRicoldinho.model.service.IPeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired

    private IPeliculaService peliculaService;

    public PeliculaController(IPeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public ResponseEntity<PeliculaDetalleDTO> crear(@RequestBody PeliculaRequestDTO request) {
        PeliculaDetalleDTO creada = peliculaService.crear(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creada.id())
                .toUri();

        return ResponseEntity.created(location).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<PeliculaListadoDTO>> listar() {
        return ResponseEntity.ok(peliculaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDetalleDTO> obtenerDetalle(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDetalleDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PeliculaRequestDTO request) {
        return ResponseEntity.ok(peliculaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
