(ns fw-r-cljs-v3.routes
  (:require
   [bidi.bidi :as bidi]
   [hiccups.runtime]
   [clojure.string :as string]
   [macchiato.util.response :as r]
   [serv.html :as serveHtml]
   [serv.serve-image :as serveImage]
   [serv.serve-stylesheet :as serveStylesheet])
  (:require-macros
    [hiccups.core :refer [html]]))
(def fs (js/require "fs"))
(def js-join (.-join (js/require "path")))
(def js-basename (.-basename (js/require "path")))

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
       "/" {:get serveHtml/homepage}
       "index" {:get serveHtml/homepage}
       "images" {:get serveImage/serveImage}
       "css" {:get serveStylesheet/serveStylesheet}
       )])

(defn get-dir [req-uri]
  (let [eval (second (string/split req-uri #"/"))]
    (if (= req-uri "/") "/" eval)))

(defn router [req res raise]
  (let [req-dir (get-dir (:uri req))]
     (if-let [{:keys [handler route-params]} 
           (bidi/match-route* routes req-dir req)]
    (handler (assoc req :route-params route-params) res raise)
    (not-found req res raise))))

