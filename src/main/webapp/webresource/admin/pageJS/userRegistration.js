/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var requiredMessage = "is Required";
function submitRegister(){
    $('.error').remove();
    var errorCount=0;
    if($('#fullName').val()==''){
        errorCount++;
        addErrormessage('fullName',"Required");
    }
    if($('#email').val()==''){
        errorCount++;
        addErrormessage('email',"Required");
    }
    if($('#username').val()==''){
        errorCount++;
        addErrormessage('username',"Required");
    }
    if($('#password').val()==''){
        errorCount++;
        addErrormessage('password',"Required");
    }
    if($('#rePassword').val()==''){
        errorCount++;
        addErrormessage('rePassword',"Required");
    }
    if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

function submitOTPRegister(){ 
    $('.error').remove();
    var errorCount=0;
    if($('#otp').val()==''){
        errorCount++;
        addErrormessage('otp',"Required");
    }
    if(parseInt(errorCount)>0){
        return false;
    }else{
        return true;
    }
}

function signUpResponse(flag){
    if(flag !== 'register'){
       var json = JSON.parse(flag);
       if(json['isSuccess'] === 1){
            $('#textOTP').css("display", "block");
            $('#otpSentModel').css("display", "none"); 
            $('#responseReg').css("display", "block");
            $('#responseReg').html('<b>'+(json['successMessage']).split(',')[0]+'</b>').css('color','green');
            $('#form').attr('action', 'otpVerify');
            $('#form').attr('onsubmit', 'return submitOTPRegister();');
            $('#btnRegOtpsent').html('<b>Send</b><span class="glyphicon glyphicon-send pull-right"></span>');
       }else if(json['isSuccess'] === 0 && json['errorCode'] === 'DUPLICATEUNAME'){
            $('#responseReg').css("display", "block"); 
            $('#responseReg').html('<b>'+json['errorMessage']+'</b>').css('color','red');
       }else if(json['isSuccess'] === 0 && json['errorCode'] === 'WRONGOTP'){
            $('#textOTP').css("display", "block");
            $('#otpSentModel').css("display", "none"); 
            $('#responseReg').css("display", "block");
            $('#responseReg').css("display", "block"); 
            $('#responseReg').html('<b>'+json['errorMessage']+'</b>').css('color','red');
       }
       
    }     
}