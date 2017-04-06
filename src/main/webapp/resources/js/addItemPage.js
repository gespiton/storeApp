$(document).ready(
    function () {
        $('.categoryTag').on('click', function () {
            $('#categoryBtn').text($(this).text());
            $('#hiddenCategoryName').val($(this).text());

            // initialize file input plugin
            $("#input-id").fileinput();
        });

        // viewItem
        $('.editBtn').on('click', function () {
            var cur = window.location.href;
            cur = cur.substr(0, cur.lastIndexOf('/')) + '/editItem/' + $(this).attr('id');
            window.location.href = cur;
        });
    }()
);
