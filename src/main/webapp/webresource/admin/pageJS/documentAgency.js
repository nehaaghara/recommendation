/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitDocuments(){
     $('.error').remove();
    var errorCount=0;
    if($('#identificationDocumentsId').val()==''){
        errorCount++;
        addErrormessage('identificationDocumentsId','Required');
    }else {
        if (!alphanumericValidate('identificationDocumentsId')) {
            errorCount++;
        }
    }
    if($('#identificationDocumentsDesc').val()==''){
        errorCount++;
        addErrormessage('identificationDocumentsDesc','Required');
    }else {
        if (!alphabaticValidate('identificationDocumentsDesc')) {
            errorCount++;
        }
    }
    
     if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

