package com.uisrael.edu.ec.pedidos.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uisrael.edu.ec.pedidos.models.DetallePedido;
import com.uisrael.edu.ec.pedidos.models.Pedido;
import com.uisrael.edu.ec.pedidos.services.DetallePedidoService;
import com.uisrael.edu.ec.pedidos.services.PedidoService;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@PostMapping("/pedidos/insertar")
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

	@GetMapping("/pedidos/editar/{id}")
	public String getPedidoById(Model model, @PathVariable int id) {
		Pedido pedido = pedidoService.findById(id);
		model.addAttribute("pedido", pedido);
		return "forms/frmPedido";
	}
	
	@PostMapping("/pedidos/guardar")
	@ResponseBody
	public Map<String, Object> GuardarCambiosPedido(@RequestBody Pedido pedido) {
		Map<String, Object> respuesta = new HashMap<>();
		Pedido pedido_editado = new Pedido();
		pedido_editado = pedidoService.insertarPedido(pedido);
		for (DetallePedido detalle : pedido.getDetalles()) {
			detalle.setPedido(pedido_editado);
			detallePedidoService.insertarDetalle(detalle);
		}
		respuesta.put("success", true);
		respuesta.put("mensaje", "Pedido actualizado con éxito");
		return respuesta;
	}
	
	@GetMapping("/pedidos/eliminar/{id}")
	public String EliminarPedido(@PathVariable int id) {
		Pedido pedido = pedidoService.findById(id);
		pedido.setActivo(false);
		pedidoService.insertarPedido(pedido);
		return "redirect:/";	
	}
}
