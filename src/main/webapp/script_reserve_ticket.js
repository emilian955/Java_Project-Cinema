
var projections
var key_of_projection

function fetchMovies()
{
    jQuery.ajaxSetup({async:false});
    $.get('http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/projections', function(responseText) {
        projections = responseText
    });
    var buffer
    for (let key in projections){
        buffer += '<option>' + projections[key]["movieTitle"] + '</option>'
    }
    $(document).ready(function() {
        $('#Movies').append(buffer)});
    console.log(projections)
}

function takeData()
{

    if (( $("#Username").val().length == 0 ) || ( $("#Numseats").val().length == 0 ))
    {
        alert("Please enter your name, email and the desired number of seats");
    }
    else
    {
        $(".inputForm *").prop("disabled", true);
        $(".seatStructure *").prop("disabled", false);
        document.getElementById("notification").innerHTML = "<b style='margin-bottom:0px;background:#1abc9c;'>Please select your seats. </b>";

        $(document).ready(function() {
            $('#seatsBlock').append('<tr>\
        <td colspan="14"><div class="screen">SCREEN</div></td>\
            <td rowspan="20">\
                <div class="smallBox greenBox">Selected Seat</div> <br/>\
                <div class="smallBox redBox">Reserved Seat</div><br/>\
                <div class="smallBox emptyBox">Empty Seat</div><br/>\
            </td>\
        <br/>\
        </tr>')});

        var rows
        var columns
        movie_title = document.getElementById("Movies").value;

        for (let key in projections){
            if(projections[key].movieTitle == movie_title){
                rows = projections[key]["idRoom"]["noOfRows"]
                columns = projections[key]["idRoom"]["noOfColumns"]
                key_of_projection = key
            }
        }

        var buffer = '<tr>'

        buffer += '<td></td>'

        for (let i = 1; i <= columns; i++) {
            buffer += '<td>' + i + '</td>'
        }

        buffer += '</tr>'

        $(document).ready(function() {
            $('#seatsBlock').append(buffer)});

        buffer = '<tr>'

        for (let i = 1; i <= rows; i++) {
            buffer += '<td>' + i + '</td>'
            for (let j = 1; j <= columns; j++) {
                buffer += '<td><input type="checkbox" id="' + i + '-' + j + '"></td>'
            }
            buffer += '</tr>'
        }

        $(document).ready(function() {
            $('#seatsBlock').append(buffer)});

        jQuery.ajaxSetup({async:false});
        $.get('http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets/findByMovie/' + movie_title, function(responseText) {
            tickets = responseText
        });

        for(key in tickets){
            var current_row = tickets[key]['noOfRow']
            var current_column = tickets[key]['noOfColumn']
            var val = current_row + '-' + current_column
            document.getElementById(val).classList.add('reserved');
            document.getElementById(val).setAttribute('disabled', true);
            document.getElementById(val).setAttribute('checked', true);
        }

    }

}


function updateTextArea() {

    if ($("input:checked").length - $("input.reserved:checked").length == ($("#Numseats").val()))
    {
        $(".seatStructure *").prop("disabled", true);

        var allNameVals;
        var allNumberVals;
        var allSeatsVals = [];

        //Storing in Array
        name_val = $("#Username").val()
        numberSeats_val = $("#Numseats").val()
        email_val = $("#Email").val()
        $('#seatsBlock :checked').not('.reserved').each(function() {
            allSeatsVals.push($(this).attr('id'));
        });

        for (let key in projections){
            if(projections[key].movieTitle == movie_title){
                rows = projections[key]["idRoom"]["noOfRows"]
                columns = projections[key]["idRoom"]["noOfColumns"]
                console.log(rows, columns)
            }
        }

        console.log(projections[key_of_projection])

        for(key in allSeatsVals){
            temp = allSeatsVals[key].split('-')
            ticket_to_insert = {"idProjection" : projections[key_of_projection],"noOfRow": temp[0], "noOfColumn": temp[1], "nameBuyer": name_val, "email": email_val}
            console.log(ticket_to_insert)
            $(document).ready(function() {
                $.ajax({
                    url:"http://localhost:8080/Cinema_Application-1.0-SNAPSHOT/resources/tickets",
                    type:"POST",
                    headers: {
                        "Accept" : "application/json; charset=utf-8",
                        "Content-Type": "application/json; charset=utf-8"
                    },
                    data: JSON.stringify(ticket_to_insert),
                    dataType:"json"
                })
            });
        }
        alert('Seats booked successfully!')
        window.location.reload();
    }
    else
    {
        alert("Please select " + ($("#Numseats").val()) + " seats")
    }
}


function myFunction() {
    alert($("input:checked").length);
}

