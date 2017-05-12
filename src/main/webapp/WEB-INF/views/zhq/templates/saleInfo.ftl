<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#macro sale saleInfo>
<div class="sale-wrap">
    <form action="save/${saleInfo.goodsID}" method="post">
        <input type="hidden" name="goodsID" value="${saleInfo.goodsID}">
        <div class="form-group">
            <label>on market time</label>
            <input type="datetime" name="onMarketTime" class="form-control" value="${saleInfo.onMarketTime}">
        </div>
        <div class="form-group">
            <label>off market time</label>
            <input type="datetime" name="offMarketTime" class="form-control" value="${saleInfo.offMarketTime}">
        </div>
        <div class="form-group">
            <label>sale number</label>
            <input type="number" name="preSaleCount" class="form-control" value="${saleInfo.preSaleCount}">
        </div>
        <button type="submit" class="btn btn-primary submitBtn pull-right" id="saleInfo-save" value="Save">save</button>
    </form>
</div>
</#macro>

<@sale model['saleInfo']>
</@sale>