(ns kit.guestbook.web.routes.pages
  (:require    
    [integrant.core :as ig]
    [kit.guestbook.web.pages.layout :as layout]))

(defn home [request]
  (layout/render request "home.html" {}))

;; Routes
(defn page-routes [_opts]
  [{:path "/"
    :method :get
    :response home}])

(derive :reitit.routes/pages :reitit/routes)

(defmethod ig/init-key :reitit.routes/pages
  [_ opts]
  (layout/init-selmer!)
  (page-routes opts))