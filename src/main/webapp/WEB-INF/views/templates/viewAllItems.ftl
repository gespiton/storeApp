<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>

<#--<@model['appName'].bind appName/>-->
<h1>
    hi,there
</h1>

<#macro field>
<label class="itemField">

</label>
</#macro>

<#macro itemModule item>
<div class="wrap">
    <div class="img-thumbnail">
        <img src="/${model['appName']}/images/${item.imagePath}" class="thumbnail">
    </div>

    <div class="infowrap">
        <label class="text-info media-heading">${item.name}</label>
        <label class="text-field">shop: ${item.shop}</label>
        <label class="text-field">price: ${item.marketPrice}</label>
        <label class="text-field">category: <b>${item.categoryName}</b></label>
    </div>
    <p class="text-info">${item.description}</p>
    <div class="edit">
        <button class="btn btn-default editBtn" id="${item.serialCode}">
            <i class="glyphicon glyphicon-pencil moreBtn"></i>
        </button>
    </div>
</div>
</#macro>


<div class="viewItemPage">
    <ul class="list-group">
    <#list model["itemList"] as Item>
        <li class="list-group-item">
            <@itemModule Item></@itemModule>
        </li>
    </#list>
    </ul>
</div>
