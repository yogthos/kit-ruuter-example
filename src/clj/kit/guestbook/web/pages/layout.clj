(ns kit.guestbook.web.pages.layout
  (:require
   [clojure.java.io]
   [selmer.parser :as parser]
   [ring.util.http-response :refer [content-type ok]]
   [ring.util.anti-forgery :refer [anti-forgery-field]]
   [ring.middleware.anti-forgery :refer [*anti-forgery-token*]]
   [ring.util.response]))

(def selmer-opts {:custom-resource-path (clojure.java.io/resource "html")})

(defn init-selmer!
  []
  (parser/add-tag! :csrf-field (fn [_ _] (anti-forgery-field))))

(defn render
  [request template & [params]]
  (-> (parser/render-file template
                          (assoc params :page template :csrf-token *anti-forgery-token*)
                          selmer-opts)
      (ok)
      (content-type "text/html; charset=utf-8")))