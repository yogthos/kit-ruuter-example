(ns kit.guestbook.web.routes.api
  (:require
    [kit.guestbook.web.controllers.health :as health]
    [integrant.core :as ig]))

;; Routes
(defn api-routes [_opts]
  [{:path "/health"
    :method :get
    :response health/healthcheck!}])

(derive :reitit.routes/api :reitit/routes)

(defmethod ig/init-key :reitit.routes/api
  [_ opts]
  (api-routes opts))
