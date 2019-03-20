/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitTaxScheme(){
     $('.error').remove();
    var errorCount=0;
    if($('#taxSchemeId').val()==''){
        errorCount++;
        addErrormessage('taxSchemeId','Required');
    }else{
        if (!numericValidate('taxSchemeId')) {
            errorCount++;
        }
    }
    if($('#taxSchemeName').val()==''){
        errorCount++;
        addErrormessage('taxSchemeName','Required');
    }else{
        if (!alphabaticValidate('taxSchemeName')) {
            errorCount++;
        }
    }
    
     if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

