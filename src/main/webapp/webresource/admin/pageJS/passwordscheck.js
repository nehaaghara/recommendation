/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {  
$('#password').keyup(function() {
    $('#passwordCheckResult').html(checkStrength($('#password').val()));
});

function checkStrength(password) {
var strength = 0;
if (password.length < 6) {
$('#passwordCheckResult').removeClass();
$('#passwordCheckResult').addClass('short');
return 'Too short';
}
if (password.length > 7) strength += 1;
// If password contains both lower and uppercase characters, increase strength value.
if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1;
// If it has numbers and characters, increase strength value.
if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1;
// If it has one special character, increase strength value.
if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
// If it has two special characters, increase strength value.
if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
// Calculated strength value, we can return messages
// If value is less than 2
if (strength < 2) {
$('#passwordCheckResult').removeClass();
$('#passwordCheckResult').addClass('weak');
return 'Weak';
} else if (strength == 2) {
$('#passwordCheckResult').removeClass();
$('#passwordCheckResult').addClass('good');
return 'Good';
} else {
$('#passwordCheckResult').removeClass();
$('#passwordCheckResult').addClass('strong');
return 'Strong';
}
}
});

function checkRePassword(){
    $('#retypePasswordCheckResult').html('');
    var password = $('#password').val();
    var rePassword = $('#retypePassword').val();
    if(password == null || password === ''){
       $('#retypePasswordCheckResult').removeClass();
       $('#retypePasswordCheckResult').addClass('good'); 
       $('#retypePasswordCheckResult').html('First Insert Main Password.');
    }
    else if(rePassword !== password){
       $('#retypePasswordCheckResult').removeClass();
       $('#retypePasswordCheckResult').addClass('short');
       $('#retypePasswordCheckResult').html('Your <b>Retype Password</b> is incorrect.');
    }else{
        $('#retypePasswordCheckResult').removeClass();
        $('#retypePasswordCheckResult').addClass('strong');
        $('#retypePasswordCheckResult').html('Correct!');
    }
}

