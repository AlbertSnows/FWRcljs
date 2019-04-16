

(defn eval-req [req res]
  (let [accept-value (str/lower-case
                      (get-in req [:uri]))]
    ;(print "accept-value is" accept-value)
    (process-route accept-value res)))

(defn process-route [accept-value res]
  (let [req-dir (second (str/split accept-value #"/"))]
    ;(print "req-dir is " req-dir)
    (routes req-dir res))) ;/images/banner.jpg

; https://github.com/macchiato-framework/examples/tree/master/cljsbin/src/cljsbin
(defn routes [req-dir res]
  (let [array-map
        {"images" {:get serveImage/serveImage}}]
    (->
     (get req-dir array-map)
     (res))))

(defn router [req res raise]
  (if-let [{:keys [handler route-params]}
           (bidi/match-route* (eval-req req res) (:uri req) req)]
    (handler (assoc req :route-params route-params) res raise)
    (not-found req res raise)))

(str
 "\n      <a class=\"card\" href=\""
 (.-url data)
 "\">\n        <img src=\"images/"
 (.-filename data)
 "\" alt=\"thumbnail\">\n        <span>"
 (.. data -comments -length)
 " Comments</span>\n      </a>\n    ")