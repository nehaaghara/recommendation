/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function submitCategory() {
    $('.error').remove();
    var errorCount = 0;

    if ($('#categoryName').val() == '') {
        errorCount++;
        addErrormessage('categoryName', 'Required');
    } else {
        if (!alphabaticValidate('categoryName')) {
            errorCount++;
        }
    }

    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}
