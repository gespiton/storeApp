<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#--author: 周鸿清-->
<#macro field>
<label class="itemField">

</label>
</#macro>

<#macro itemModule goods>
<div class="wrap">
    <div class="img-thumbnail">
        <img src="/${model['appName']}/images/${goods.imagePath}" class="thumbnail">
    </div>

    <div class="infowrap">
        <label class="text-info media-heading">${goods.name}</label>
        <label class="text-field">storeId: ${goods.storeId}</label>
        <label class="text-field">price: ${goods.marketPrice}</label>
        <label class="text-field">category: <b>${goods.categoryId}</b></label>
    </div>
    <p class="text-info">${goods.description}</p>
    <div class="edit">
        <button class="btn btn-default editBtn" id="${goods.serialCode}">
            <i class="glyphicon glyphicon-pencil moreBtn"></i>
        </button>
    </div>
</div>
</#macro>


<div class="viewItemPage">
    <ul class="list-group">
    <#list model["itemList"] as Item>
        <li class="list-group-goods">
            <@itemModule Item></@itemModule>
        </li>
    </#list>
    </ul>
</div>
