function onClick() {
    $.ajax({
        url : '/checker/servlet?command=getResult',
        success : function(responseJson) {

            var serverResultsArray = responseJson.result;

            $.each(serverResultsArray, function(index, serverResult) {
                $( "#ajaxGetUserServletResponse").empty();
                var $table = $("<table>").appendTo($("#ajaxGetUserServletResponse"));
                var $tr = $("<tr>");

                $("<th>").text("#").appendTo($tr);
                $("<th>").text("Url").appendTo($tr);
                $("<th>").text("Response code").appendTo($tr);
                $("<th>").text("Response time").appendTo($tr);
                $("<th>").text("Status").appendTo($tr);
                $("<th>").text("Critical timeout").appendTo($tr);
                $("<th>").text("Error timeout").appendTo($tr);

                $tr.appendTo($table);


                $.each(serverResult, function(ind, serverResultItem) {
                    $tr = $("<tr>");
                    $("<td>").text(ind).appendTo($tr);
                    $("<td>").text(serverResultItem.url).appendTo($tr);
                    $("<td>").text(serverResultItem.responseCode).appendTo($tr);
                    $("<td>").text(serverResultItem.responseTime).appendTo($tr);
                    $("<td>").text(serverResultItem.status).appendTo($tr);
                    $("<td>").text(serverResultItem.critical_timeout).appendTo($tr);
                    $("<td>").text(serverResultItem.error_timeout).appendTo($tr);

                    $tr.appendTo($table);
                });
            });
        }
    });
}