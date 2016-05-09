<div id="w2">
    <g:each var="mapElem" in="${w2}">
        <div>${mapElem.key} tax paid: <g:formatNumber number="${mapElem.value}" type="currency" currencyCode="USD" /></div>
    </g:each>
</div>
