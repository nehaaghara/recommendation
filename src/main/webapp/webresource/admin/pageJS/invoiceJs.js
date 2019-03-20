/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    
    $('.amount').on('keydown keyup', function (e) {
        if (!(e.keyCode >= 96 && e.keyCode <= 105) && e.keyCode !== 46 && e.keyCode > 31 && (e.keyCode < 48 || e.keyCode > 57) && (e.keyCode !== 189) && (e.keyCode !== 17) && (e.keyCode !== 67) && (e.keyCode !== 86) && (e.keyCode !== 37) && (e.keyCode !== 39) && (e.keyCode !== 109) && (e.keyCode !== 110)) {
            e.preventDefault();
            return false;
        }else{
            if(e.keyCode ==110 && this.value.indexOf('.')!==-1){
                e.preventDefault();
                return false;
            }else{
                
                calculateLegalMonetory();
            }
            
        }
    });
    
    $('.numeric').on('keydown keyup', function (e) {
//        /console.log(e.keyCode);
        if (!(e.keyCode >= 96 && e.keyCode <= 105) && e.keyCode !== 46 && e.keyCode > 31 && (e.keyCode < 48 || e.keyCode > 57) && (e.keyCode !== 189) && (e.keyCode !== 17) && (e.keyCode !== 67) && (e.keyCode !== 86) && (e.keyCode !== 37) && (e.keyCode !== 39) && (e.keyCode !== 109) && (e.keyCode !== 110)) {
            e.preventDefault();
            return false;
        }else{
            if( isNaN( parseFloat( this.value ) ) ) {
                $(this).parent().parent().next().next().find('.numeric').val(0);
                return;
            }
            if(e.keyCode ==110 && this.value.indexOf('.')!==-1){
                e.preventDefault();
                return false;
            }
            var tax = (checkNumericValue($(this).parent().parent().next().find('.percent').val())*checkNumericValue($(this).val()))/100;
            $(this).parent().parent().next().next().find('.numeric').val(roundup(tax));
            calculateLegalMonetory();
        }
    });
    
   
    $('.percent').on('keydown keyup', function( e ){
        //console.log(e.keyCode);
        if (!(e.keyCode >= 96 && e.keyCode <= 105) && e.keyCode !== 46 && e.keyCode > 31 && (e.keyCode < 48 || e.keyCode > 57) && (e.keyCode !== 189) && (e.keyCode !== 17) && (e.keyCode !== 67) && (e.keyCode !== 86) && (e.keyCode !== 37) && (e.keyCode !== 39) && (e.keyCode !== 109) && (e.keyCode !== 110)) {
            e.preventDefault();
            return false;
        }else{
            if( isNaN( parseFloat( this.value ) ) ) {
                $(this).parent().parent().next().find('.numeric').val(0);
                return;
            }
            if(e.keyCode ==110 && this.value.indexOf('.')!==-1){
                e.preventDefault();
                return false;
            }
            if(parseFloat(this.value)>100){
                e.preventDefault();
                $(this).val(100);
                return false;
            }else{
                var tax = (checkNumericValue($(this).parent().parent().prev().find('.numeric').val())*checkNumericValue($(this).val()))/100;
                $(this).parent().parent().next().find('.numeric').val(roundup(tax));
                calculateLegalMonetory();
            }
        }
//        else{
//            $(this).val(parseFloat(this.value).toFixed(2));
//        }
    });
   fnInitTaxable();
});

function fnInitTaxable(){
    $('.taxableamount').on('keydown keyup', function (e) {
        if (!(e.keyCode >= 96 && e.keyCode <= 105) && e.keyCode !== 46 && e.keyCode > 31 && (e.keyCode < 48 || e.keyCode > 57) && (e.keyCode !== 189) && (e.keyCode !== 17) && (e.keyCode !== 67) && (e.keyCode !== 86) && (e.keyCode !== 37) && (e.keyCode !== 39) && (e.keyCode !== 109) && (e.keyCode !== 110)) {
            e.preventDefault();
            return false;
        }else{
            if(e.keyCode ==110 && this.value.indexOf('.')!==-1){
                e.preventDefault();
                return false;
            }else{
                var main=this.value;
                if(!isNaN(parseFloat(main))){
                    $(this).parent().parent().parent().find('div[id^="dvTaxDetails"]').each(function(i,obj){
                        var value = (checkNumericValue($(obj).find('.taxpercent').val())*checkNumericValue(main))/100;
                        $(obj).find('.numeric').val(roundup(value));
                    });
                }else{
                    $(this).parent().parent().parent().find('div[id^="dvTaxDetails"]').each(function(i,obj){
                        $(obj).find('.numeric').val(0);
                    });
                    return;
                }
            }
        }
    });
    $('.taxpercent').on('keydown keyup', function( e ){
        //console.log(e.keyCode);
        if (!(e.keyCode >= 96 && e.keyCode <= 105) && e.keyCode !== 46 && e.keyCode > 31 && (e.keyCode < 48 || e.keyCode > 57) && (e.keyCode !== 189) && (e.keyCode !== 17) && (e.keyCode !== 67) && (e.keyCode !== 86) && (e.keyCode !== 37) && (e.keyCode !== 39) && (e.keyCode !== 109) && (e.keyCode !== 110)) {
            e.preventDefault();
            return false;
        }else{
            if( isNaN( parseFloat( this.value ) ) ) {
                $(this).parent().parent().next().find('.numeric').val(0);
                return;
            }
            if(e.keyCode ==110 && this.value.indexOf('.')!==-1){
                e.preventDefault();
                return false;
            }
            if(checkNumericValue(this.value)>100){
                e.preventDefault();
                $(this).val(100);
                return false;
            }else{
                var tax = (checkNumericValue($(this).parent().parent().parent().parent().find('.taxableamount').val())*checkNumericValue($(this).val()))/100;
                $(this).parent().parent().next().find('.numeric').val(roundup(tax));
                calculateLegalMonetory();
            }
        }

    });
}

function calculateLegalMonetory(){
    calculateTaxExclusive();
    calculateTaxInclusive();
    calculateChargeTotalAmount();
    $('#txtPayableAmount').val(roundup($('#txtPaymentAmounts').val()));
    $('#txtLegalLineExtensionAmount').val(roundup($('#txtLineExtensionAmount').val()));
}

function calculateTaxExclusive(){
    var taxExclusiveAmount = 0 ; 
    $('.taxExclusive').each(function(){
        taxExclusiveAmount= checkNumericValue(taxExclusiveAmount) + checkNumericValue($(this).val());
    });
    $('#txtTaxExclusiveAmount').val(roundup(taxExclusiveAmount));
}
function calculateTaxInclusive(){
    var taxInclusiveAmount = 0 ; 
    taxInclusiveAmount = checkNumericValue($('#txtLegalLineExtensionAmount').val()) + checkNumericValue($('#txtTaxExclusiveAmount').val());
    $('#txtTaxInclusiveAmount').val(roundup(taxInclusiveAmount));
}
function calculateChargeTotalAmount(){
    var chargeTotalAmount = 0;
    $('.chargeTotalAmount').each(function(){
        chargeTotalAmount=checkNumericValue(chargeTotalAmount)+checkNumericValue($(this).val());
    });
    $('#txtChargeTotalAmount').val(roundup(chargeTotalAmount));
}
function checkNumericValue(val){
    if( isNaN( parseFloat( val ) ) ) {
        return 0;
    }else{
        return parseFloat(val);
    }
}
function roundup(val){
    if( isNaN( parseFloat( val ) ) ) {
        return 0;
    }else{
        return parseFloat(val).toFixed(2);
    }
}
function fnAddNewTax(){
    var $div1 = $('div[id^="dvTaxDetails"]:last');
    var num = parseInt( $div1.prop("id").match(/\d+/g), 10 ) +1;
    console.log(num)
    var $klon = $('#dvTaxDetails1').clone().prop('id', 'dvTaxDetails'+num );
     $($div1).after( $klon );
    $klon.find('input[id^="txtInvoiceTaxPercent"]').prop('id','txtInvoiceTaxPercent'+num);
    $klon.find('input[id^="txtInvoiceTaxPercent"]').prop('name','invoiceTaxDetails['+(num-1)+'].percent');
    $klon.find('input[id^="txtInvoiceTaxPercent"]').val('0');
    $klon.find('input[id^="txtInvoiceTaxAmount"]').prop('id','txtInvoiceTaxAmount'+num).prop('name','invoiceTaxDetails['+(num-1)+'].taxAmount').val('0');
    $klon.find('input[id^="chkInvoiceTaxEvidenceIndicator"]').prop('id','chkInvoiceTaxEvidenceIndicator'+num).prop('name','invoiceTaxDetails['+(num-1)+'].taxEvidenceIndicator').prop('checked',false);
    $klon.find('select[id^="optInvoiceTaxScheme"]').prop('id','optInvoiceTaxScheme'+num).prop('name','invoiceTaxDetails['+(num-1)+'].taxSchemeFK');
    $klon.find('span[class^="select2 select2-container select2-container--default"]').remove();
    $('#optInvoiceTaxScheme'+num).val('-1');
    $('#optInvoiceTaxScheme'+num).select2();
    $klon.append('<div class="col-md-2"><br><button type="button" onclick="fnDeleteTax('+num+')" class="btn btn-danger"><i class="fa fa-times"></i></button></div>');
    fnInitTaxable();
    
}
function fnDeleteTax(count){
    $('#dvTaxDetails'+count).remove();
    calculateLegalMonetory();
}
function submitCountry() {
    ShowLoading();
    var id = $("#optDeliveryCountry").val();
    if (id !== "-1") {
        document.getElementById("optDeliveryState").disabled = false;
        id = $("#optDeliveryCountry").val();
        $.ajax({
            url: path + '/party/viewStateCity',
            type: "POST",
            data: {'country': id},
            success: function (result) {
                var stateJson = JSON.parse(result);
                bindStateDropdown(stateJson);
            },
            error: function (error) {
                console.log(error.responseText);
                hideLoading();
            }
        });
    } else {
        $('#optDeliveryState').find("option[value!=-1]").remove();
        document.getElementById("optDeliveryState").disabled = true;
        hideLoading();
    }
}

function submitState() {
    ShowLoading();
    var id = -1;
    if ($("#optDeliveryState").val() !== "-1") {
        document.getElementById("optDeliveryCity").disabled = false;
        id = $("#optDeliveryState").val();
        $.ajax({
            url: path + '/party/viewStateCity',
            type: "POST",
            data: {'state': id},
            success: function (result) {
                var cityJson = JSON.parse(result);
                bindCityDropDown(cityJson);
            },
            error: function (error) {
                console.log(error);
                hideLoading();
            }
        });
    } else {
        $('#optDeliveryCity').find("option[value!=-1]").remove();
        document.getElementById("optDeliveryCity").disabled = true;
        hideLoading();
    }
}


function bindStateDropdown(stateJson) {
    $('#optDeliveryState').find("option[value!=-1]").remove();
    $('#optDeliveryCity').find("option[value!=-1]").remove();
    $.each(stateJson, function (index, object) {
        $('#optDeliveryState').append('<option value=' + object['countrysubentityPK'] + '>' + object['countrysubentityName'] + '</option>');
    });
    hideLoading();
}

function bindCityDropDown(cityJson) {
    $('#optDeliveryCity').find("option[value!=-1]").remove();
    $.each(cityJson, function (index, object) {
        $('#optDeliveryCity').append('<option value=' + object['cityPk'] + '>' + object['cityName'] + '</option>');
    });
    hideLoading();
}

