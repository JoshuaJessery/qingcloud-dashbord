$(document).ready(function () {

    var zones = {
        "GD1": "广州1区",
        "PEK1": "北京1区",
        "PEK2": "北京2区"
    }

    $('table th .checkall').on('click', function () {
        $(this).closest('table').find(':checkbox').prop('checked', $(this).prop('checked'));
    });

    $(".disabled-link").click(function (event) {
        event.preventDefault();
    });

    $.ajax({
        method: "get",
        url: ctx + "/dashbord/api/commons/zones",
        success: function (zones) {
            for (var i in zones) {
                $(".availiable_zones_list").append('<li><a href="changeZones?zone=' + zones[i] + '">' + parseZone(zones[i]) + '(' + zones[i] + ')</a></li>');
            }
        }
    });

    $.ajax({
        method: "get",
        url: ctx + "/dashbord/api/commons/currentZone",
        success: function (zone) {
            $("#currentZone").text(parseZone(zone));
        }
    });

    function parseZone(zone) {

        return zones[zone] !== undefined ? zones[zone] : zone;

    }

});