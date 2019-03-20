/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function submitAgency(){
      $('.error').remove();
    var errorCount=0;
     if($('#schemeAgencyId').val()==''){
        errorCount++;
        addErrormessage('schemeAgencyId','Required');
    }else {
        if (!numericValidate('schemeAgencyId')) {
            errorCount++;
        }
    }
    if($('#schemeAgencyName').val()==''){
        errorCount++;
        addErrormessage('schemeAgencyName','Required');
    }else{
         if (!alphabaticValidate('schemeAgencyName')) {
            errorCount++;
        }
    }
    
     if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

