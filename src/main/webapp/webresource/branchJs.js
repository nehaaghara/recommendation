/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitBranch(){
      $('.error').remove();
     var errorCount = 0;
    if ($('#branchName').val() == '') {
        errorCount++;
        addErrormessage('branchName', 'Required');
    } else {
        if (!alphabaticValidate('branchName')) {
            errorCount++;
        }
    }
        if (parseInt(errorCount) > 0) {
            return false;
        } else {
            return true;
        }
}
