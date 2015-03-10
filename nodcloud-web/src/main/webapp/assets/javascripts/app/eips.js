$(function() {

    var $instances = $("#associate-availiable-instances");
    var $btnassociate = $("#btn-associate");
    var $btnReleaseEips = $("#btn-release-eips");
    var $btnDissociateEips = $("#btn-dissociate-eips");

    var $eipForm = $("#eipForm");

    var $instanceTarget = $("#AssociateeTarget");
    var instanceTarget;

    $.ajax({

        url: '../api/secure/resources/associate/available',
        method: 'GET',
        success: function (result, statusText, jqXhr) {
            $instances.empty();
            for(var i=0; i<result.length; i++) {
                var item = result[i];
                $instances.append('<option value="'+item.id+'">'+item.name+'( '+item.uuid+' )</option>')

            }
        }

    });

    $btnReleaseEips.bind("click", function() {

        $eipForm.attr("action", "eips/releaseEip");
        $eipForm.submit();

    });

    $btnDissociateEips.bind("click", function() {

        $eipForm.attr("action", "eips/dissociateEip");
        $eipForm.submit();

    });

    function associate() {
        $eipForm.attr("action", "eips/associate");
        $eipForm.submit();
    }

    $("table .checkbox").on("click", function () {
        var checked = $(this).closest("table").find(":checkbox").filter(":checked");
        var num = checked.length;
        console.log(checked);
        if (num === 1) {

            $btnReleaseEips.removeAttr("disabled");
            $btnassociate.removeAttr("disabled");
            $btnDissociateEips.removeAttr("disabled");
            $instanceTarget.attr("value", checked.attr('value'));

        } else if (num >1) {

            $btnassociate.attr("disabled", "disabled");
            $btnReleaseEips.removeAttr("disabled");
            $btnDissociateEips.removeAttr("disabled");

        }else {
            $btnassociate.attr("disabled", "disabled");
            $btnReleaseEips.attr("disabled", "disabled");
            $btnDissociateEips.attr("disabled", "disabled");
        }
    });

});