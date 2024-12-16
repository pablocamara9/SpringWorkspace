package com.example.monumentos;

import com.example.monumentos.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();

    @PostConstruct
    public void init() {
        add(Monumento.builder()
                .id(1L)
                .codPais("ES")
                .nombre("Giralda")
                .ciudad("Sevilla")
                .longitud(37.3862)
                .latitud(-5.9926)
                .descripcion("Mu bonita")
                .urlImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/La_Giralda_August_2012_Seville_Spain.jpg/240px-La_Giralda_August_2012_Seville_Spain.jpg")
                .build());

        add(Monumento.builder()
                .id(2L)
                .codPais("IT")
                .nombre("Torre de Pisa")
                .ciudad("Pisa")
                .longitud(43.7229)
                .latitud(10.3965)
                .descripcion("Esta torcida")
                .urlImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/The_Leaning_Tower_of_Pisa_SB.jpeg/250px-The_Leaning_Tower_of_Pisa_SB.jpeg")
                .build());

        add(Monumento.builder()
                .id(3L)
                .codPais("IN")
                .nombre("Taj Mahal")
                .ciudad("Agra")
                .longitud(27.1752)
                .latitud(78.0421)
                .descripcion("Es un palacio")
                .urlImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Taj_Mahal_%28Edited%29.jpeg/280px-Taj_Mahal_%28Edited%29.jpeg")
                .build());

        add(Monumento.builder()
                .id(4L)
                .codPais("ES")
                .nombre("Plaza Vázquez de Molina")
                .ciudad("Úbeda")
                .longitud(38.0077)
                .latitud(-3.3678)
                .descripcion("En mi querida Úbeda")
                .urlImagen("https://upload.wikimedia.org/wikipedia/commons/6/6f/Iglesia_del_salvador_ubeda_001.jpg")
                .build());
    }

    public Monumento add(Monumento m) {
        monumentos.put(m.getId(), m);
        return m;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento monumentoNuevo) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCodPais(monumentoNuevo.getCodPais());
            v.setNombre(monumentoNuevo.getNombre());
            v.setCiudad(monumentoNuevo.getCiudad());
            v.setLongitud(monumentoNuevo.getLongitud());
            v.setLatitud(monumentoNuevo.getLatitud());
            v.setDescripcion(monumentoNuevo.getDescripcion());
            v.setUrlImagen(monumentoNuevo.getUrlImagen());
            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> orderByName(String nombreCiudad, String sortDirection) {
        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if (nombreCiudad.equalsIgnoreCase("all")) {
            result = data;
        } else {
            result = data.stream().filter(m -> m.getCiudad()
                    .equalsIgnoreCase(nombreCiudad)).collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc")) {
            result.sort(Comparator.comparing(Monumento::getCiudad));
        } else if (sortDirection.equalsIgnoreCase("desc")) {
            result.sort(Comparator.comparing(Monumento::getCiudad).reversed());

        }

        return Collections.unmodifiableList(result);
    }



}
