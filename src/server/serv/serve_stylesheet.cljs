(ns serv.serve-stylesheet)
(def fs (js/require "fs"))
(def join (.-join (js/require "path")))

; @function serveStylesheet
; Serves the specified css file as an HTTP response.
; @param {http.IncomingMessage} req - the HTTP request object
; @param {http.ServerResponse} res - the HTTP response object
(defn serveStylesheet
  [req res]
  (.readFile
   fs
   (str "./public/css/" (.. req -params -filename))
   (fn [err data]
     (when err
       (.error js/console err)
       (set! (.-statusCode res) 500)
       (set! (.-statusMessage res) "Server Error")
       (.end res)
       )
     (when-not err
       (.setHeader res "Content-Type" "text/css")
       (.end res data))))
  )

; Export the serveStylesheet function
;(set! (.-exports module) serveStylesheet)

