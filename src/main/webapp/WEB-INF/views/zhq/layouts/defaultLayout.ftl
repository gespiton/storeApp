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
    <script type="text/javascript" src="/mystore/resources/js/zhq/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/mystore/resources/css/zhq/0-tools/bootstrap/javascripts/bootstrap.js"></script>

    <link href="/mystore/resources/css/zhq/main.css" rel="stylesheet"/>
<#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"-->
<#--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
<#--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"-->
<#--integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">-->
</head>

<body>
<#--<div class="flex-container">-->
<@tiles.insertAttribute name="header"/>
<#--pushdown body-->
<div style="height: 51px"></div>
<@tiles.insertAttribute name="body"/>
<#--</div>-->
<script src="/mystore/resources/js/zhq/plugins/canvas-to-blob.min.js" type="text/javascript"></script>
<script src="/mystore/resources/js/zhq/plugins/purify.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/mystore/resources/js/zhq/fileinput.min.js"></script>
<script type="text/javascript" src="/mystore/resources/js/zhq/addItemPage.js"></script>
<script type="text/javascript" src="/mystore/resources/js/zhq/category.js"></script>
<#--todo font awesome not work,change folder-->
<script src="/mystore/resources/js/zhq/theme.js" type="text/javascript"></script>
<#--<script src="https://use.fontawesome.com/3098833ac6.js"></script>-->

</body>
</html>