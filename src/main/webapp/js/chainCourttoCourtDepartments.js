
$(function() {
    /* For jquery.chained.js */
    $("#series").chained("#mark");
    $("#model").chained("#series");
    $("#engine").chained("#series, #model");
    /* Show button after each pulldown has a value. */
    $("#engine").bind("change", function(event) {
        if ("" != $("option:selected", this).val() && "" != $("option:selected", $("#model")).val()) {
            $("#button").fadeIn();
        } else {
            $("#button").hide();
        }
    });
    $("#c").chained("#a,#b");
    /* For jquery.chained.remote.js */
    $("#series-remote").remoteChained({
        parents : "#mark-remote",
        url : "json.php?sleep=1",
        loading : "--"
    });
    $("#model-remote").remoteChained({
        parents : "#series-remote",
        url : "json.php?sleep=1",
        loading : "--"
    });
    $("#engine-remote").remoteChained({
        parents : "#series-remote, #model-remote",
        url : "json.php?sleep=1",
        loading : "--",
        clear : true
    });
    /* Show button after each pulldown has a value. */
    $("#engine-remote").bind("change", function(event) {
        if ("" != $("option:selected", this).val() && "" != $("option:selected", $("#model-remote")).val()) {
            $("#button-remote").fadeIn();
        } else {
            $("#button-remote").hide();
        }
    });
    $("#c-remote").remoteChained("#a-remote,#b-remote", "json.php");
    /* For multiple jquery.chained.remote.js */
    $(".series-remote").each(function() {
        $(this).remoteChained($(".mark-remote", $(this).parent()), "json.php");
    });
    $(".model-remote").each(function() {
        $(this).remoteChained($(".series-remote", $(this).parent()), "json.php");
    });
    $(".engine-remote").each(function() {
        $(this).remoteChained([
            $(".series-remote", $(this).parent()),
            $(".model-remote", $(this).parent())
        ], "json.php");
    });
    /* For multiple jquery.chained.js */
    $(".series").each(function() {
        $(this).chained($(".mark", $(this).parent()));
    });
    $(".model").each(function() {
        $(this).chained($(".series", $(this).parent()));
    });
    $(".engine").each(function() {
        $(this).chained([
            $(".series", $(this).parent()),
            $(".model", $(this).parent())
        ]);
    });
    /* For normal input and jquery.chained.remote.js */
    $("#series-remote-2").remoteChained({
        parents : "#mark-remote-2",
        url : "json.php",
    });
    $("#model-remote-2").remoteChained({
        parents : "#series-remote-2",
        url : "json.php"
    });
    $("#engine-remote-2").remoteChained({
        parents : "#series-remote-2, #model-remote-2",
        url : "json.php"
    });
    /* Show button after each pulldown has a value. */
    $("#engine-remote-2").bind("change", function(event) {
        if ("" != $("option:selected", this).val() && "" != $("option:selected", $("#model-remote-2")).val()) {
            $("#button-remote-2").fadeIn();
        } else {
            $("#button-remote-2").hide();
        }
    });
  });