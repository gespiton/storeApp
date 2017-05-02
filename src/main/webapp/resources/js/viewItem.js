const view = function () {
    $(document).ready(function () {
        $('.editBtn').on('click', function () {
            alert($('#serial').text());
        });
    })
};

view();