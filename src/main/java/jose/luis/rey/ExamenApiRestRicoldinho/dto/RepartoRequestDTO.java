package jose.luis.rey.ExamenApiRestRicoldinho.dto;

import jakarta.validation.constraints.NotBlank;

public record RepartoRequestDTO(
        @NotBlank(message = "La id es obligatoria") Long actorId, String personaje, double salario) {

}
