var	exec = require("child_process").exec;
var	querystring = require("querystring");
var	fs = require("fs"),
	filename = "output.txt",
	encode = "utf8";

function start(response, request_url) {
	console.log("Request handler 'start' was called.");

	fs.readFile(filename, encode, function(err, file) {
		var header =
		'<!DOCTYPE html>'+
		'<html>'+
		'<head>'+
			'<meta charset="utf-8" />'+
			'<title>Smashing HTML5!</title>'+
		'</head>'+
		'<body>'+
			'<pre>',
		footer =
			'</pre>'+
		'</body>'+
		'</html>';
		response.writeHead(200, {"Content-Type": "text/html"});
		response.write(header+file+footer);
		response.end();
	});
}

function upload(response, request_url) {
	console.log("Request handler 'upload' was called.");
	response.writeHead(200, {"Content-Type": "text/plain"});
	response.write("Hello Upload");
	response.end();
}

exports["/"] = start;
exports["/upload"] = upload;