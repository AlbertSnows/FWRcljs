(ns lib.route)

(deftype Route [handler, keys] 
  
  (Route. 
    [pattern handler]
    (this-as that (set! (this-as this (.handler this)) handler))
    (this-as that (set! (this-as this (.keys this)) #js []))
    (def regExpParts
      (.map
       (.split pattern "/")
       (fn [part]
         (if (= (.charAt part 0) ":")
           (do (.push (this-as this (.keys this)) (.slice part 1)) "([^/]+)")
           part))))
    (this-as that
             (set!
              (this-as this (.regexp this))
              (new RegExp (str "^" (.join regExpParts "/") "/?$"))))
    )

  (match
    [req res]
    (let [match (.exec (this-as this (.regexp this)) (.-url req))]
      (when (not match) false)
      (def params #js {})
      (.forEach
       (this-as this (.keys this))
       (fn [key i] (set! (aget params key) (aget match (+ i 1)))))
      (set! (.-params req) params)
      (this-as this (.handler this) req res)
      true))
  )
