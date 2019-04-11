(ns serv.serve-404)

; @function serve404
;  Helper function for serving a 404 error code
;  @param {http.IncomingRequest} req - the request object
;  @param {http.ServerResponse} res - the response object
(defn serve404
  [req res]
  (.warn js/console "404 Not Found" (.-method req) (.-url req))
  (set! (.-statusCode res) 404)
  (set! (.-statusMessage res) "Not Found")
  (.end res))

;