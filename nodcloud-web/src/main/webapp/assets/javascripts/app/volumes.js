$(function () {

    var $volumeForm = $("#volumeForm");
    var $btnDestory = $("#btn_destory");

    $btnDestory.on('click', function () {
        $volumeForm.attr('action', 'volumes/delete');
        $volumeForm.submit();
    });

});