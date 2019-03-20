/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function submitClient() {
    $('.error').remove();
     var errorCount = 0;
    if ($('#clientName').val() == '') {
        errorCount++;
        addErrormessage('clientName', 'Required');
    } else {
        if (!alphabaticValidate('clientName')) {
            errorCount++;
        }
    }
        if (parseInt(errorCount) > 0) {
            return false;
        } else {
            return true;
        }
    }

