/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitTax(){
     $('.error').remove();
      var errorCount=0;
     if($('#taxlevelCode').val()==''){
        errorCount++;
        addErrormessage('taxlevelCode','Required');
    }else{
        if (!alphanumericValidate('taxlevelCode')) {
            errorCount++;
        }
    }
    if($('#taxlevelCodeName').val()==''){
        errorCount++;
        addErrormessage('taxlevelCodeName','Required');
    }else{
        if (!alphabaticValidate('taxlevelCodeName')) {
            errorCount++;
        }
    }
    
     if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

$("#successmsg").fadeIn('slow').delay(500).fadeOut('slow');
