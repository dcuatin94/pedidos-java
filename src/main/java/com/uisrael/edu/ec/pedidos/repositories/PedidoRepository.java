package com.uisrael.edu.ec.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.edu.ec.pedidos.models.Pedido;
import java.util.List;


public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByActivo(boolean activo);
}
