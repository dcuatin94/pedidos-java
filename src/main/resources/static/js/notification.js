function notification(message, type = "success") {
  Toastify({
    text: message,
    duration: 3000,
    close: true,
    gravity: "top", // `top` or `bottom`
    position: "right", // `left`, `center` or `right`
    backgroundColor: type == "success" ? "#4fbe87" : "#ff6b6b",
    stopOnFocus: true, // Prevents dismissing of toast on hover
  }).showToast();
}
