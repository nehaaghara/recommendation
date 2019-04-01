/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function submitInstitute() {
    var id = $("#instituteFk").val();
    var path = 'http://localhost:8080/Recommendation';
    if (id !== "-1") {
        document.getElementById("branchFk").disabled = false;
        id = $("#instituteFk").val();
        $.ajax({
            url:path+ '/viewBranch',
            type: "POST",
            data: {'instituteFk': id},
            success: function (result) {
                var branchJson = JSON.parse(result);
                bindBranchDropDown(branchJson);
            },
            error: function (error) {
                console.log(error.responseText);
            }
        });
    } else {
        $('#branchFk').find("option[value!=-1]").remove();
        document.getElementById("branchFk").disabled = true;
    }

}

function bindBranchDropDown(branchJson) {
     $('#branchFk').find("option[value!=-1]").remove();
    $.each(branchJson, function (index, object) {
        $('#branchFk').append('<option value=' + object['branchFk'].branchPK + '>' + object['branchFk'].branchName+ '</option>');
    });
}

