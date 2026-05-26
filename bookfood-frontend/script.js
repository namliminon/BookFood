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

        const foodCard = button.closest('.food-card');
        const foodImg = foodCard.querySelector('.food-image img');
        const cartLink = cartCountElement.closest('a');

        const imgRect = foodImg.getBoundingClientRect();
        const cartRect = cartLink.getBoundingClientRect();

        const flyingImg = foodImg.cloneNode(true);
        flyingImg.classList.add('flying-effect');

        flyingImg.style.left = imgRect.left + 'px';
        flyingImg.style.top = imgRect.top + 'px';
        flyingImg.style.width = imgRect.width + 'px';
        flyingImg.style.height = imgRect.height + 'px';

        document.body.appendChild(flyingImg);

        setTimeout(() => {
            flyingImg.style.left = cartRect.left + cartRect.width / 2 + 'px';
            flyingImg.style.top = cartRect.top + cartRect.height / 2 + 'px';
            flyingImg.style.width = '30px';
            flyingImg.style.height = '30px';
            flyingImg.style.opacity = '0.3';
        }, 10);

        setTimeout(() => {
            flyingImg.remove();
        }, 1500);

        toastElement.classList.add('show');

        setTimeout(() => {
            toastElement.classList.remove('show');
        }, 500);

    })
});

const btnTable = document.querySelector('.btn-table');      // Nút "Xem sơ đồ bàn ăn" trên navbar
const tableModal = document.getElementById('table-modal');   // Cả tấm màn mờ bọc popup
const closeModal = document.querySelector('.close-modal');  // Dấu X để đóng
const danhSachBanContainer = document.getElementById('danh-sach-ban')

let intervalId = null;
btnTable.addEventListener('click',() => {
    tableModal.style.display = 'flex';
    taiDuLieuBanAnTuBackend();
    intervalId = setInterval(taiDuLieuBanAnTuBackend,1000);
});

closeModal.addEventListener('click',() => {
    tableModal.style.display ='none';
    clearInterval(intervalId)
});

function taiDuLieuBanAnTuBackend(){
    fetch('http://localhost:8080/api/ban-an')
        .then(response => response.json())
        .then(danhSachBan => {
            danhSachBanContainer.innerHTML ='';

            danhSachBan.forEach(ban => {
                const card = document.createElement('div');

                if (ban.ordered){
                    card.className ='ban-card ban-co-khach';
                }
                else{
                    card.className ='ban-card ban-trong'
                }

                let textTrangThai = ban.ordered ? 'Đang có khách':'Bàn Trống';
                let chuoiPhutGiay = '00:00';
                let thoiGianHienThi = ban.ordered ? ban.thoiGianDemNguoc : '00:00';

                card.innerHTML = `
                <div class="ban-id">BÀN SỐ ${ban.idBan}</div>
                    <div class="ban-status">${textTrangThai}</div>
                    <div class="ban-timer">${thoiGianHienThi}</div>`;

                danhSachBanContainer.appendChild(card);

            });
        })
        .catch(error => {
            console.error('Ôi có lỗi kết nối mất rồi!',error);
        });
}

