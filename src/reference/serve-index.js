const fs = require('fs');
var cardData = JSON.parse(fs.readFileSync('./data/images.json'));

/** @function generateCardHTML 
 * Generates a HTML string array representing the cards 
 * @returns {string[]} Array of HTML strings
 */
function generateCardHTML(){
  return cardData.map(function(data) {
    return `
      <a class="card" href="${data.url}">
        <img src="images/${data.filename}" alt="thumbnail">
        <span>${data.comments.length} Comments</span>
      </a>
    `;
  });
}

/** @function serveIndex 
 * Serves an index page 
 */
function serveIndex(req, res) {
  res.setHeader("Content-Type", "text/html");
  res.end(
    `
      <!doctype html>
      <html>
        <head>
          <title>Gallery</title>
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link href="css/gallery.css" type="text/css" rel="stylesheet">
        </head>
        <body>
          <h1>Images</h1>
          <main id="thumbnails">
            ${generateCardHTML().join("")} 
          </main>
        </body>
      </html>
    `
  );
}

// export the serveIndex function 
module.exports = serveIndex;