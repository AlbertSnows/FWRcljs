(ns serv.serve-stylesheet  
  (:require 
   [clojure.string :as string]
   [serv.serve-404 :as serve404]
   [macchiato.util.response :as r]))
(def fs (js/require "fs"))
(def js-join (.-join (js/require "path")))

; @function serveStylesheet
; Serves the specified css file as an HTTP response.
; @param {http.IncomingMessage} req - the HTTP request object
; @param {http.ServerResponse} res - the HTTP response object
(defn style-response [accept-value res]
  ;(print accept-value "goodbye!" res)
  (let [accept-map
        {accept-value (js-join "./src/public" accept-value)}]
    (-> (r/file (get accept-map accept-value serve404/serve404))
        ; (r/content-type accept-value)
        (res))))

(defn serveStylesheet [req res raise]
  (let [accept-value (string/lower-case
                      (get-in req [:uri]))]
    (style-response accept-value res)))

