(ns fw-r-cljs-v3.routes
  (:require
   [bidi.bidi :as bidi]
   [hiccups.runtime]
   [macchiato.util.response :as r]
   [test.fw_r_cljs_v3.test-ns :as home]
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
  ["/" {:get home/home}]
  ;; ["/index" {:get serveHtml}]
  
  )

(defn router [req res raise]
  (if-let [{:keys [handler route-params]} (bidi/match-route* routes (:uri req) req)]
    (handler (assoc req :route-params route-params) res raise)
    (not-found req res raise)))
