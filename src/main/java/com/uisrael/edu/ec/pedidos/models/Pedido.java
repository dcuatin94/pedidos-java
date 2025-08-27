package com.uisrael.edu.ec.pedidos.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cliente;
	private Date fecha;
	private boolean sincronizado = false;
	private boolean activo = true;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.REFRESH)
	private List<DetallePedido> detalles = new ArrayList<>();
}
