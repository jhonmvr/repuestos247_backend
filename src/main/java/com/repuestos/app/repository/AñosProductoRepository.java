package com.repuestos.app.repository;

import com.repuestos.app.model.AñosProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AñosProductoRepository extends JpaRepository<AñosProducto, Integer> {
    List<AñosProducto> findByProductoId(Integer productoId);

}
