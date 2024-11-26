package com.repuestos.app.service;

import com.repuestos.app.model.Categoria;
import com.repuestos.app.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Obtener todas las categorías
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Guardar una nueva categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría existente
    public Categoria update(Categoria categoria) {
        if (categoriaRepository.existsById(categoria.getId())) {
            return categoriaRepository.save(categoria);
        } else {
            throw new IllegalArgumentException("La categoría con ID " + categoria.getId() + " no existe.");
        }
    }

    // Eliminar una categoría por su ID
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
