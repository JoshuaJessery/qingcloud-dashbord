$(function () {

    "use strict";
    var $form = $("#keyPairForm");
    var $removeBtn = $("#btn-remove");
    var $groupBtn = $("#btn-group");

    $removeBtn.on('click', function () {
        remove();
    });

    $('table .checkbox').on('click', function () {

        var num = $(this).closest('table').find(':checkbox').filter(":checked").length;
        if (num >= 1) {
            $groupBtn.removeAttr("disabled");
        } else {
            $groupBtn.attr("disabled", "disabled");
        }
    });

    function remove() {
        $form.attr('action', 'keypairs/delete');
        $form.submit();
    }

});

