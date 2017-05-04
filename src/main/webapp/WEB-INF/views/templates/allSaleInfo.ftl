<#ftl encoding='UTF-8'>
<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<#--author: 周鸿清-->
<#macro saleInfo info >
<div class="saleInfo-wrap">

    <div class="goodsName">
    ${info.goods.name}
    </div>

    <div class="price">
        market price: <label>${info.marketPrice}</label>
        real price: <label>${info.realPrice}</label>
        mid user price: <label>${info.midUserPrice}</label>
    </div>

    <div class="date">
        on market time: <label>${info.onMarketTime}</label>
        off market time: <label>${info.offMarketTime}</label>
    </div>

    <div class="action-btn">
        <button class="btn btn-default changeSaleInfo" id="${info.goodsID}">
            <i class="glyphicon glyphicon-list-alt"></i>
        </button>
    </div>
</div>
</#macro>
<div id="allSaleInfoPage">
<#list model["standList"] as info>
    <@saleInfo info></@saleInfo>
</#list>
</div>
<script src="/mystore/resources/js/allSaleInfo.js" type="text/javascript"></script>

