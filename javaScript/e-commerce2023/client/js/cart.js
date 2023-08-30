const modalContainer = document.getElementById("modal-container");
const modalOverlay = document.getElementById("modal-overlay");
const cartBtn = document.getElementById("cart-btn");

const displayCart = () =>{
    //Limpiamos el contenido para que no se cree nuevamente
    modalContainer.innerHTML = "";
    //vamos a setiar el css cambiamos el none para que nos muestre
    modalContainer.style.display = "block";
    modalOverlay.style.display = "block";
    //modal header
    const modalHeader = document.createElement("div");
    
    //Boton que cierra el modal
    const modalClose = document.createElement("div");
    modalClose.innerText = "❌";
    modalClose.className = "modal-close";// para css agregamos una clase
    //agregamos al modalHeader para el dom
    modalHeader.append(modalClose);

    //le decimos a modalClose que escuche el evento
    modalClose.addEventListener("click",() =>{
        modalContainer.style.display = "none";
        modalOverlay.style.display = "none";
    })
    
    //texto
    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Carrito";
    modalTitle.className = "modal-title";
    //Agregamos a modalTitle a modalHeader
    modalHeader.append(modalTitle);

    //agregamos el modalHeader al modalContainer
    modalContainer.append(modalHeader);

};

//indicamos que el boton cart-btn abra el carrito
cartBtn.addEventListener("click", displayCart);