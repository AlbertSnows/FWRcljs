(ns fw-r-cljs-v3.routes
  (:require
   [bidi.bidi :as bidi]
   [hiccups.runtime]
   [macchiato.util.response :as r]
   [serv.html :as serveHtml]
   )
  (:require-macros
    [hiccups.core :refer [html]]))

(defn not-found [req res raise]
  (-> (html
        [:html
         [:body
          [:h2 (:uri req) " was not found"]]])
      (r/not-found)
      (r/content-type "text/html")
      (res)))

(def routes
  ["/" {:get serveHtml/homepage} 
   "/index" {:get serveHtml/homepage}
   "/css/:filename" {:get not-found}
   "/images/:filename" {:get not-found}]
  )

(defn router [req res raise]
  (if-let [{:keys [handler route-params]} (bidi/match-route* routes (:uri req) req)]
    (handler (assoc req :route-params route-params) res raise)
    (not-found req res raise)))
