(ns fw_r_cljs_v3.test-ns
  (:require
   [hiccups.runtime]
   [macchiato.util.response :as r])
    (:require-macros
    [hiccups.core :refer [html]]))

(defn home [req res raise]
  (-> (html
       [:html
        [:head
         [:link {:rel "stylesheet" :href "/css/main.css"}]]
        [:body
         [:h2 "Wake up Jeremy!"]
         [:p
          "Your user-agent is: "
          (str (get-in req [:headers "user-agent"]))]]])
      (r/ok)
      (r/content-type "text/html")
      (res)))