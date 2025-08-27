package com.uisrael.edu.ec.pedidos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;
import com.uisrael.edu.ec.pedidos.models.Pedido;
import com.uisrael.edu.ec.pedidos.repositories.PedidoRepository;
import com.uisrael.edu.ec.pedidos.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	@Autowired
	private PedidoRepository pedidoRepository;
	@Override
	public Pedido insertarPedido(Pedido pedido) {
		try {
			return pedidoRepository.save(pedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

}
