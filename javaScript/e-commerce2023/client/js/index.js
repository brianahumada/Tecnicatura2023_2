const shopContent = document.getElementById('shopContent');
const cart = [];//Este es nuestro carrito

productos.forEach((product) =>{
    //Creamos un elemento
    const content = document.createElement("div");
    content.innerHTML = `   
    <img src=" ${product.img}">
    <h3>${product.productName}</h3>
    <p>${product.price} </p>
    `;
    shopContent.append(content);

    //Generamos un boton para cada producto
    const buyButton = document.createElement("button");
    buyButton.innerText = "Comprar";// le ponemos un texto al boton

    //lo aderimos al content donde tenemos el div
    content.append(buyButton);

    //evento addEventListener
    buyButton.addEventListener("click", () =>{
        cart.push({
            id: product.id,
            product: product.productName,
            price: product.price,
            quanty: product.quanty,
            img: product.img,
        })
        console.log(cart)
    })

});