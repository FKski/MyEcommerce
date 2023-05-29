const a = 5;
const foo = () => {console.log("Hello world!")};

(() => {
    foo();
})


const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const getCurrentOffer = () => {
    return fetch("/api/offer")
        .then(response => response.json());
}

const refreshOffer = async () => {
    const offer = await getCurrentOffer();
    const cart = document.querySelector(".cart");

    cart.querySelector(".total").textContent = `${offer.total} PLN`;
    cart.querySelector(".itemsCount").textContent = `${offer.itemsCount} items`;
}
const createHtmlFromString = (htmlAsString) => {
    const tmpElem= document.createElement('div');
    tmpElem.innerHTML = htmlAsString.trim();
    return tmpElem.firstChild;
}

const createHtmlComponent = (product) => {
    const template = `
    <li class="product">
        <h4>${product.name}</h4>
        <img />
        <span>${product.price}</span>
        <button class="product_addToCart" data-product-id="${product.id}">
        Add to cart
        </button>
    </li>
    `

    return createHtmlFromString(template)
}

const initializeAddToCartHandler = (htmlEl) => {
    const btn = htmlEl.querySelector('button.product_addToCart');
    btn.addEventListener('click', () => {
        addToCart(btn.getAttribute('data-product-id'))
            .then(refreshOffer());
    });

    return htmlEl;
}

const addToCart = (productId) => {
    return fetch(`/api/add-to-cart/${productId}`, {method: "POST"});
}

(async () => {
    const productsList = document.querySelector('#products-list');

    await refreshOffer();

    const products = await  getProducts();


            products
                .map(product => createHtmlComponent(product))
                .map(productComponent => initializeAddToCartHandler(productComponent))
                .forEach(el => productsList.appendChild(el));


})();