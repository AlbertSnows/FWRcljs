(ns serv.serve-image
  (:require 
   [clojure.string :as string]
   [serv.serve-404 :as serve404]
   [macchiato.util.response :as r]))
(def fs (js/require "fs"))
(def js-join (.-join (js/require "path")))

; @function serveImage
;  Serves the specified image as an HTTP response.
;  @param {string} filename - the file to serve
;  @param {http.IncomingMessage} req - the HTTP request object
;  @param {http.ServerResponse} res - the HTTP response object

(defn image-response [accept-value res]  
  ;(print accept-value "goodbye!" res)
  (let [accept-map
        {accept-value (js-join "./src/public" accept-value)}]
    (-> (r/file (get accept-map accept-value serve404/serve404))
        ; (r/content-type accept-value)
        (res))))

(defn serveImage [req res raise]
  (let [accept-value (string/lower-case
                      (get-in req [:uri]))]
    (image-response accept-value res)))

; (defn serveImage [req res]
;   (.readFile fs "banner.jpg"))
;              (.join "./public/images/" (.. req -params -filename))
;              (fn [err data]
;                (when err (serve404/serve404 req res)) 
;                (.setHeader res "Content-Type" "image/jpeg")
;                (.end res data)))
;             ))

; Export the serveImage function
;(set! (.-exports module) serveImage)
