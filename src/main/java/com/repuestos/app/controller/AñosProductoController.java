package com.repuestos.app.controller;

import com.repuestos.app.model.AñosProducto;
import com.repuestos.app.service.AñosProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/años-producto")
public class AñosProductoController {

    private final AñosProductoService añosProductoService;

    public AñosProductoController(AñosProductoService añosProductoService) {
        this.añosProductoService = añosProductoService;
    }

    // Obtener todos los registros de años por producto
    @GetMapping
    public ResponseEntity<List<AñosProducto>> getAllAñosProducto() {
        return ResponseEntity.ok(añosProductoService.findAll());
    }

    // Obtener un registro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<AñosProducto> getAñosProductoById(@PathVariable Integer id) {
        Optional<AñosProducto> añosProducto = añosProductoService.findById(id);
        return añosProducto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Obtener años asociados a un producto
    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<AñosProducto>> getAñosByProductoId(@PathVariable Integer productoId) {
        return ResponseEntity.ok(añosProductoService.findByProductoId(productoId));
    }

    // Crear un nuevo registro
    @PostMapping
    public ResponseEntity<AñosProducto> createAñosProducto(@RequestBody AñosProducto añosProducto) {
        return ResponseEntity.ok(añosProductoService.save(añosProducto));
    }

    // Eliminar un registro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAñosProducto(@PathVariable Integer id) {
        añosProductoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
