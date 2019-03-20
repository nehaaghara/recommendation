/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitLogin(){
     $('.error').remove();
    var errorCount=0;
    if($('#emailAddress').val()==''){
        errorCount++;
        addErrormessage('emailAddress','Required');
    }
    if($('#password').val()==''){
        errorCount++;
        addErrormessage('password','Required');
    }
    if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

