(ns serv.template
  (:require path vm fs ))

(def hello
  (js/console.log "testing template!"))


; (deftype Templates []
;   (Templates. [templateDirectory]
;     (this-as that (set! (this-as this (.templates this)) #js {}))
;     (def templateFiles (.readdirSync fs templateDirectory))
;     (.forEach
;      templateFiles
;      (fn [filename]
;        (let [templatePath (.join path templateDirectory filename)
;              templateData (.readFileSync fs templatePath #js {:encoding "utf-8"})
;              templateName (.basename path filename ".ejs")]
;          (set! (aget (.-templates that) templateName) templateData)))))

;   ; maybe issolate by itself, only need render? 
;   (render [template, context]
;     (def templateText (aget (this-as this (.templates this)) template))
;     (when templateText
;       (try
;         (.replace
;          templateText
;          #"<%=(.*?)%>"
;          (fn [match code] (.runInNewContext vm code context)))
;         (catch js/Object err
;           (.error js/console (str "Error rendering template: " template ":") err)))))
;   )