package com.uisrael.edu.ec.pedidos.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;
import com.uisrael.edu.ec.pedidos.models.Pedido;
import com.uisrael.edu.ec.pedidos.services.DetallePedidoService;
import com.uisrael.edu.ec.pedidos.services.PedidoService;

@Controller
public class PedidosController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;
	
	@GetMapping("/")
	public String Index(Model model) {
		model.addAttribute("pedidos", pedidoService.listarPedidos());
		return "index";
	}
	
	@PostMapping("/pedir")
	@ResponseBody
	public Map<String, Object> insertarPedido(@RequestBody Pedido pedido) {
		Map<String, Object> respuesta = new HashMap<>();
		Pedido pedidoGuardado = pedidoService.insertarPedido(pedido);
		if (pedidoGuardado != null) {
			for (DetallePedido detallePedido : pedido.getDetalles()) {
				detallePedido.setPedido(pedidoGuardado);
				detallePedidoService.insertarDetalle(detallePedido);
			}
			respuesta.put("success", true);
			respuesta.put("mensaje", "Pedido registrado con éxito");
		} else {
			respuesta.put("success", false);
			respuesta.put("mensaje", "Error al registrar el pedido");
		}
		return respuesta;
	}
	
}
