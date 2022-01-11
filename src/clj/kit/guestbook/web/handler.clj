(ns kit.guestbook.web.handler
  (:require
    [ruuter.core :as ruuter]
    [integrant.core :as ig]))

(defmethod ig/init-key :handler/ring
  [_ {:keys [routes]}]
  #(ruuter/route (apply concat routes) %))