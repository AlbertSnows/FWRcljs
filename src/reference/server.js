/* server.js */
"use strict";

/* require statements */
var http = require('http');
var fs = require('fs');
var serveImage = require('./src/serve-image');
var serveStylesheet = require('./src/serve-stylesheet');
var serveIndex = require('./src/serve-index');
var serveDetail = require('./src/serve-detail');
var serve404 = require('./src/serve-404');
var Router = require('./lib/router');
var Templates = require('./lib/templates');
var postComment = require('./src/post-comment'); 
/* global variables */
var port = 2000;

var router = new Router(serve404);

router.addRoute("GET", "/", serveIndex);
router.addRoute("GET", "/index", serveIndex);
router.addRoute("GET", "/css/:filename", serveStylesheet);
router.addRoute("GET", "/images/:filename", serveImage);
router.addRoute("GET", "/details/:name", serveDetail);
router.addRoute("POST", "/details/:name", postComment);

var templates = new Templates('./templates');
/* Create a new HTTP server */
var server = http.createServer((req, res) => {
  res.templates = templates;
  router.route(req, res)
});

/* Listen for incoming HTTP requests */
server.listen(port, function() {
  console.log("Listening on port " + port);
});

