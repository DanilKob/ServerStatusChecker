$(document).ready(function() {
    $('#userName').blur(function() {
        $.ajax({
            url : 'GetUserServlet',
            data : {
                userName : $('#userName').val()
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});

function onClick() {
    $.ajax({
        url : '/checker/servlet/',
        success : function(responseJson) {
            var $table = $("<table>").appendTo($("#ajaxGetUserServletResponse"));
            var $tr;
            $.each(responseJson, function(key, value) {
                $tr = $("<tr>");
                $("<td>").text(key).appendTo($tr);
                $("<td>").text(value).appendTo($tr);
                $tr.appendTo($table);
            });

        }
    });
}