<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#--author: 周鸿清-->
<#macro subCategory category>
<li class="dropdown-submenu">
    <a tabindex="-1" class="categoryTag expandable">${category.name}</a>
    <ul class="dropdown-menu">
        <#list category.subCategory as cate>
            <#if !cate.subCategory??>
                <li><a class="categoryTag">${cate.name}</a></li>
            <#else>
                <@subCategory cate>
                </@subCategory>
            </#if>
        </#list>
    </ul>
</li>
</#macro>
<#macro categoryCard category >
<div class="category-wrap">
    <form action="updateCategory" class="infowrap" method="post">
    <#--<div class="category-name">-->
    <#--${category.name}-->
    <#--</div>-->
        <input type="text" class="category-name" name="name" value="${category.name}">
        <input type="hidden" class="form-control" name='id' value="${category.id}">


    <#--this input stays here, you know me -->
    <#--<input type="hidden" name='upperCategoryId'-->
    <#--<#if category.upperCategoryId??>value="${category.upperCategoryId}"</#if>>-->
        <input type="hidden" name="upperCategoryName" class="upperCategoryName"
               <#if category.upperCategoryName??>value="${category.upperCategoryName}"</#if>>
        <div class="form-group">
            <label>upperCategory</label>
            <div class="dropdown" id="category">
                <button class="btn btn-default form-control categoryBtn" type="button"
                        data-toggle="dropdown">
                    <#if category.upperCategoryName??>
                ${category.upperCategoryName}
                    </#if>
                </button>
                <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
                    <#list model["composedCategoryList"] as category>
                        <#if category.subCategory??>
                            <@subCategory category>
                            </@subCategory>
                        <#else >
                            <li><a class="categoryTag">${category.name}</a></li>
                        </#if>
                    </#list>
                <#--<li><a href="#">Inbox</a></li>-->
                <#--<li><a href="#">Drafts</a></li>-->
                <#--<li><a href="#">Sent Items</a></li>-->
                <#--<li class="divider"></li>-->
                <#--<li><a href="#">Trash</a></li>-->
                </ul>
            </div>
        </div>
        <div class="form-group">
            <label>rank</label>
            <input type="text" class="form-control" readonly="readonly" name='rank' value="${category.rank}">
        </div>
        <div class="form-group">
            <label>priority</label>
            <input type="text" class="form-control" name='priority' value="${category.priority}">
        </div>
        <div class="form-group">
            <label>display</label>
            <select name="type" class="form-control">
                <option <#if category.type==1>selected</#if>>true</option>
                <option <#if category.type==0>selected</#if>>false</option>
            </select>
        </div>
    </form>
    <div class="action-btn">
        <button type='submit' class="btn btn-default saveBtnIn" id="${category.id}">
            <i class="glyphicon glyphicon-saved"></i>
        </button>
    </div>
    <div class="action-btn delete">
        <button class="btn btn-default saveBtnIn" id="${category.id}">
            <i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
</div>
</#macro>
<#list model["categoryList"] as category>
    <@categoryCard category=category>

    </@categoryCard>
</#list>
