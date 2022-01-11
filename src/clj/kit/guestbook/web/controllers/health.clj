(ns kit.guestbook.web.controllers.health  
  (:import
    [java.util Date]))

(defn healthcheck!
  [req]
  {:status 200
   :body   (pr-str
            {:time     (str (Date. (System/currentTimeMillis)))             
             :app      {:status  "up"
                        :message ""}})})
