function submitProfile() {
    $('.error').remove();
    var errorCount = 0;


    if ($('#fullname').val() == '') {
        errorCount++;
        addErrormessage('fullname', 'Required');
    } else {
        if (!alphabaticValidate('fullname')) {
            errorCount++;
        }
    }

     if ($('#userName').val() == '') {
        errorCount++;
        addErrormessage('userName', 'Required');
    } else {
        if (!alphanumericValidate('userName')) {
            errorCount++;
        }
    }

//    if ($('#email_address').val() == '') {
//        errorCount++;
//        addErrormessage('email_address', 'Required');
//    } else {
//        if (!emailValidation('email_address')) {
//            errorCount++;
//        }
//    }
    
      if ($('#emailAddress').val() == '') {
        errorCount++;
        addErrormessage('emailAddress', 'Required');
    } 
   

    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}
