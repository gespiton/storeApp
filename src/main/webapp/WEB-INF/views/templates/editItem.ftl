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
    <form name="goods" action="${model['goods'].id}" method="post" enctype="multipart/form-data">
        <div id="flexWrap">
        <#--TODO group add-on-->
            <div class="form-group">
                <label for="name">name</label>
                <input type="text" require class="form-control" name="name" value="${model['goods'].name}"/>
            </div>
            <div class="form-group">
                <label for="serialCode">serialCode</label>
                <input type="text" required class="form-control" name="serialCode" disabled
                       value="${model['goods'].serialCode}"/>
            </div>
            <div class="form-group">
                <label for="weight">weight</label>
                <input type="number" class="form-control" name="weight" value="${model['goods'].weight}"/>
            </div>
            <div class="form-group">
                <label for="stockNumber">stockNumber</label>
                <input type="number" class="form-control" name="stockNumber" value="${model['goods'].stockNumber}"/>
            </div>
            <div class="form-group">
                <label for="preSaleNumber">preSaleNumber</label>
                <input type="number" class="form-control" name="preSaleNumber" value="${model['goods'].preSaleNumber}"/>
            </div>
            <div class="form-group">
                <label for="storeId">storeId</label>
                <input type="text" class="form-control" name="storeId" value="${model['goods'].storeId}"/>
            </div>
            <div class="form-group">
                <label for="midUserPrice">midUserPrice</label>
                <input type="number" class="form-control" name="midUserPrice"
                       value="${model['goods'].midUserPrice}"/>
            </div>
            <div class="form-group">
                <label for="marketPrice">marketPrice</label>
                <input type="number" class="form-control" name="marketPrice" value="${model['goods'].marketPrice}"/>
            </div>
            <div class="form-group">
                <label for="realPrice">realPrice</label>
                <input type="number" class="form-control" name="realPrice" value="${model['goods'].realPrice}"/>
            </div>
        <#--<@formfield "redeemPoint" "number"></@formfield>-->
            <div class="form-group">
                <label for="categoryId">categoryId</label>
                <input type="hidden" class="form-control" id="hiddenCategoryName" name="categoryId"
                       value="${model['goods'].categoryId}"/>
                <div class="dropdown" id="category">
                    <button class="btn btn-default form-control" id="categoryBtn" type="button"
                            data-toggle="dropdown">
                    ${model['goods'].categoryId}
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
                    </ul>
                </div>
            </div>

            <div class="form-group">
                <label for="brandId">brandId</label>
                <input type="text" class="form-control" name="brandId" value="${model['goods'].brandId}"/>
            </div>

            <div class="form-group">
                <label for="standId">standId</label>
                <input class="form-control" name="standId" disabled
                <#if model['goods'].standId??>
                       value="${model['goods'].standId}"
                </#if>
                />
            </div>
            <div class="form-group">
                <label for="description">description</label>
                <input type="text" class="form-control" name="description" value="${model['goods'].description}"/>
            </div>


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
                <input type="hidden" name="imagePath" value="${model['goods'].imagePath}"/>
                <input type="file" class="file" name="image" id="input-id"/>
            </div>

            <div class="form-group" id="dividable">
                <div class="vertical-center">
                    <label>
                        Dividable
                    </label>
                    <input type="checkbox" class="checkbox" name="dividable"
                    <#if model['goods'].dividable??>
                           checked
                    </#if>/></div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary pull-right submitBtn" value="Save">update</button>
    </form>
<#--</fieldset>-->


</div>


