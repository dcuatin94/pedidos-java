$(document).ready(function () {
  console.log("Documento listo");
  function addFields() {
    var field =
      '<input type="text" name="producto[]" placeholder="Producto" required><input type="number" name="cantidad[]" placeholder="Cantidad" required><input type="number" step="0.1" name="precio[]" placeholder="Precio" required>';
    $("#addFields").append(field);
  }
  $("#pedidoForm").on("submit", async function (e) {
    e.preventDefault();
    var pedido = {};
    var cliente = $('input[name="cliente"]').val();
    var fecha = $('input[name="fecha"]').val();
    pedido.cliente = cliente;
    pedido.fecha = fecha;
    var productos = [];
    $('input[name="producto[]"]').each(function (index, value) {
      var producto = {};
      producto.producto = $(this).val();
      producto.cantidad = $('input[name="cantidad[]"]').eq(index).val();
      producto.precio = $('input[name="precio[]"]').eq(index).val();
      productos.push(producto);
    });
    pedido.detalles = productos;
    if (navigator.onLine) {
      try {
        const response = await sendForm(pedido);
        if (response.ok) {
          $("#pedidoForm")[0].reset();
          setTimeout(function () {
            location.reload();
          }, 3000);
          notification("Pedido enviado con éxito.", "success");
        } else {
          notification(
            "Error al enviar el pedido. Intente nuevamente.",
            "error"
          );
        }
      } catch (error) {
        notification("Error al enviar el pedido. Intente nuevamente.", "error");
      }
    } else {
      guardarPedidoEnLocal(pedido);
      $("#pedidoForm")[0].reset();
    }
  });
  function actualizarEstadoConexion() {
    if (navigator.onLine) {
      $("#offlineAlert").hide();
      sincronizarPedidos();
    } else {
      $("#offlineAlert").show();
    }
  }
  window.addEventListener("online", actualizarEstadoConexion);
  window.addEventListener("offline", actualizarEstadoConexion);
  document.addEventListener("DOMContentLoaded", function () {
    actualizarEstadoConexion();
  });
});
