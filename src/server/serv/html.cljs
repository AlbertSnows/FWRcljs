(ns serv.html
  (:require    
   [macchiato.util.response :as r]
   [serv.serve-image :as serveImage]
   [clojure.string :as string])
    (:require-macros
     [hiccups.core :refer [html]]))
; rewrite html in clojure
; use templates to import html 
(def fs (js/require "fs"))
(def js-join (.-join (js/require "path")))
(def recipePath (js-join js/__dirname "../../../" "src/data" "recipes.json"))
(def cardData (.parse js/JSON (.readFileSync fs recipePath)))
(js->clj (-> cardData js/JSON.stringify js/JSON.parse))
(js->clj :keywordize-keys true)
(def convertedCardData (map js->clj cardData))
(defn convertToCljDS [DS]
  (map first (map val (map last (into '[] DS)))))
(def cljsDS (convertToCljDS convertedCardData))
(def better-DS (apply list convertedCardData))
; (print better-DS)
; (print (type better-DS))
; (print (first better-DS))
; (print (type (first better-DS)))

; @function generateCardHTML
;  Generates a HTML string array representing the cards
;  @returns {string[]} Array of HTML strings
(defn mapData [req name price]
[:a {:class "card" :href  (str req)} ; link
 [:img
  {:src (str req) :alt "IMG"}]
 [:span "Name: " (str name) ]
 [:span "Price: " (str price)]
 [:span "Comments: " "?"]] 
  )

(defn generateCardHTML [req]
  (for [elem req]
    (mapData (js-join "/images/" (first (val (last elem)))) (val (first elem)) (val (second elem)))))
(def code-to-insert (generateCardHTML better-DS))
(def non-lazy-seq (apply list code-to-insert))


(defn homepage [req res raise]
  (-> (html
       ; [:!doctype {html}]
       [:html {:lang "en"}
        [:head
         [:meta {:content "text/html;charset=utf-8" :http-equiv "Content-Type"}]
         [:link {:rel "stylesheet" :type "text/css" :href "/css/main.css"}]
         [:title "My Website"]
    ] ;head
        [:body {:class "background mexico"}
         [:header {:id "header"}
          [:div
           [:strong {:id "logo"} "Kistner's Flowers"]]
          [:nav {:class "navbar"}
           [:ul
            [:li {:class "dropdown" :style "float: right;"}
             [:button {:class "dropbtn"}
              [:a {:href "#" :target "_self" :class "dropdown unselected"} "About" ]]
             [:div {:class "dropdown-content"}
              [:a {:href "#"} "About Us"]
              [:a {:href  "#"} "Meet The Staff"]
              [:a {:href  "#"} "Visit Our Store"]
              [:a {:href  "#"} "Help"]
              [:a {:href  "#"} "(800) 532-3409"]
              ]
             ]
            [:li {:class "dropdown" :style "float: right;"}
             [:button {:class "dropbtn"}
              [:a {:href "#" :target "_self" :class "dropdown unselected"} "Sororities"]]
             [:div {:class "dropdown-content"}
              [:a {:href  "#"} "Gamma Phi Beta"]
              [:a {:href  "#"} "Alpha Chi Omega"]
              [:a {:href  "#"} "Alpha Delta Pi"]
              [:a {:href  "#"} "Delta, Delta, Delta"]
              [:a {:href  "#"} "Alpha Xi Delta"]
              [:a {:href  "#"} "Chi Omega"]
              [:a {:href  "#"} "Zeta Tau Alpha"]
              [:a {:href  "#"} "Kappa Alpha Theta"]
              [:a {:href  "#"} "Kappa Kappa Gamma"]
              [:a {:href  "#"} "Kappa Delta"]
              [:a {:href  "#"} "Pi Beta Phi"]
              [:a {:href  "#"} "Sigma Kappa"]
              ]
             ]
            [:li {:class "dropdown" :style "float: right;"}
             [:button {:class "dropbtn"}
              [:a {:href "#" :target "_self" :class "dropdown unselected"} "Occasion"]
              ]
             [:div {:class "dropdown-content"}
              [:a {:href  "#"} "New Baby!"]
              [:a {:href  "#"} "Daily Expressions"]
              [:a {:href  "#"} "Garden Paradise"]
              [:a {:target "__self" :href "https://www.pinterest.com/kistnersflowers/"} "Wedding"]
              [:a {:target "__self" :href "https://www.pinterest.com/kistnersflowers/local-altars/"} "Funeral"]
              [:a {:href  "#"} "Birthday"]
              [:a {:href  "#"} "Shop All Occasions"]
              ]
             ]
              ] ; ul
          ] ; nav
      ] ; header
         [:main
          [:div {:id "home-page-div"}
           (doall non-lazy-seq)
           ]
           [:div {:id "privacy-div"}
            [:head
             [:meta {:content "text/html;charset=utf-8" :http-equiv "Content-Type"}]
             [:link {:rel "stylesheet" :type "text/css" :href "/css/main.css"}]
             [:title "My Website"]
          ] ; head
            [:body {:class "background mexico"}
             [:p
              [:h1
               "Substitution Policy"
               ]
              [:p
               "Occasionally, substitutions may be necessary to create your bouquet due to the
                        availability of certain flowers in various parts of the country. Care is taken to
                         maintain the style, theme and color scheme of the arrangement, using flowers of equal
                         value. Additionally, the substitution of certain keepsake items may be necessary due to
                          increased demand, especially during major holidays. In single-flower arrangements,
                          such as an all rose bouquet, or orchids, we will make every attempt to match the
                          flower type, but may substitute with another color."
               ]
              [:h1
               "Privacy Policy"
               ]
              [:p
               "This privacy statement has been created in order to demonstrate our firm commitment to protecting customer privacy."
               ]
              [:h2
               "Information We Collect"
               ]
              [:p
               "If you open an account on our site or make a purchase, we need your contact information
                         including your name, e-mail address and mailing address to complete your transaction."
               ]
              [:p
               "When you visit our website, we also collect some basic information that does not
                        identify individual users. We use this information to determine our users demographics
                         and interests, so that we can better understand and serve our users."]
              [:h2
               "Cookies"
               ]
              [:p
               "Cookies are small files which store certain information about your activity on the
                        website and are stored on your computers hard drive. Our cookies do not contain any
                         personally identifying information. We use cookies to let us know that you are a prior
                          customer, so that you dont have to reenter information you gave us on your prior
                           visits. Most web browsers automatically accept cookies, but most allow you to
                            instruct your browser to prevent the use of cookies. However, if you disable
                             cookies, you will not be able to use certain features of this website."
               ]
              [:p
               "Our Use and Disclosure of Your Information"
               ]
              [:p
               "When opening an account or making a purchase, you have an opportunity to opt-in or
                         opt-out from receiving emails from us. If you opt-in to receive information from us,
                          we may use your purchase history, contact information and other registration
                           information to provide you with more relevant information and email content. We
                            may send emails to our users regarding changes in our services or other information
                             we believe will be of interest to our users. If you prefer not to receive these
                              emails, you can send us an email with the subject line no emails or reply to our
                               email with the subject line no emails."
               ]
              [:p
               "If you send us personal correspondence, such as emails or letters, or if other users or
                         third parties send us correspondence about your activities on our site, we may collect
                          such information. We may use that information and other information that we obtain
                           from your use of our site to resolve disputes, troubleshoot problems and enforce our agreement for Terms of Use."
               ]
              [:p
               "We may share aggregate statistics about our sales, traffic patterns and related site
                         information with other businesses, but these statistics will include no personally
                          identifying information."
               ]
              [:p
               "We may share your information with Teleflora and other reputable vendors for the purpose
                         of sending out special offers via email and/ or in connection with the services
                          provided by our site such as the delivery of flowers. Your information will not be
                           shared for any other purpose and will be kept secured."
               ]
              [:p
               "We cannot ensure that all of your private communications and other personally
                         identifiable information will never be disclosed in ways not otherwise described in
                          this Privacy Statement. For example, we may be required to disclose information to
                           the government or third parties under certain circumstances, or third parties may
                            unlawfully intercept or access transmissions or private communications. We can (and
                                 you authorize us to) disclose any information about you to law enforcement or
                                  other government officials as we, in our sole discretion, believe necessary
                                   or appropriate in connection with an investigation of fraud, intellectual
                                    property infringements, or other activity that may be illegal or may expose us to legal liability."
               ]
              [:h2
               "Security"
               ]
              [:p
               "This site has security measures in place to protect the loss, misuse and alteration of
                         the information under our control."
               ]
              [:p
               "All user credit card information is securely communicated using secure socket layer
                         (SSL) software, which is the industry standard and among the best software available
                          for secure commerce transactions."
               ]
              [:p
               "All user information stored on our server is stored in an encrypted format.
                         Notwithstanding these efforts, we caution you that perfect security does not exist on the Internet."
               ]
              [:h2
               "Linked Sites"
               ]
              [:p
               "If this site contains any links to other websites, we are not responsible for the
                         privacy practices or the content of such websites."
               ]
              [:h2
               "Changes to Privacy Statement; Consent"
               ]
              [:p
               "We may update this Privacy Statement from time to time. You should check this page
                             periodically for changes. By using our site, you consent to the collection and use
                              of your information by us as described in this Privacy Statement."
               ]
              [:h2
               "Questions and Comments"
               ]
              [:p
               "We welcome your questions and comments about this Privacy Statement."
                    ] ; p
            ] ; p
            ] ; body
        ]; div 
           ] ; main
         [:footer {:class "footer"}
          [:div {:id "footer-content"}
           [:div {:id "footer-contact"}
            [:div {:id "address"}
             [:h5 {:id "name" :itemprop "name"} "Kistner's Flowers"]
             [:p {:id "street" :itemprop "streetAddress"} "1901 Pillsbury Dr.&nbsp"]
             [:p {:id  "town"}
              [:span {:itemprop  "addressLocality"} "Manhattan"]
              [:span {:itemprop  "addressRegion"} "KS"]
              [:span {:itemprop  "postalCode"} "66502"]]
             
             ]
            [:div {:id "phone-number"}
             [:span {:itemprop "telephone"}]
             [:a {:href "tel:(785) 776-7044"} "(785) 776-7044"]
             [:br]
             [:span] [:a {:href "tel:(800) 532-3409"} "(800) 532-3409"]
             ]
            [:div {:class "footer-social"}
             [:a {:href "https://www.facebook.com/KistnersFlowers1946/?fref=ts" :target "_blank"}
              [:img {:src "/images/facebookGold.png" :alt "IMG" :width "25" :height "25"}]
              ]
             [:a {:href "https://www.instagram.com/kistnersflowers/" :target "_blank"}
              [:img {:src "/images/instagramGold.png" :alt "IMG" :width "25" :height "25"}]
              ]
             [:a {:href "https://www.pinterest.com/kistnersflowers/boards/" :target "_blank"}
              [:img {:src "/images/pinterestGold.png" :alt "IMG" :width "25" :height "25"}]
              ]
             ]
              ] ; div footer contract
           [:div {:class "vertical-line"}
            [:div {:class "footer-navigation"}
             [:ul
              [:li
               [:h5 "Learn More About" 
                [:ul
                 [:li [:a {:href  "/about-us"} "About Us"]]
                 [:li [:a {:href  "/faq#Privacy Policy / Security"} "Safe Shopping"]]
                 [:li [:button {:id  "privacy-button"} [:a {:href  "#"} "Privacy"]]]
                            ;[:!-- [:li [:input  {:id  "privacy-input" :type  "button" value = "Button Text"} ]] --]
                 [:li [:a {:href  "/about-us#Delivery Policy"} "Delivery"]]
                 ]
                ]
               ]
              [:li
               [:h5 "Customer Service"]
               [:ul
                [:li [:a {:href  "/faq#Policy Info"} "Substitutions"]]
                [:li [:a {:href  "/sitemap"} "Site Map"]]
                [:li [:a {:href  "/faq"} "Help/FAQs"]] 
                           ; [:!--https:/about-us#Delivery%20Policy--]
                ]
               ]
                  ] ; ul
              ] ; div nav
          ] ; footer
           ]; div
      ] ; footer
         [:script {:type "application/javascript" :src "client.js"}]
      ] ; body
     ]; html
       )
      (r/ok)
      (r/content-type "text/html")
      ;(r/doctype "html")
      (res)))
