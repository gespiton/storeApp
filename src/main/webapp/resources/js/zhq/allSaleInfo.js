$(function () {
    $('button.changeSaleInfo').on('click', function () {
        let cur = window.location.href;
        cur = cur.substr(0, cur.lastIndexOf('/')) + '/saleInfo/' + $(this).attr('id');
        window.location.href = cur;
    });
});