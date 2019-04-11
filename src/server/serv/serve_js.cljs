(ns serv.serve-js)
(def http (js/require "http"))
(def fs (js/require "fs"))
(def join (.-join (js/require "path")))

; /*serve JS*/
(defn serveJS
  [filename req res]
  (let [jsPath (join (prn (.readdirSync fs (js* "__dirname"))) "../" "js" filename)]
    (.readFile
     fs
     jsPath
     (fn [err data]
       (when err
         (.error js/console err)
         (set! (.-statusCode res) 500)
         (set! (.-statusMessage res) "Server JS Error")
         (.end res "Server Error")
         )
       (when-not err
         (.setHeader res "Content-Type" "application/javascript")
         (.end res data)))))
         )

; (set! (.-exports module) serveJS)
