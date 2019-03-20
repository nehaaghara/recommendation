/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function submitProduct() {
    $('.error').remove();
    var errorCount = 0;

    if ($('#categoryFK').val() == null) {
        errorCount++;
        addErrormessage('categoryFK', 'Required');
    }
    if ($('#productName').val() == '') {
        errorCount++;
        addErrormessage('productName', 'Required');
    } else if ($('#categoryFK').val() ==null) {
        errorCount++;
        addErrormessage('categoryFk', 'Required');
    } else {
        if (!alphabaticValidate('productName')) {
            errorCount++;
        }
    }

    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}
