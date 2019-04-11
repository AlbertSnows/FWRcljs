 (ns fw-r-cljs-v3.app
  (:require
    [fw-r-cljs-v3.entrance :as core]
    [cljs.nodejs]
    [mount.core :as mount]))

(mount/in-cljc-mode)

(cljs.nodejs/enable-util-print!)

(set! *main-cli-fn* core/server)
