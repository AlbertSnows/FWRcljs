 (ns ^:figwheel-always fw-r-cljs-v3.app
  (:require
    [fw-r-cljs-v3.entrance :as core]
    [cljs.nodejs :as node]
    [mount.core :as mount]))

(mount/in-cljc-mode)

(cljs.nodejs/enable-util-print!)

(.on js/process "uncaughtException" #(js/console.error %))

(set! *main-cli-fn* core/server)
