function addTransaction() {
    const product = $('#modal-transaction-product').val();
    const body = {
        product: product,
        amount: 22,
        type: 'BUY'
    };

    fetch('/api/transactions', {
        method: 'post',
        body: JSON.stringify(body),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        location.reload();
    });
}

function editTransaction() {
    alert("hello");
}

$(document).ready(() => {

    $('.fa-edit').click(function () {
        editMovieId = this.parentElement.id;

        const row = this.parentElement.parentElement.parentElement;
        const title = row.children[0].innerText;
        const year = row.children[1].innerText;
        const rating = row.children[2].innerText;

        $('#modal-transaction-product').val(title);
        $('#modal-movie-year').val(year);
        $('#modal-movie-rating').val(rating);
    });
});
