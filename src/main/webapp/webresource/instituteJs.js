/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var branch = 1;
var countLegal = 1;


function fnAddBranchRow() {
    branch++;
    var div1 = $('<div class="row" id="dvbranchIds' + branch + '" style="margin: -12px -30px;"></div>').appendTo('#dvbranchIds');
    var div2 = $('<div class="col-md-10"></div>').appendTo(div1);
    var div3 = $('<div class="form-group"></div>').appendTo(div2);
    $('<label for="branchFK">Select Branch</label>').appendTo(div3);
    var select1 = $('<select id="branchFk' + branch + '"  path="branches[' + (branch - 1) + ']" title="Branch" name="branches[' + (branch - 1) + ']" class="form-control select2" onchange="DrpBrannchChange(this);" style="width: 100%;"></select>').appendTo(div3);
    $(select1).append($('#branchFk1').html());
    $(select1).val('-1');
    var div4 = $('<div class="col-md-1"></div>').appendTo(div1);
    var div5 = $('<div class="form-group"></div>').appendTo(div4);
    $('<br>').appendTo(div5);
    $('<button type="button" class="btn btn-primary" onclick="fnDeleteBranch(' + branch + ')" style="margin:7px 0px 2px;"><i class="fa fa-close"></i></button>').appendTo(div5);
    countLegal++;

}

function fnDeleteBranch(branch) {
    $('#dvbranchIds' + branch).remove();
    branch--;
    $('#branch').attr("value", branch);
}

function DrpBrannchChange(ctrl) {
    debugger;
    var count = 0;
    var selectedVal = $(ctrl).children("option:selected").val();
    $('[id^=branchFk]').each(function () {

        if (selectedVal == $(this).children("option:selected").val()) {
            count++;
        }
    });
    if (count > 1) {
        $(ctrl).val('-1');
        alert("Already Selected Please Select Another Value");
        $(ctrl).siblings('.form-control select2').css('border', '2px solid red');

    } else {
        $(ctrl).siblings('.form-control select2').css('border', '');
    }
}


