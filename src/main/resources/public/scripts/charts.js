function geoChart(data) {

    var chart1 = {};
    chart1.type = "GeoChart";
    chart1.data = [
        ['Country', 'Clicks']
    ];
    var item;
    for (var type in data) {
        item = [];
        item = type;
        item = [item, data[type]];
        chart1.data.push(item);
    }
    chart1.options = {};

    return chart1;

}

function barChart(data, key, value) {

    var colors = ['red', 'blue', 'grey', 'orange', 'green', 'purple', 'yellow', 'brown'];
    var chart1 = {};
    chart1.type = "BarChart";
    chart1.data = [
        [key, value, {role: 'style'}]
    ];
    if (data != null) {
        var item;
        var index = 0;
        for (var type in data) {
            item = [];
            item = type;
            if (index == 7)
                index = 0;
            item = [item, data[type], colors[index++]];
            chart1.data.push(item);
        }
    } else {
        chart1.data.push(['', 0, 0]);
    }
    chart1.options = {};
    return chart1;

}

