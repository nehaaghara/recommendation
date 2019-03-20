/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var count = 1;
$(function () {
    $(".select2").select2();
});
function fnAddPartyIdentifictionRow() {
    
    $('.error').remove();
    var errorCount = 0;
    if ($('#partyIdentificationdocumnet' + count).val() == '-1' || $('#txtPartyIdentificationValue' + count).val() == '') {
        errorCount++;
        if ($('#partyIdentificationdocumnet' + count).val() == '-1') {
            addErrormessage('partyIdentificationdocumnet' + count, 'Required');
        }
        if ($('#txtPartyIdentificationValue' + count).val() == '') {
            addErrormessage('txtPartyIdentificationValue' + count, 'Required');
        }

    } else {
        count++;
        var div1 = $('<div class="row" id="dvpartyIds' + count + '"></div>').appendTo('#dvpartyIds');
        var div2 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div3 = $('<div class="form-group"></div>').appendTo(div2);
        var label1 = $('<label for="partyIdentificationdocumnet">Select Party Identification Document</label>').appendTo(div3);
        var select1 = $('<select  class="form-control select2" id="partyIdentificationdocumnet' + count + '" title = "Party Identification Document" onclick="submitDoc();" style="width: 100%;" ></select>').appendTo(div3);
        $(select1).append($('#partyIdentificationdocumnet1').html());        
        var div4 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div5 = $('<div class="form-group"></div>').appendTo(div4);
        var label2 = $('<label for="partyIdentificationValue">Party Identification Value</label>').appendTo(div5);
        var input1 = $('<input type="text" class="form-control" id="txtPartyIdentificationValue' + count + '" title="Party Identification Value" onclick="submitVal();" placeholder="Enter Party Identification Value">').appendTo(div5);
        var div6 = $('<div class="col-md-4"></div>').appendTo(div1);
        var div7 = $('<div class="form-group"></div>').appendTo(div6);
        var label3 = $('<br>').appendTo(div7);
        var input2 = $('<button type="button" class="btn btn-primary" id="delete' + count + '" onclick="fnDeletePartyIdentificationRow(' + count + ')">Delete</button>').appendTo(div7);
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}

function fnDeletePartyIdentificationRow(count) {
    $('#dvpartyIds' + count).remove();
}

function submitVal() {
    $('.error').remove();
    var errorCount = 0;
    if ($('#partyIdentificationdocumnet' + count).val() == '-1') {
        errorCount++;
        addErrormessage('partyIdentificationdocumnet' + count, 'Required');
    }
    if (parseInt(errorCount) > 0) {
        return false;
    } else {
        return true;
    }
}

function submitDoc() {
    if ($('#partyIdentificationdocumnet' + count).val() != '-1') {
        $('#partyIdentificationdocumnet' + count).siblings('.error').remove();
    }
}


