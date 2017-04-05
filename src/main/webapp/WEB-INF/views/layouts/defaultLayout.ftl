<#ftl encoding="utf-8">
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta charset="utf-8">
    <title>
    <@tiles.getAsString name="title"/>
    </title>
    <link href="/storeApp/resources/css/main.css" rel="stylesheet"/>
<#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"-->
<#--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
<#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"-->
<#--integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">-->
</head>

<body>
<div class="flex-container">
<@tiles.insertAttribute name="header"/>
<@tiles.insertAttribute name="body"/>
</div>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="/storeApp/resources/css/0-tools/bootstrap/javascripts/bootstrap.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
//        var need = 0;
                var heri = [$('#category')];

                // pause function
                function sleep(ms) {
                    return new Promise(resolve => setTimeout(resolve, ms));
                }

                async function ina(e) {
                    console.log('in');
//                    console.log(heri.length);
                    console.log($(this).text());
                    if (heri[heri.length - 1].has($(this)).length != 0) {
                        //going down
                        console.log('on');

                        if ($(this).attr('class').endsWith('expandable')) {
                            $(this).next('ul').toggle();
                            heri.push($(this).next('ul'));
                        }
                        else
                            heri.push($(this));

//                        e.stopPropagation();
//                        e.preventDefault();
                    } else if (heri[0].has($(this)).length != 0) {
                        // going parallel
                        console.log('wait');
                        await sleep(120);
                        $(this).next('ul').toggle();
                        heri.push($(this).next('ul'));
                    }
                }

                async function out(e) {
//                    console.log($(this).get());
                    console.log('out');
//                    setTimeout(function () {
                    await sleep(100);
//                  // goes down
                    if ($(this).next('ul').has(heri[heri.length - 1]).length != 0)
                        return;

                    // goes up or out
                    while (heri[heri.length - 1].has($(this)).length == 0 && heri.length > 1) {
                        const v = heri[heri.length - 1];
//                        console.log(v.html());
                        if (v.attr('class') && v.attr('class').endsWith('dropdown-menu')) {
                            heri.pop().toggle();
                        } else
                            heri.pop();
                        console.log('pop');
                    }
                    console.log('finished ' + heri.length);
//                    }, 100);
                }

                $('a.categoryTag').hover(ina, out);
            }
    );
</script>
</body>
</html>