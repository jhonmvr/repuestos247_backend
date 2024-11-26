package com.repuestos.app.service;

import com.repuestos.app.model.AñosProducto;
import com.repuestos.app.repository.AñosProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AñosProductoService {

    private final AñosProductoRepository añosProductoRepository;

    public AñosProductoService(AñosProductoRepository añosProductoRepository) {
        this.añosProductoRepository = añosProductoRepository;
    }

    // Obtener todos los años por producto
    public List<AñosProducto> findAll() {
        return añosProductoRepository.findAll();
    }

    // Obtener un registro por su ID
    public Optional<AñosProducto> findById(Integer id) {
        return añosProductoRepository.findById(id);
    }

    // Obtener años por ID de producto
    public List<AñosProducto> findByProductoId(Integer productoId) {
        return añosProductoRepository.findByProductoId(productoId);
    }

    // Guardar un nuevo registro de años
    public AñosProducto save(AñosProducto añosProducto) {
        return añosProductoRepository.save(añosProducto);
    }

    // Eliminar un registro por su ID
    public void deleteById(Integer id) {
        añosProductoRepository.deleteById(id);
    }
}
