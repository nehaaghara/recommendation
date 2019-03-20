/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var partyIdentificationRowCount = 1;
var partyLegalEntityRowCount = 1;
var partyTaxSchemeCount = 1;
var countLegal = 1;
$(function () {
    $(".select2").select2();
});
//JS FOR "ADD BUTTON"
function fnAddPartyIdentifictionRow() {
    
    if($('#partyIdentificationRowCount').attr('value') > 1){         
        partyIdentificationRowCount =$('#partyIdentificationRowCount').attr('value');
      }
    
    $('.error').remove();
    var errorCount = 0;
    if ($('#partyIdentificationdocumnet' + partyIdentificationRowCount).val() == null || $('#txtPartyIdentificationValue' + partyIdentificationRowCount).val() == '') {
        errorCount++;
        if ($('#partyIdentificationdocumnet' + partyIdentificationRowCount).val() == null) {
            addErrormessage('partyIdentificationdocumnet' + partyIdentificationRowCount, 'Required');
        }
        if ($('#txtPartyIdentificationValue' + partyIdentificationRowCount).val() == '') {
            addErrormessage('txtPartyIdentificationValue' + partyIdentificationRowCount, 'Required');
        }

    } else {
        partyIdentificationRowCount++;
        var div1 = $('<div class="row" id="dvpartyIds' + partyIdentificationRowCount + '"></div>').appendTo('#dvpartyIds');
        var div2 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div3 = $('<div class="form-group"></div>').appendTo(div2);

        $('<label for="partyIdentificationdocumnet">Select Party Identification Document</label>').appendTo(div3);
        var select1 = $('<select id="partyIdentificationdocumnet' + partyIdentificationRowCount + '"  path="partyidentifydetails[' + (partyIdentificationRowCount - 1) + '].identificationFK" title="Party Identification Document" name="partyidentifydetails[' + (partyIdentificationRowCount - 1) + '].identificationFK" class="form-control select2" onchange="DrpIdentificationvalChange(this);partyDocChange(this);" style="width: 100%;"></select>').appendTo(div3);
        $(select1).append($('#partyIdentificationdocumnet1').html());
        $(select1).val('-1');
        var div4 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div5 = $('<div class="form-group"></div>').appendTo(div4);

        $('<label for="partyIdentificationValue">Party Identification Value</label>').appendTo(div5);
        $('<input path="partyidentifydetails[' + (partyIdentificationRowCount - 1) + '].identificationValue" class="form-control" name="partyidentifydetails[' + (partyIdentificationRowCount - 1) + '].identificationValue" title="Party Identification Document value"  id="txtPartyIdentificationValue' + partyIdentificationRowCount + '" placeholder="Enter Party Identification Value" onclick="submitVal();">').appendTo(div5);
        var div6 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div7 = $('<div class="form-group"></div>').appendTo(div6);

        $('<br>').appendTo(div7);
        $('<button type="button" class="btn btn-primary" onclick="fnDeletePartyIdentificationRow(' + partyIdentificationRowCount + ')">Delete</button>').appendTo(div7);

        $('#partyIdentificationdocumnet' + partyIdentificationRowCount).select2();
        countLegal++;
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }

}

function fnAddPartyLegalEntity() {
    if($('#partyNameRowCount').attr('value') > 1){
        partyLegalEntityRowCount =$('#partyNameRowCount').attr('value');
    }
    $('.error').remove();
    var errorCount = 0;
    if ($('#txtPartyName' + partyLegalEntityRowCount).val() == '') {
        errorCount++;
        addErrormessage('txtPartyName' + partyLegalEntityRowCount, 'Required');
       } else {
        partyLegalEntityRowCount++;
        var div1 = $('<div class="row" id="dvpartyLegalEntity' + partyLegalEntityRowCount + '"></div>').appendTo('#dvpartyLegalEntities');
        var div2 = $('<div class="col-md-8"></div>').appendTo(div1);
        var div3 = $('<div class="form-group"></div>').appendTo(div2);
        $('<label>Party Name</label>').appendTo(div3);
        $('<input type="text" class="form-control" path="partynamedetails[' + (partyLegalEntityRowCount - 1) + '].partyName" id="txtPartyName' + partyLegalEntityRowCount + '" name="partynamedetails[' + (partyLegalEntityRowCount - 1) + '].partyName" title="Party Name" placeholder="Enter Party Name" />').appendTo(div3);
        var div6 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div7 = $('<div class="form-group"></div>').appendTo(div6);
        $('<br/>').appendTo(div7);
        $('<button type="button" class="btn btn-primary" onclick="fnDeletePartyLegalEntity(' + partyLegalEntityRowCount + ')">Delete</button>').appendTo(div7);
        
//        var mainDiv = document.getElementById("dvpartyLegalEntities");
//        var newDiv = document.createElement('div');
//        newDiv.className = "row";
//        newDiv.id = "dvpartyLegalEntity"+partyLegalEntityRowCount;
//        newDiv.innerHTML = '<div class="col-md-8"><div class="form-group"><label for="partynamedetails['+(partyLegalEntityRowCount - 1)+'].partyName">Party Name</label><input id="txtPartyName'+partyLegalEntityRowCount+'" name="partynamedetails['+(partyLegalEntityRowCount - 1)+'].partyName" title="Party Name '+(partyLegalEntityRowCount-1)+'" placeholder="Enter Party Name" class="form-control" type="text" value=""/><span for="partynamedetails['+(partyLegalEntityRowCount - 1)+'].partyName" class="help-block"></span></div></div><div class="col-md-4"><div class="form-group"><br/><button type="button" class="btn btn-primary" onclick="fnAddPartyLegalEntity()">Delete</button></div></div>';
//        mainDiv.appendChild(newDiv);
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}

function fnAddPartyTaxSchemeRow() {
     if($('#partyTaxSchemeRowCount').attr('value') > 1){         
        partyTaxSchemeCount =$('#partyTaxSchemeRowCount').attr('value');
      }
    $('.error').remove();
    var errorCount = 0;
    if ($('#optTaxLevelCode' + partyTaxSchemeCount).val() == null) {
        errorCount++;
        addErrormessage('optTaxLevelCode' + partyTaxSchemeCount, 'Required');
    } 
    else {
        partyTaxSchemeCount++;
        var div1 = $('<div class="row" id="dvpartyTaxSchemes' + partyTaxSchemeCount + '"></div>').appendTo('#dvpartyTaxSchemes');
        var div2 = $('<div class="col-md-8"></div>').appendTo(div1);
        var div3 = $('<div class="form-group"></div>').appendTo(div2);
        $('<label>Select Tax Level Code</label>').appendTo(div3);
        var select1 = $('<select name="taxcodedetails['+(partyTaxSchemeCount-1)+'].taxlevelCodeFK" title="Tax Level Code" class="form-control select2" id="optTaxLevelCode' + partyTaxSchemeCount + '" style="width: 100%;" onchange="DrpPartyTaxLevelCodeChange(this)"></select>').appendTo(div3);
        // path="taxcodedetails['+(partyTaxSchemeCount-1)+'].taxlevelCodePK"
        $(select1).append($('#optTaxLevelCode'+(partyTaxSchemeCount-1)).html());
        $(select1).val('-1');
        var div6 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div7 = $('<div class="form-group"></div>').appendTo(div6);
        $('<br>').appendTo(div7);
        $('<button type="button" class="btn btn-primary" onclick="fnDeletePartyTaxLevelCodeRow('+partyTaxSchemeCount+')">Delete</button>').appendTo(div7);
        $('#optTaxLevelCode' + partyTaxSchemeCount).select2();
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}
   
                //JS FOR "DELETE BUTTON"
function fnDeletePartyLegalEntity(partyLegalEntityRowCount) {
    $('#dvpartyLegalEntity' + partyLegalEntityRowCount).remove();
    partyLegalEntityRowCount--;
    $('#partyNameRowCount').attr("value",partyLegalEntityRowCount);
}

function fnDeletePartyIdentificationRow(partyIdentificationRowCount) {
    $('#dvpartyIds' + partyIdentificationRowCount).remove();
    partyIdentificationRowCount--;
    $('#partyIdentificationRowCount').attr("value",partyIdentificationRowCount);
}

function fnDeletePartyTaxLevelCodeRow(partyTaxSchemeCount) {
    $('#dvpartyTaxSchemes' + partyTaxSchemeCount).remove();
    partyTaxSchemeCount--;
    $('#partyTaxSchemeRowCount').attr("value",partyTaxSchemeCount);
    
}

                //JS FOR "CHANGE IN DROP DOWN"

function DrpIdentificationvalChange(ctrl) {
    var count = 0;
    var selectedVal = $(ctrl).children("option:selected").val();
    $('[id^=partyIdentificationdocumnet]').each(function () {

        if (selectedVal == $(this).children("option:selected").val()) {
            count++;
        }
    });
    if (count > 1) {
        $(ctrl).val('-1');
        $(ctrl).select2();
        $(ctrl).siblings('.select2-container--default').css('border', '2px solid #f37f7f');
    } else {
        $(ctrl).siblings('.select2-container--default').css('border', '');
    }
}

function DrpPartyTaxLevelCodeChange(ctrl) {
    var count = 0;
    var selectedVal = $(ctrl).children("option:selected").val();
    $('Select[id^=optTaxLevelCode]').each(function () {
        if (selectedVal == $(this).children("option:selected").val()) {
            count++;
        }
    });
  if (count > 1) {
        $(ctrl).val('-1');
        $(ctrl).select2();
        $(ctrl).siblings('.select2-container--default').css('border', '2px solid #f37f7f');
    } else {
        $(ctrl).siblings('.select2-container--default').css('border', '');
    }
}

                       // JS FOR "COUNTRY AND STATE" 
function submitCountry() {
    var id = $("#country").val();
    if (id !== "-1") {
        document.getElementById("state").disabled = false;
        id = $("#country").val();
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
            }
        });
    } else {
        $('#state').find("option[value!=-1]").remove();
        document.getElementById("state").disabled = true;
    }

}

function submitState() {
    var id = -1;
    if ($("#state").val() !== "-1") {
        document.getElementById("city").disabled = false;
        id = $("#state").val();
        $.ajax({
            url: path + '/party/viewStateCity',
            type: "POST",
            data: {'state': id},
            success: function (result) {
                var cityJson = JSON.parse(result);
                bindCityDropDown(cityJson);
            },
            error: function (error) {
                alert(error);
            }
        });
    } else {
        $('#city').find("option[value!=-1]").remove();
        document.getElementById("city").disabled = true;
    }
}


function bindStateDropdown(stateJson) {
    $('#state').find("option[value!=-1]").remove();
    $('#city').find("option[value!=-1]").remove();
    $.each(stateJson, function (index, object) {
        $('#state').append('<option value=' + object['countrysubentityPK'] + '>' + object['countrysubentityName'] + '</option>');
    });
}

function bindCityDropDown(cityJson) {
    $('#city').find("option[value!=-1]").remove();
    $.each(cityJson, function (index, object) {
        $('#city').append('<option value=' + object['cityPk'] + '>' + object['cityName'] + '</option>');
    });
}


                     // JS FOR "Party Identify Doc"
function submitVal() {
    $('.error').remove();
    var errorCount = 0;
    if ($('#partyIdentificationdocumnet' + countLegal).val() == '-1') {
        errorCount++;
        addErrormessage('partyIdentificationdocumnet' + countLegal, 'Required');
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}

function partyDocChange(ctrl) {
    if ($(ctrl).val() != '-1') {
        $(ctrl).siblings('.error').remove();
    }
}

