<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<#macro subCategory category>
<#--<div class="form-control dropdown">-->
<#--<div data-toggle="dropdown" class="dropdown-toggle expandable">${category.name}<b class="caret"></b></div>-->
<li class="dropdown-submenu">
    <a href="#" class="categoryTag expandable">${category.name}<b class="caret"></b></a>
    <ul class="dropdown-menu">
        <#list category.subCategory as cate>
            <#if !cate.subCategory??>
                <li class="categoryTag"><a class="categoryTag">${cate.name}</a></li>
            <#else>
                <@subCategory cate>
                </@subCategory>
            </#if>
        </#list>
    </ul>
</li>
<#--</div>-->
</#macro>
<div id="addItemPage">
    <form name="item" action="add" method="post">
        <div id="flexWrap">

            <div class="form-group">
                <label for="id">Name</label>
                <input type="text" class="form-control" name="name"/>
            </div>
            <div class="form-group">
                <label for="serialCode">serialCode</label>
                <input type="text" class="form-control" name="serialCode"/>
            </div>

            <div class="form-group">
                <label for="weight">weight</label>
                <input type="text" class="form-control" name="weight"/>
            </div>

            <div class="form-group">
                <label for="stockNumber">stockNumber</label>
                <input type="text" class="form-control" name="stockNumber"/>
            </div>

            <div class="form-group">
                <label for="preSaleNumber">preSaleNumber</label>
                <input type="text" class="form-control" name="preSaleNumber"/>
            </div>

            <div class="form-group">
                <label for="shop">shop</label>
                <input type="text" class="form-control" name="shop"/>
            </div>

            <div class="form-group">
                <label for="introducedPrice">introducedPrice</label>
                <input type="text" class="form-control" name="introducedPrice"/>
            </div>

            <div class="form-group">
                <label for="marketPrice">marketPrice</label>
                <input type="text" class="form-control" name="marketPrice"/>
            </div>

            <div class="form-group">
                <label for="bankPrice">bankPrice</label>
                <input type="text" class="form-control" name="bankPrice"/>
            </div>

            <div class="form-group">
                <label for="exchangeCredit">exchangeCredit</label>
                <input type="text" class="form-control" name="exchangeCredit"/>
            </div>

            <div class="form-group">

                <label for="categoryName">categoryName</label>
                <input type="hidden" class="form-control" name="categoryName"/>

                <div class="dropdown" id="category">
                    <button class="btn btn-default dropdown-toggle form-control categoryBtn" type="button"
                            data-toggle="dropdown">
                        chose
                    </button>
                    <ul class="dropdown-menu">
                    <#list model["composedCategoryList"] as category>
                        <#if category.subCategory??>
                            <@subCategory category>
                            </@subCategory>
                        <#else >
                            <li><a href="#">${category.name}</a></li>
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
                <label for="brandName">brandName</label>
                <input type="text" class="form-control" name="brandName"/>
            </div>

            <div class="form-group">
                <label for="outMarketTime">outMarketTime</label>
                <input type="text" class="form-control" name="outMarketTime"/>
            </div>

        <#--<div class="form-group">-->
        <#--<label for="addedTime">addedTime</label>-->
        <#--<input type="text" class="form-control" name="addedTime"/>-->
        <#--</div>-->

        <#--<div class="form-group">-->
        <#--<label for="lastModifiedTime">lastModifiedTime</label>-->
        <#--<input type="text" class="form-control" name="lastModifiedTime"/>-->
        <#--</div>-->

            <div class="form-group">
                <label for="description">description</label>
                <input type="text" class="form-control" name="description"/>
            </div>

            <div class="form-group">
                <label for="imageNumber">imageNumber</label>
                <input type="text" class="form-control" name="imageNumber"/>
            </div>

            <div class="form-group">
                <label for="isDividable">isDividable</label>
                <input type="text" class="form-control" name="isDividable"/>
            </div>

        </div>
        <button type="submit" class="btn btn-default" value="Save">add</button>
    </form>
<#--</fieldset>-->

    <table class="datatable">
        <tr>
            <th>Make</th>
            <th>Model</th>
        </tr>
    <#list model["itemList"] as Item>
        <tr>
            <td>${Item.name}</td>
            <td>${Item.id}</td>
        </tr>
    </#list>
    </table>
</div>
