/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitAccount() {
    $('.error').remove();
    var errorCount = 0;

    if ($('#additionalaccountID').val() == '') {
        errorCount++;
        addErrormessage('additionalaccountID', 'Required');
    } else {
        if (!numericValidate('additionalaccountID')) {
            errorCount++;
        }
    }
    if ($('#additionalaccountName').val() == '') {
        errorCount++;
        addErrormessage('additionalaccountName', 'Required');
    } else {
        if (!alphabaticValidate('additionalaccountName')) {
            errorCount++;
        }
    }

    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}


