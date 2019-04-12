(ns fw-r-cljs-v3.routes
  (:require
   [bidi.bidi :as bidi]
   [hiccups.runtime]
   [macchiato.util.response :as r]
   [serv.html :as serveHtml]
   [serv.serve-image :as serveImage]
   [serv.serve-stylesheet :as serveStylesheet]
   )
  (:require-macros
    [hiccups.core :refer [html]]))
(def fs (js/require "fs"))

(defn not-found [req res raise]
  (-> (html
       [:html
        [:body
         [:h2 (:uri req) " was not found"]]])
      (r/not-found)
      (r/content-type "text/html")
      (res)))

; https://github.com/macchiato-framework/examples/tree/master/cljsbin/src/cljsbin
(def routes
  ["" (array-map 
       "/images/banner.jpg" {:get serveImage/serveImage}
       )])





; (def routes
;   ["/" {:get l-serve-image} ]
;    "/index" {:get serveHtml/homepage}
;    "/css/main.css" {:get serveStylesheet/tester}
;    "/images/:filename" {:get l-serve-image}]
;   )

(defn router [req res raise]
  (if-let [{:keys [handler route-params]} (bidi/match-route* routes (:uri req) req)]
    (handler (assoc req :route-params route-params) res raise)
    (not-found req res raise)))
