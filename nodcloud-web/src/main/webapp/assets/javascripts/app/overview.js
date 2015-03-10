$(function () {

    $.ajax({

        url: '../api/secure/resources/summary',
        method: 'GET',
        success: function (result, statusText, jqXhr) {
            var resources = result.resources;
            for (var i = 0; i < resources.length; i++) {
                var item = resources[i];
                var $item = $("#raw-" + item.name + "-summary");
                if ($item.length != 0) {
                    $item.attr("data-percent", item.count);
                    $item.find(".easy-pie-percent").text(item.count);
                }
            }

            $(function () {
                $('.easy-pie-custom').easyPieChart({
                    animate: 1000,
                    lineWidth: 8,
                    barColor: "#6DCBDD"
                });
            });

        }

    });

});