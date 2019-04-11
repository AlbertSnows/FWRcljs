(ns serv.serve-image
  (:require [serv.serve-404 :as serve404]))
(def fs (js/require "fs"))

(def join (.-join (js/require "path")))

; @function serveImage
;  Serves the specified image as an HTTP response.
;  @param {string} filename - the file to serve
;  @param {http.IncomingMessage} req - the HTTP request object
;  @param {http.ServerResponse} res - the HTTP response object
(defn serveImage
  [req res]
  (.log js/console "hello!")
  (.readFile
   fs
   (str "./public/images/" (.. req -params -filename))
   (fn [err data]
     (when err (serve404/serve404 req res)) 
     (.setHeader res "Content-Type" "image/jpeg")
     (.end res data))))

; Export the serveImage function
;(set! (.-exports module) serveImage)
