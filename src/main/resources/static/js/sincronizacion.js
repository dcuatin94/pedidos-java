function guardarPedidoEnLocal(pedido) {
  const pedidosPendientes =
    JSON.parse(localStorage.getItem("pedidosPendientes")) || [];
  pedidosPendientes.push(pedido);
  localStorage.setItem("pedidosPendientes", JSON.stringify(pedidosPendientes));
  notification("Pedido guardado localmente. Se sincronizará cuando haya conexión.");
}

async function sincronizarPedidos() {
  const pedidosPendientes =
    JSON.parse(localStorage.getItem("pedidosPendientes")) || [];
  if (pedidosPendientes.length === 0) {
	notification("No hay pedidos pendientes para sincronizar.");
    return;
  }
  try {
    const respuesta = await sendForm(pedidosPendientes[0]);
    if (respuesta.ok) {
      pedidosPendientes.shift();
      localStorage.setItem(
        "pedidosPendientes",
        JSON.stringify(pedidosPendientes)
      );
      notification("Pedido agregado correctamente.");
	  setTimeout(function(){location.reload();}, 3000);
      sincronizarPedidos(); // Intentar sincronizar el siguiente pedido
    } else {
      console.error("Error al sincronizar el pedido:", respuesta.statusText);
    }
  } catch (error) {
    console.error("Error de red al sincronizar el pedido:", error);
  }
}

async function sendForm(pedido){
  console.log("Enviando pedido:", pedido);
	return await fetch("/pedidos/insertar", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(pedido),
	});
}