let count = 0;
const cartCountElement = document.getElementById('cart-count');
const orderButtons = document.querySelectorAll('.btn-order')
const toastElement = document.getElementById('toast-notification')

orderButtons.forEach(button => {
    button.addEventListener('click', () => {
        count = count + 1;
        cartCountElement.innerText = count;

        //Thông báo
        toastElement.classList.add('show');

        setTimeout(() => {
            toastElement.classList.remove('show');
        },500);
    })
});