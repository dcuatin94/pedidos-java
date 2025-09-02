package com.uisrael.edu.ec.pedidos.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DetallePedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String producto;
	private double cantidad;
	private double precio;
	private boolean activo = true;
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
}
