<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>TaskStorage</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([

                <#list results?sort_by("date") as result>
                ["${result.date}",${result.low},${result.open},${result.close},${result.high}]<#sep>,
                </#list>

                // ['2018', 1.1272, 1.1276, 1.1274,1.1283 ],
                // ['2019', 1.1272, 1.1276, 1.1274,1.1283 ]

                //https://developers.google.com/chart/interactive/docs/gallery/candlestickchart
                //
                //Col 0: String (discrete) used as a group label on the X axis, or number, date, datetime, or timeofday (continuous) used as a value on the X axis.
                // 1: Number specifying the low/minimum value of this marker.
                // 2: Number specifying the opening/initial value of this marker.
                // 3: Number specifying the closing/final value of this marker.
                // 4: Number specifying the high/maximum value of this marker.
                // 5 [Optional]: A tooltip or style column for the candlestick.

            ], true);

            var options = {
                legend:'none',
                fontSize: 14,
                hAxis: {
                    slantedTextAngle: 90,
                    // direction: -1
                }
            };

            var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div'));

            chart.draw(data, options);
        }
    </script>
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
<tbody>
<#if results?size != 0>
        <div id="chart_div" style="width: 1600px; height: 800px;"></div>
<#else>
<div>No records</div>
</#if>
</tbody>

</body>
</html>