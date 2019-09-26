<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TaskStorage</title>
</head>
<body>

<form method="get">
<label for="currencyInput">Currency from:</label>
<input type="text" name="inputCurrency" id="state" list="currency_list">
<label for="currencyInput">Currency to:</label>
<input type="text" name="outputCurrency" id="state" list="currency_list">
<datalist id="currency_list">
    <option value="AUD">Australian Dollar</option>
    <option value="CNY">Chinese Yuan</option>
    <option value="CZK">Czech Republic Koruna</option>
    <option value="DKK">Danish Krone</option>
    <option value="EUR">Euro</option>
    <option value="GBP">British Pound Sterling</option>
    <option value="HKD">Hong Kong Dollar</option>
    <option value="ILS">Israeli New Sheqel</option>
    <option value="INR">Indian Rupee</option>
    <option value="ISK">Icelandic Krona</option>
    <option value="JPY">Japanese Yen</option>
    <option value="KZT">Kazakhstani Tenge</option>
    <option value="PLN">Polish Zloty</option>
    <option value="RUB">Russian Ruble</option>
    <option value="UAH">Ukrainian Hryvnia</option>
    <option value="USD">United States Dollar</option>
</datalist>
    <button type="submit">Button</button>
</form>

<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>From</th>
        <th>To</th>
        <th>Open</th>
        <th>High</th>
        <th>Low</th>
        <th>Close</th>
    </tr>
    </thead>
    <tbody>
    <#list results?sort_by("date") as result>
        <tr>
            <td>${result.date}</td>
            <td>${result.inputCurrency}</td>
            <td>${result.outputCurrency}</td>
            <td>${result.open}</td>
            <td>${result.high}</td>
            <td>${result.low}</td>
            <td>${result.close}</td>

        </tr>
    <#else>
        <tr>
            <td>No records</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>