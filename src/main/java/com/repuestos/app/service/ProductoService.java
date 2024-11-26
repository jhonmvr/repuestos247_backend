package com.repuestos.app.service;

import com.repuestos.app.model.Producto;
import com.repuestos.app.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    // Guardar un nuevo producto
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto update(Producto producto) {
        if (productoRepository.existsById(producto.getId())) {
            return productoRepository.save(producto);
        } else {
            throw new IllegalArgumentException("El producto con ID " + producto.getId() + " no existe.");
        }
    }

    // Eliminar un producto por su ID
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}
