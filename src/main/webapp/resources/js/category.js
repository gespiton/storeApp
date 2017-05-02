$(document).ready(
    function () {
        $('.saveBtnIn').on('click', function (event) {
            event.preventDefault();

            const formArray = $(this).parent().prev().serializeArray();
            const dataa = {};
            $(this).parent().prev().serializeArray().map(function (x) {
                dataa[x.name] = isNaN(x.value) ? x.value : x.value ? Number(x.value) : "";
            });
            dataa['type'] === 'true' ? dataa['type'] = 1 : dataa['type'] = 0;
            console.log(dataa);

            $.ajax({

                type: 'POST',
                url: 'updateCategory',
                contentType: "application/x-www-form-urlencoded",
                data: dataa,
                timeout: 100000,
                success: function (data) {
                    alert(data);
                    console.log(data);
                }
            });
        });

        $('.categoryTag').on('click', function () {
            console.log($(this).prev('button').text());
            $(this).parents('ul.multi-level').prev('button').text($(this).text());
            $('#hiddenCategoryName').val($(this).text());
            $('#upperCategoryName').text($(this).text());
            $(this).parents('div.form-group').prev('input').val($(this).text());
        });
    }
);