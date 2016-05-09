<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr id='table-header'>
        <th>Date</th>
        <th>Gross</th>
        <th>Tax</th>
        <th>Net</th>
    </tr>
    </thead>
    <tbody>
        <g:each in="${pay}">
            <tr>
                <td><g:formatDate format="yyyy-MM-dd" date="${it.payDate}"/></td>
                <td><g:formatNumber number="${it.grossPay}" type="currency" currencyCode="USD" /></td>
                <td><g:formatNumber number="${it.taxAmount}" type="currency" currencyCode="USD" /></td>
                <td><g:formatNumber number="${it.netPay}" type="currency" currencyCode="USD" /></td>
            </tr>
        </g:each>
    </tbody>
</table>
