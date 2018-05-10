
        $(document).ready(function () {
            var date_input = $('input[id="date"]'); //our date input has the name "date"
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            var options = {
                format: 'yyyy-mm-dd 00:00:00',
                container: container,
                todayHighlight: true,
                autoclose: true,
            };
            date_input.datepicker(options);
        })
