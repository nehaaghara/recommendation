/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function alphabaticValidate(id)
{
    var val = $('#' + id).val();
    var message = " Must be Alphabatic <span style='color:green;'>[A-Z,a-z]</span>";
    if (!val.match(/^[a-zA-Z ]+$/))
    {
        $('#' + id).val("");
        $('#' + id).focus();
        $('<span class="error">' + message + '</span>').appendTo($('#' + id).parent().parent().find("label"));
        return false;
    } else {
        val;
        return true;
    }
}