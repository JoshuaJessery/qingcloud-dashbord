"use strict";

/**
 *
 * 销毁的主机ID数组
 *
 * */
var DestoryInstanceTag = {

    instances: new Array(),
    destoryInstance: function (instances) {
        instances = instances.filter(this.notUndefine);
        this.instances = instances;
        $("#destoryInstanceModel").modal();
    },
    sendRequest: function (instances) {

    },
    notUndefine: function (element) {
        return  element != undefined;
    }

};

$(function () {
    $("#tagBtnSureDestoryInstance").on('click', function () {

        var index = 0;
        var requestUrl = "";
        DestoryInstanceTag.instances.forEach(function (item) {

            requestUrl += "&instance." + index + "=" + item;
            index++;
        });

        $.get("terminateInstances?" + requestUrl).success(function (data) {
            console.log(data);
        });

    });
});
