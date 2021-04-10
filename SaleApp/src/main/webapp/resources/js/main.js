/* global fetch */

function deleteProduct(productId) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch("/SaleApp/api/products/" + productId, {
            method: "delete",
            headers: {
                "Content-Type": "applcation/json"
            }
        }).then(function (res) {
            if (res.status === 200) {
                let d = document.getElementById(`product${productId}`);
                d.style.display = 'none';
            } else {
                alert("Something wrong!");
            }
        });
    }
}

function addToCart(productId) {
    fetch(`/SaleWebApp/api/cart/${productId}`).then(function (res) {
        if (res.status === 200) {
            let d = document.getElementById("cart-counter");
            let v = parseInt(d.innerText);
            d.innerText = v + 1;
        } else {
            alert("Something wrong!!!");
        }
    });
}
