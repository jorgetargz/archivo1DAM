package domain.modelo;


import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class Coche {

    private final String modelo;
    private final Integer anio;
    private final LocalDate fechaAdquisicion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Objects.equals(modelo, coche.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo);
    }
}
