 (ns serv.server)
;   (:require 
;    [serv.serve-image :as serveImage]
;    [serv.serve-404 :as serve404]
;    [serv.serve-stylesheet :as serveStylesheet]
;    [serv.serve-index :as serveIndex]))

; (def http (js/require "http")) 
; (def fs (js/require "fs"))
; (def port 2000)

; ; (def router 
; ;   (r/router [["/" :serveIndex]
; ;              ["/index" :serveIndex]
; ;              ["/index.html" :serveIndex]
; ;              ["/css/:filename" :serveStylesheet]
; ;              ["/images/:filename" :serveImage]]))


; ;(def router (new Router serve404))
; ; (.addRoute router "GET" "/" serveIndex)
; ; (.addRoute router "GET" "/index" serveIndex)
; ; (.addRoute router "GET" "/css/:filename" serveStylesheet)
; ; (.addRoute router "GET" "/images/:filename" serveImage)

; (def server (.createServer http (fn [req res] (.route router req res))))
; (.listen server port (fn [] (.log js/console (str "Listening on port " port))))
