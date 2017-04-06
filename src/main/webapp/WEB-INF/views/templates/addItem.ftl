<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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

<#macro formfield fieldName t="text" addition="">
<div class="form-group">
    <label for="${fieldName}">${fieldName}</label>
    <input type="${t}" ${addition} class="form-control" name="${fieldName}"/>
</div>
</#macro>

<div id="addItemPage">
    <form name="item" action="${model['action']}" method="post" enctype="multipart/form-data">
        <div id="flexWrap">
        <#--TODO group add-on-->
        <@formfield "name"  "text" "require"></@formfield>
        <@formfield "serialCode" "text" "required"></@formfield>
        <@formfield "weight" "number"></@formfield>
        <@formfield "stockNumber" "number"></@formfield>
        <@formfield "preSaleNumber" "number"></@formfield>
        <@formfield "shop"></@formfield>
        <@formfield "introducedPrice" "number"></@formfield>
        <@formfield "marketPrice" "number"></@formfield>
        <@formfield "bankPrice" "number"></@formfield>
        <#--<@formfield "exchangeCredit" "number"></@formfield>-->
            <div class="form-group">
                <label for="categoryName">categoryName</label>
                <input type="hidden" class="form-control" id="hiddenCategoryName" name="categoryName"/>
                <div class="dropdown" id="category">
                    <button class="btn btn-default form-control" id="categoryBtn" type="button"
                            data-toggle="dropdown">
                        chose
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
        <@formfield "brandName"></@formfield>
        <@formfield "onMarketTime" "datetime-local"></@formfield>
        <@formfield "outMarketTime" "datetime-local"></@formfield>
        <#--<@formfield "addedTime"></@formfield>-->
        <#--<@formfield "lastModifiedTime"></@formfield>-->
        <@formfield "description"></@formfield>
        <#--<@formfield "imagePath"></@formfield>-->
        <#--todo default value -->
            <div class="form-group" id="express">
                <label>default Express</label>
                <select name="defaultExpress" class="form-control">
                    <option>union</option>
                    <option>mars</option>
                    <option>moon express</option>
                </select>
            </div>

            <div class="form-group" id="fileUpload">
                <label>upload image</label>
                <input type="file" class="file" name="image" id="input-id"/>
            </div>

            <div class="form-group" id="dividable">
                <div class="vertical-center">
                    <label>
                        Dividable
                    </label>
                    <input type="checkbox" class="checkbox" name="Dividable" checked/></div>
            </div>

        </div>
        <button type="submit" class="btn btn-primary pull-right submitBtn" value="Save">add</button>
    </form>
<#--</fieldset>-->


</div>


