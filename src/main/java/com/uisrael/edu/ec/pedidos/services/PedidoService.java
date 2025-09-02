package com.uisrael.edu.ec.pedidos.services;

import java.util.List;

import com.uisrael.edu.ec.pedidos.models.Pedido;

public interface PedidoService {
	public Pedido insertarPedido(Pedido pedido);
	public Pedido findById(int id);
	public List<Pedido> listarPedidos();
	public List<Pedido> findByActivo();
}
