package com.uisrael.edu.ec.pedidos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;
import com.uisrael.edu.ec.pedidos.repositories.DetallePedidoRepository;
import com.uisrael.edu.ec.pedidos.services.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Override
	public void insertarDetalle(DetallePedido detallePedido) {
		try {
			detallePedidoRepository.save(detallePedido);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<DetallePedido> listarDetalle() {
		return detallePedidoRepository.findAll();
	}
}
