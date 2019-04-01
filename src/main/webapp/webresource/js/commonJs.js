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
});

function emptyCheck(e) {
    if ($(e).val() == '') {
        addErrormessage($(e).attr('id'), 'Required');
        return false;
    }
    return true;
}

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

function numericValidate(id) {
    $('#' + id).parent().parent().find('label').find('span').html('');
    var val = $('#' + id).val();
    var message = " Must be Number <span style='color:green;'>[0-9]</span>";
    if (!/^[0-9]+$/.test(val)) {
        $('#' + id).val("");
        $('<span class="error">' + message + '</span>').appendTo($('#' + id).parent().parent().find("label"));
        return false;
    } else {
        val;
        return true;
    }
}

function alphanumericValidate(id)
{
    $('#' + id).parent().parent().find('label').find('span').html('');
    var val = $('#' + id).val();
    var message = " Must be Alphanumeric <span style='color:green;'>[A-Z,a-z,0-9]</span>";
    var letterNumber = /^[0-9a-zA-Z]+$/;
    if (val.match(letterNumber)) {
        val;
        return true;
    } else
    {
        $('#' + id).val("");
        $('#' + id).focus();
        $('<span class="error">' + message + '</span>').appendTo($('#' + id).parent().parent().find("label"));
        return false;
    }
}


function validate(e) {
    var validations = $(e).attr('validator');
    var validArr = validations.split(",");
    for (var i = 0; i < validArr.length; i++) {
        if (validArr[i].indexOf("required") != -1) {
            if (!emptyCheck(e)) {
                break;
            }
        }
        if (validArr[i].indexOf("alphanum") != -1) {
            if (!alphanumericValidate($(e).attr('id'))) {
                break;
            }
        }
        if (validArr[i].indexOf("numeric") != -1) {
            if (!numericValidate($(e).attr('id'))) {
                break;
            }
        }
        if (validArr[i].indexOf("alphabetic") != -1) {
            if (!alphabaticValidate($(e).attr('id'))) {
                break;
            }
        }
         if (validArr[i].indexOf("email") != -1) {
            if (!emailValidation($(e).attr('id'))) {
                break;
            }
        }
    }
}

function emailValidation(id){
     var val = $('#' + id).val();
     var validMailFormat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
     var message  =  " Please Enter correct Mail Id Format";
  
     if(val==validMailFormat){
         val;
         return true;
     }else{
         $('#' + id).val("");
        $('#' + id).focus();
        $('<span class="error">' + message + '</span>').appendTo($('#' + id).parent().parent().find("label"));
        return false;
     }
    
}