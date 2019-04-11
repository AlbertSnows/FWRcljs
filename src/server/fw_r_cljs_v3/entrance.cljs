(ns fw-r-cljs-v3.entrance
  (:require
    [fw-r-cljs-v3.config :refer [env]]
    [fw-r-cljs-v3.middleware :refer [wrap-defaults]]
    [fw-r-cljs-v3.routes :refer [router]]
    [macchiato.server :as http]
    [macchiato.middleware.session.memory :as mem]
    [mount.core :as mount :refer [defstate]]
    [taoensso.timbre :refer-macros [log trace debug info warn error fatal]]))

(defn server []
  (mount/start)
  (let [host (or (:host @env) "127.0.0.1")
        port (or (some-> @env :port js/parseInt) 3000)]
    (http/start
      {:handler    (wrap-defaults router)
       :host       host
       :port       port
       :on-success #(info "fw-r-cljs-v3 started on" host ":" port)})))
