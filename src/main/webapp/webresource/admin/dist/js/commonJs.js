/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var requiredMessage = " is Required";
function addErrormessage(id, validation) {
    if (validation == 'Required') {
        addRequiredMessage(id);
    }
}
function addRequiredMessage(id) {
    $('#' + id).parent().parent().find('label').find('span').html('');
    $('<span class="error">' + requiredMessage + '</span>').appendTo($('#' + id).parent().parent().find("label"));
}

$(document).ready(function () {
    $('#SuccessMessage').delay(1000).fadeOut();
    $('#DeleteMessage').delay(1000).fadeOut();
    $('#UpdateMessage').delay(1000).fadeOut();
});

function alphabaticValidate(id)
{
    var val = $('#' + id).val();
    var message = " Must be Alphabatic <span style='color:green;'>[A-Z,a-z]</span>";
    if (!val.match(/^[a-zA-Z ]+$/))
    {
        $('#' + id).val("");
        $('#' + id).focus();
        $('<span class="error">' + message + '</span>').appendTo($('#' + id).parent().parent().find("label"));
        return false;
    } else {
        val;
        return true;
    }
}

