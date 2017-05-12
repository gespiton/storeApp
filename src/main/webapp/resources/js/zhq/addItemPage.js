$(function () {
        if (!window.location.href.includes('Item')) {
            console.log('not this page');
            return;
        }

        $('.categoryTag').on('click', function () {
            console.log($(this).prev('button').text());
            $(this).parents('ul.multi-level').prev('button').text($(this).text());
            $('#hiddenCategoryName').val($(this).text());
        });
        // initialize file input plugin
        // $("#input-id").fileinput();
        // viewItem
        $('button.editBtn').on('click', function () {
            let cur = window.location.href;
            cur = cur.substr(0, cur.lastIndexOf('/')) + '/editItem/' + $(this).attr('id');
            window.location.href = cur;
        });
        $('button.saleBtn').on('click', function () {
            let cur = window.location.href;
            cur = cur.substr(0, cur.lastIndexOf('/')) + '/saleInfo/' + $(this).attr('id');
            window.location.href = cur;
        });

        // // fillout form
        // var hrefLi = window.location.href.split('/');
        // if (hrefLi[hrefLi.length - 2] == 'editItem') {
        //     $.ajax('getItemInfo', function (item) {
        //         console.log(item);
        //     })
        // }
    }()
);
