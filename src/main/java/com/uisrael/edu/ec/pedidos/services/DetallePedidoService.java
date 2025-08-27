package com.uisrael.edu.ec.pedidos.services;

import java.util.List;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;

public interface DetallePedidoService {
	public void insertarDetalle(DetallePedido detallePedido);
	public List<DetallePedido> listarDetalle();
}
