/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitSoftware() {
    $('.error').remove();
    var errorCount = 0;

    if ($('#resolutionDate').val() == '') {
        errorCount++;
        addErrormessage('resolutionDate', 'Required');
    }
    if ($('#prefix').val() == '') {
        errorCount++;
        addErrormessage('prefix', 'Required');
    } else {
        if (!alphanumericValidate('prefix')) {
            errorCount++;
        }
    }
    if ($('#rangeStart').val() == '') {
        errorCount++;
        addErrormessage('rangeStart', 'Required');
    } else {
        if (!numericValidate('rangeStart')) {
            errorCount++;
        }
    }
    if ($('#rangeEnd').val() == '') {
        errorCount++;
        addErrormessage('rangeEnd', 'Required');
    } else if (!numericValidate('rangeEnd')) {
        errorCount++;
    } else {
        if (!compareTwoNumbers('rangeStart', 'rangeEnd')) {
            errorCount++;
        }
    }
    if ($('#technicalKey').val() == '') {
        errorCount++;
        addErrormessage('technicalKey', 'Required');
    }
    if ($('#startDateValidity').val() == '') {
        errorCount++;
        addErrormessage('startDateValidity', 'Required');
    }
    if ($('#endDateValidity').val() == '') {
        errorCount++;
        addErrormessage('endDateValidity', 'Required');
    }
    if ($('#resolutionNumber').val() == '') {
        errorCount++;
        addErrormessage('resolutionNumber', 'Required');
    } else {
        if (!numericValidate('resolutionNumber')) {
            errorCount++;
        }
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}

$('#endDateValidity').change(function () {
    $('.error').remove();
    var errorCount = 0;
    var message = " Must Be Greater Than Start Date";
    var startDate = $('#startDateValidity').val();
    var endDate = $('#endDateValidity').val();
    if (!(Date.parse(startDate) <= Date.parse(endDate))) {
        errorCount++;
        $('#endDateValidity').val("");
        $('<span class="error">' + message + '</span>').appendTo($('#endDateValidity').parent().parent().find("label"));
    } else {
        $('#endDateValidity').val();
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
});



