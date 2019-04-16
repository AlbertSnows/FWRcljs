(defproject fw-r-cljs-v3 "0.1.0-SNAPSHOT"
  :description "Flower Website for CIS 526 I think?"
  :url "http://example.com/KFW-ajsnow"
  :dependencies [[bidi "2.1.4"]
                 [com.cemerick/piggieback "0.2.2"]
                 [com.taoensso/timbre "4.10.0"]
                 [macchiato/hiccups "0.4.1"]
                 [macchiato/core "0.2.14"]
                 [macchiato/env "0.0.6"]
                 [mount "0.1.15"]
                 [org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"]
                 ;; needed for JDK 9 compatibility
                 [javax.xml.bind/jaxb-api "2.3.0"]
                 [cider/cider-nrepl "0.19.0"]
                 [nrepl "0.6.0"]
                 [cider/piggieback "0.4.0"]
                 [figwheel-sidecar "0.5.18"]]
:repl-options {
               :nrepl-middleware 
               [cider.piggieback/wrap-cljs-repl]
               :timeout 120000}
  :min-lein-version "2.0.0"
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-doo "0.1.7"]
            [macchiato/lein-npm "0.6.4"]
            [lein-figwheel "0.5.17"]
            [lein-cljsbuild "1.1.7"]
            [cider/cider-nrepl "0.21.2-SNAPSHOT"]]
  :npm {:dependencies [[source-map-support "0.4.6"]]
        :write-package-json true}
  :source-paths ["src/server" "target/classes"]
  :target-path "target"
  :profiles
  {:server {:clean-targets ["target"]}
   :dev
   [:server
    {:npm {:package {:main "target/out/fw-r-cljs-v3.js"
                     :scripts {:start "node target/out/fw-r-cljs-v3.js"}}}
     :dependencies [[figwheel-sidecar "0.5.17"]]
     :cljsbuild
     {:builds {:dev
               {:source-paths ["env/dev" "src/server"]
                :figwheel     true
                :compiler     {:main          fw-r-cljs-v3.app
                               :output-to     "target/out/fw-r-cljs-v3.js"
                               :output-dir    "target/out"
                               :target        :nodejs
                               :optimizations :none
                               :pretty-print  true
                               :source-map    true
                               :source-map-timestamp false}}}}
     :figwheel
     {:http-server-root "public"
      :nrepl-port 7000
      :reload-clj-files {:clj true :cljc true}
      :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
     :source-paths ["env/dev"]
     :repl-options {:init-ns user}}]
   :test
   {:cljsbuild
    {:builds
     {:test
      {:source-paths ["env/test" "src/server" "test"]
       :compiler     {:main fw-r-cljs-v3.app
                      :output-to     "target/test/fw-r-cljs-v3.js"
                      :target        :nodejs
                      :optimizations :none
                      :pretty-print  true
                      :source-map    true}}}}
    :doo {:build "test"}
    :dependencies [[pjstadig/humane-test-output "0.9.0"]]}
   :release
   {:npm {:package {:main "target/release/fw-r-cljs-v3.js"
                    :scripts {:start "node target/release/fw-r-cljs-v3.js"}}}
    :cljsbuild
    {:builds
     {:release
      {:source-paths ["env/prod" "src/server"]
       :compiler     {:main          fw-r-cljs-v3.app
                      :output-to     "target/release/fw-r-cljs-v3.js"
                      :language-in   :ecmascript5
                      :target        :nodejs
                      :optimizations :simple
                      :pretty-print  false}}}}}}
  :aliases
  {"build" ["do"
            ["clean"]
            ["npm" "install"]
            ["figwheel" "dev"]]
   "package" ["do"
              ["clean"]
              ["npm" "install"]
              ["with-profile" "release" "npm" "init" "-y"]
              ["with-profile" "release" "cljsbuild" "once" "release"]]
   "test" ["do"
           ["npm" "install"]
           ["with-profile" "test" "doo" "node"]]})
