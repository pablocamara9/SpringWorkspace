package com.example.monumentos.service;

import com.example.monumentos.error.MonumentoNotFoundException;
import com.example.monumentos.model.Monumento;
import com.example.monumentos.repo.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> getAll() {
        List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public List<Monumento> orderByName(String nombreCiudad, String sortDirection) {
        List<Monumento> result = monumentoRepository.orderByName(nombreCiudad, sortDirection);
        if (result.isEmpty())
            throw new MonumentoNotFoundException();
        return result;
    }

    public Monumento get(Long id) {
        return monumentoRepository.get(id)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumento add(Monumento monumento) {
        return monumentoRepository.add(monumento);
    }

    public Monumento edit(Long id, Monumento newValue) {
        return monumentoRepository.edit(id, newValue)
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public void delete(Long id) {
        monumentoRepository.delete(id);
    }


}
