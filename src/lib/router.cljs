(ns lib.router
  (:require [lib.route :as RouteVal])) 

(deftype Router [notFound, routes]
  (Router. [notFoundHandler] ;;constructor
           (this-as that (set! (this-as this (.notFound this)) notFoundHandler))
           (this-as that (set! (this-as this (.routes this)) #js {})))
  (addRoute [method pattern handler]
        (when (not (saget (this-as this (.routes this)) method))
          (this-as that (set! (aget (this-as this (.routes this)) method) #js [])))
        (.push (aget (this-as this (.routes this)) method)
               (new RouteVal pattern handler)))
  (do-route [req res]
        (when (not (aget (this-as this (.routes this)) (.-method req)))
          (this-as this (.notFound this) req res)))
  (matched []
   (.find
    (aget (this-as this (.routes this)) (.-method req))
    (fn [route] (.match route req res))))
  (when (not matched) (this-as this (.notFound this) req res)))