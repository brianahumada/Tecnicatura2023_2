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
    });
    
    //texto
    const modalTitle = document.createElement("div");
    modalTitle.innerText = "Carrito";
    modalTitle.className = "modal-title";
    //Agregamos a modalTitle a modalHeader
    modalHeader.append(modalTitle);

    //agregamos el modalHeader al modalContainer
    modalContainer.append(modalHeader);

    //modal Body
    cart.forEach((product)=> {
        const modalBody = document.createElement("div");
        modalBody.className = "modal-body";
        modalBody.innerHTML= `
        <div class="product">
                <img class="product-img" src="${product.img}" />
                <div class="product-info>
                    <h4>${product.productName}</h4>
                </div>
            <div class="quantity">
                <span class="quantity-btn-decrese">-</span>
                <span class="quantity-input">${product.quanty}</span>
                <span class="quantity-btn-increse">+</span>
            </div>
                <div class="price">${product.price * product.quanty} $</div>
                <div class="delete-product">❌</div>
        </div>
        `;
        // agregamos el modal body
        modalContainer.append(modalBody);

        //funcioanalidad de botones de resta 
        const decrese = modalBody.querySelector(".quantity-btn-decrese");//campuramos el boton por la clase de css 
        decrese.addEventListener("click",()=>{
            if(product.quanty !== 1){ //si el producto llega a uno no puede restar mas
                product.quanty--; //modificamos el carrito la cantidades
                displayCart();
            }
        });
        //Suma de productos
        const increse = modalBody.querySelector(".quantity-btn-increse");
        increse.addEventListener("click",()=>{
            product.quanty++;
            displayCart();
        });

        //Eleminar
        const deleteProduct = modalContainer.querySelector(".delete-product");
        deleteProduct.addEventListener("click", ()=>{
            deleteCartProduct(product.id);
            displayCart();
        });
    });

    
    //calculamos el total.
    const total = cart.reduce((acc,el) => acc + el.price * el.quanty, 0);

    //modal footer
    const modalFooter = document.createElement("div");
    modalFooter.className = "modal-footer";
    modalFooter.innerHTML = `
    <div class="total-price">Total = ${total}</div>
    `;
    modalContainer.append(modalFooter);

};

//indicamos que el boton cart-btn abra el carrito
cartBtn.addEventListener("click", displayCart);

//Funcion para eliminar producto
const deleteCartProduct = (id)=>{
    //detectar producto el indixe del array,utilizamos metodo =finIndex() devuelve ! -1
    const foundId = cart.findIndex((element) => element.id === id);
    console.log(typeof foundId);
    if (foundId !== -1) {
        // El producto se encontró en el carrito
        cart.splice(foundId, 1); // Elimina el producto del carrito
        // También puedes realizar otras acciones, como actualizar la visualización del carrito
        console.log("Producto eliminado del carrito.");
    } else {
        // El producto no se encontró en el carrito
        console.log("El producto no se encontró en el carrito.");
    }

}