<#assign tiles=JspTaglibs["http://tiles.apache.org/tags-tiles"]>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="header">
    <h2>car factory</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add Car</legend>
        <form name="car" action="add" method="post">
            Make : <input type="text" name="make"/><br/>
            Model: <input type="text" name="model"/><br/>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
    <br/>
    <table class="datatable">
        <tr>
            <th>Make</th>
            <th>Model</th>
        </tr>
    <#list model["carList"] as car>
        <tr>
            <td>${car.make}</td>
            <td>${car.model}</td>
        </tr>
    </#list>
    </table>
</div>