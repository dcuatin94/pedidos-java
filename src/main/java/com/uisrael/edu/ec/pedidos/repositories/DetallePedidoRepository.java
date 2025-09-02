package com.uisrael.edu.ec.pedidos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{
    public DetallePedido findById(int id);
    public List<DetallePedido> findByActivo(boolean activo);
}
