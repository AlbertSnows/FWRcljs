(ns fw-r-cljs-v3.app
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [fw-r-cljs-v3.core-test]))

(doo-tests 'fw-r-cljs-v3.core-test)


