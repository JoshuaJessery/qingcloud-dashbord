$(function () {

    "use strict";
    var $instanceForm = $("#instanceForm");
    var $resizeInstanceForm = $("#resize-instances form");
    var $dataTableInstance = $("#dataTableInstance");

    var $startBtn = $("#btn-start-instance");
    var $stopBtn = $("#btn-stop-instance");
    var $groupBtn = $("#btn-group");
    var $restartBtn = $("#btn-restart-instance");
    var $destoryBtn = $("#btn-destory-instance");
    var $resetBtn = $("#reset-form-btn");
    var $resizeBtn = $("a.resizeInstanceModel");
    var $resizeFormBtn = $("#resizeForm");
    var $resetInstanceForm = $("#resetInstanceForm");
    var $typesOptions = $(".types .types-item");
    var $cpuOptions = $(".types-options.cpu-options");
    var $memeryOptions = $(".types-options.memory-options ");
    var $resetLink = $("a.resetsInstanceModel");
    var $modifies = $("tr.gradeA.odd");

    init();

    $destoryBtn.on("click", function () {
        removeInstance();
    });

    $startBtn.on("click", function () {
        startInstance();
    });

    $stopBtn.on("click", function () {
        stopInstance();
    });

    $restartBtn.on("click", function () {
        var disable = $(this).attr("disabled");
        if(!disable) {
            restartInstance();
        }
    });

    $resizeBtn.on("click", function () {
        resizeInstancePre();
    });

    $resizeFormBtn.on("click", function () {
        resizeInstance();
    });

    $typesOptions.on("click", function () {
        itemsSelected($typesOptions, $(this), "typesOptions");
    });

    $cpuOptions.on("click", function () {
       itemsSelected($cpuOptions, $(this));
    });

    $memeryOptions.on("click", function () {
        itemsSelected($memeryOptions, $(this));
    })

    $resetLink.on("click", function () {
        resetInstancePre();
    })

    $resetBtn.on("click", function () {
        resetInstance();
    })

    $modifies.on("dblclick", function () {
        $.modifyInstance.modifyDBClick(this);
    })

    $("#modify-cancel,#modifyInstanceModel button[class=close]").on("click", function () {
        $.modifyInstance.closeAction();
    })

    $("#modify-form-btn").on("click", function () {
        $.modifyInstance.submit();
    });

    $("table .checkbox").on("click", function () {

        var instance_start_num = $(this).closest("table").find(":checked").parents("tr").find(".instance-running").length;
        var instance_disable_num = $(this).closest("table").find(":checked").parents("tr").find(".instance-disable").length;
        init();

        if(instance_start_num >= 1) {
            $startBtn.attr("disabled", "disabled");
        } else if(instance_disable_num >= 1) {
            $startBtn.removeAttr("disabled");
        }

        if(instance_disable_num >= 1) {
            $stopBtn.attr("disabled", "disabled");
        } else if(instance_start_num >= 1) {
            $stopBtn.removeAttr("disabled");
        }

        if(instance_disable_num >= 1 && instance_start_num == 0) {
            $resizeBtn.removeClass("disabled-link");
            if (!$resizeBtn.attr("data-toggle")) {
                $resizeBtn.attr("data-toggle", "modal");
            }
        } else {
            $resizeBtn.addClass("disabled-link");
            if ($resizeBtn.attr("data-toggle")) {
                $resizeBtn.removeAttr("data-toggle");
            }
        }

        if(instance_start_num == 0 && instance_disable_num == 0) {
            $startBtn.attr("disabled", "disabled");
            $stopBtn.attr("disabled", "disabled");
        }

        // restart instance设定
        if(instance_start_num >= 1 && instance_disable_num == 0) {
            $restartBtn.removeAttr("disabled");
            $restartBtn.removeClass("disabled-link")
        } else {
            $restartBtn.attr("disabled", "disabled");
            $restartBtn.addClass("disabled-link")
        }
        // reset instance
        if ((instance_start_num + instance_disable_num) > 0) {
            $resetLink.removeClass("disabled-link");
            if (!$resetLink.attr("data-toggle")) {
                $resetLink.attr("data-toggle", "modal");
            }
        } else {
            $resetLink.addClass("disabled-link");
            if ($resetLink.attr("data-toggle")) {
                $resetLink.removeAttr("data-toggle");
            }
        }
    });

    function init () {
        var $checkeds = $dataTableInstance.find(":checked");
        if ($checkeds.length >= 1) {
            $destoryBtn.removeClass("disabled-link");
        } else {
            $destoryBtn.addClass("disabled-link");
        }
    }

    function startInstance() {
        $instanceForm.attr("action", "instances/start");
        $instanceForm.submit();
    }

    function stopInstance() {
        $instanceForm.attr("action", "instances/stop");
        $instanceForm.submit();
    }

    function restartInstance() {
        $instanceForm.attr("action", "instances/restart");
        $instanceForm.submit();
    }

    function joinNetwork() {

    }

    function snapshotInstance() {

    }

    function resetInstance() {
        if (!$resetLink.hasClass("disabled-link")) {
            $resetInstanceForm.attr("action", "instances/reset")
            $resetInstanceForm.submit();
        }
    }

    function removeInstance() {
        if (!$destoryBtn.hasClass("disabled-link")) {
            $instanceForm.attr("action", "instances/delete");
            $instanceForm.submit();
        }
    }

    function resizeInstance () {
        $resizeInstanceForm.attr("action", "instances/resize");
        $resizeInstanceForm.submit();
    }
    function resizeInstancePre () {
        var $checkeds = $dataTableInstance.find(":checked");
        var $checkedStatus = $dataTableInstance.find(":checked").parents("td.instance-running").next().find("a");
        var $checkedNum = $dataTableInstance.find(":checked").parents("td").next().find("a");
        var instanceDisabled = "";
        var instanceNum = "";
        var hidden = "";
        /*防止重复*/
        $resizeInstanceForm.find("input[type='hidden'][name='id']").remove();
        if ($checkedStatus.length > 0) {
             for (var i=0; i<$checkedStatus.length; i++) {
                if(i == $checkedStatus.length - 1) {
                    instanceDisabled += $($checkedStatus[i]).text();
                } else {
                    instanceDisabled += $($checkedStatus[i]).text() + ", ";
                }
             }
            instanceDisabled = "[" + instanceDisabled + "]"; /*提示备用*/
        } else {
            for (var i=0; i < $checkedNum.length; i++) {
                hidden = "<input type='hidden' name='id' value='" + $($checkeds[i]).val() + "'>";
                if (i == $checkedNum.length - 1) {
                    instanceNum += $($checkedNum[i]).text();
                } else {
                    instanceNum += $($checkedNum[i]).text() + ", ";
                }
                $resizeInstanceForm.append(hidden);
            }
            instanceNum = "[" + instanceNum + "]";
            $("h4 span.id").empty();
            $("h4 span.id").text(instanceNum);
        }
    }

    function itemsSelected (items, target, type) {
        if (!$(target).hasClass("disabled")) {
            $(items).removeClass("selected");
            $(target).addClass("selected");

            if (type == "typesOptions") {
                typesMapping($(target).index());
            } else {
                $typesOptions.removeClass("selected");
            }
        }
        /*set cpu, memory*/
        $("#resize-instances form input[name='cup']").val($("#resize-instances form .types-options.cpu-options.selected").attr("data-value"));
        $("#resize-instances form input[name='memory']").val($("#resize-instances form .types-options.memory-options.selected").attr("data-value"));
    }

    function typesMapping (index) {

        var min = 0;
        var max = 0
        var def_idx = 0;
        var cpu_idx = 0;

        switch (index) {
            case 0 :
                def_idx = 0;
                max = 3;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 1 :
                def_idx = 1;
                max = 3;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 2 :
                def_idx = 2;
                max = 3;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 3 :
                cpu_idx = 1;
                def_idx = 2;
                min = 1;
                max = 5;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 4 :
                cpu_idx = 1;
                def_idx = 3;
                min = 1;
                max = 5;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 5 :
                cpu_idx = 1;
                def_idx = 5;
                min = 1;
                max = 5;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 6 :
                cpu_idx = 2;
                def_idx = 3;
                min = 2;
                max = 7;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 7 :
                cpu_idx = 2;
                def_idx = 5;
                min = 2;
                max = 7;
                typesOper(cpu_idx, min, max, def_idx);
                break;
            case 8 :
                cpu_idx = 2;
                def_idx = 7;
                min = 2;
                max = 7;
                typesOper(cpu_idx, min, max, def_idx);
                break;
        }
    }

    function typesOper (cpu_idx, min, max, def) {
        var mem_len = $memeryOptions.length;
        $memeryOptions.removeClass("disabled");
        $cpuOptions.removeClass("selected");
        $memeryOptions.removeClass("selected");
        $($cpuOptions[cpu_idx]).addClass("selected");
        $($memeryOptions[def]).addClass("selected");

        /*disabled memery*/
        for (var i=0; i < mem_len; i++) {
            if (i < min || i > max) {
                $($memeryOptions[i]).addClass("disabled");
            }
        }
    }

    function resetInstancePre () {
        var $checkeds = $dataTableInstance.find(":checked");
        var $instanceNums = $dataTableInstance.find(":checked").parents("td").next().find("a");
        var checksNum = "";
        $resetInstanceForm.find("input[type='hidden'][name='id']").remove();
        for (var i=0; i<$instanceNums.length; i++) {
            if (i == $instanceNums.length - 1) {
                checksNum += $($instanceNums[i]).text();
            } else {
                checksNum += $($instanceNums[i]).text() + ", ";
            }
            $resetInstanceForm.append("<input type='hidden' name='id' value='" +$($checkeds[i]).val()+ "'>");
        }
        checksNum = "[" + checksNum + "]";
        $("#reset_instances_uuids").empty();
        $("#reset_instances_uuids").text(checksNum);
    }

    /*modify instance*/
    $.modifyInstance = {
        VARIABLES : {
            BLOCK_DIV : "<div class='modal-backdrop fade in'></div>",
            UNHIDDEN_IN : "in",
            UNHIDDEN_BLOCK : "display:block",
            HIDDEN : "display:none",
            MODAL_ID : "#modifyInstanceModel",
            CANCEL_BTN : "#modify-cancel",
            MODIFY_SUBMIT : "#modify-form-btn",
            MODIFY_FORM : "#modifyInstanceForm",
            MODIFY_CONTENT_INPUT : "#modifyInstanceModel input[name=name], #modifyInstanceModel textArea",
            MODIFY_INPUT : "#modifyInstanceModel input[name=name]",
            MODIFY_DESCR : "#modifyInstanceModel textarea[name=descr]",
            MODIFY_TEXTAREA : "#modifyInstanceModel textArea",
            MODIFY_TITLE : "#modify_instances_attrs",
            MODIFY_INSTANCE : "#modifyInstanceModel input[name=id]",
            MODIFY_FORM_ACTION_URL : "instances/modify"
        },
        modifyDBClick : function (target) {
            var VARIABLES = this.VARIABLES;
            $($("body")[0]).append(VARIABLES.BLOCK_DIV);
            this.clear();
            this.init(target);
            $(VARIABLES.MODAL_ID).attr("style",VARIABLES.UNHIDDEN_BLOCK).addClass(VARIABLES.UNHIDDEN_IN);
            this.close();
        },
        init : function (target) {
          var VARIABLES = this.VARIABLES;
          var instanceName = $(target).find("td[name='instance-name']").html();
          $(VARIABLES.MODIFY_INPUT).val($.trim(instanceName));
          $(VARIABLES.MODIFY_DESCR).val($.trim($(target).find("td[name='instance-uuid']>input").val()));
          $(VARIABLES.MODIFY_INSTANCE).val($(target).attr("id"));
          $(VARIABLES.MODIFY_TITLE).text($(target).find("td[name='instance-uuid']").text());
        },
        clear : function () {
            $(this.VARIABLES.MODIFY_CONTENT_INPUT).val("");
        },
        close : function () {
            var VARIABLES = this.VARIABLES;
            var IS_HIDDEN = $(VARIABLES.MODAL_ID).hasClass(VARIABLES.UNHIDDEN_IN);

            $("body").on("click", function (event) {

                var $this = $(event.target);

                if ($this.parents(".modal-content").length > 0) {

                } else {
                    if ($(IS_HIDDEN)) {
                        $(VARIABLES.MODAL_ID).removeClass(VARIABLES.UNHIDDEN_IN).removeAttr("style");
                    }
                    $("body:first").find(".modal-backdrop").remove();
                }
            });
        },
        closeAction : function () {
            var VARIABLES = this.VARIABLES;
            var IS_HIDDEN = $(VARIABLES.MODAL_ID).hasClass(VARIABLES.UNHIDDEN_IN);
            if ($(IS_HIDDEN)) {
                $(VARIABLES.MODAL_ID).removeClass(VARIABLES.UNHIDDEN_IN).removeAttr("style");
            }
            $("body:first").find(".modal-backdrop").remove();
        },
        submit : function () {
            $(this.VARIABLES.MODIFY_FORM).attr("action", this.VARIABLES.MODIFY_FORM_ACTION_URL);
            $(this.VARIABLES.MODIFY_FORM).submit();
        }
    };
});

