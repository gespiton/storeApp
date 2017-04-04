<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
                <input type="text" class="form-control" name="categoryName"/>
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

    <#--<label>-->
    <#--preSaleNumber-->
    <#--<input type="text" name="preSaleNumber"/>-->
    <#--</label>-->

    <#--<label>-->
    <#--shop-->
    <#--<input type="text" name="shop"/>-->
    <#--</label>-->

    <#--<div>-->
    <#--price-->
    <#--<label>-->
    <#--itroducedPrice-->
    <#--<input type="text" name="itroducedPrice"/>-->
    <#--</label><br>-->
    <#--<label>-->
    <#--marketPrice-->
    <#--<input type="text" name="marketPrice"/>-->
    <#--</label><br>-->
    <#--<label>-->
    <#--bankPrice-->
    <#--<input type="text" name="bankPrice"/>-->
    <#--</label><br>-->
    <#--</div>-->

    <#--<label>-->
    <#--exchangeCredit-->
    <#--<input type="text" name="exchangeCredit"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--categoryName-->
    <#--<input type="text" name="categoryName"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--brandName-->
    <#--<input type="text" name="brandName"/>-->
    <#--</label><br>-->


    <#--<label>-->
    <#--onMarketTime-->
    <#--<input type="text" name="onMarketTime"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--outMarketTime-->
    <#--<input type="text" name="outMarketTime"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--addedTime-->
    <#--<input type="text" name="addedTime"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--lastModifiedTime-->
    <#--<input type="text" name="lastModifiedTime"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--description-->
    <#--<input type="text" name="description"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--imageNumber-->
    <#--<input type="text" name="imageNumber"/>-->
    <#--</label><br>-->

    <#--<label>-->
    <#--isDividable-->
    <#--<input type="text" name="isDividable"/>-->
    <#--</label><br>-->

        <button type="submit" class="btn btn-default" value="Save">add</button>
    </form>
<#--</fieldset>-->

    <table class="datatable">
        <tr>
            <th>Make</th>
            <th>Model</th>
        </tr>
    <#list model["carList"] as Item>
        <tr>
            <td>${Item.id}</td>
            <td>${Item.name}</td>
        </tr>
    </#list>
    </table>
</div>