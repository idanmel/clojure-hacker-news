(ns clojure-hacker-news.core
  (:require [compojure.core :refer [GET POST defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :refer [run-server]]
            [clojure-hacker-news.responses :refer [response-plain-text response-not-found]]
            [clojure-hacker-news.controllers.post :as post]
            [clojure-hacker-news.db :as db]
            [clojure-hacker-news.migrations :as migrations]
            [ring.middleware.json :refer [wrap-json-body]]))

(defonce server (atom nil))

(defroutes routes
           (GET "/ping" [] (response-plain-text "pong" 200))
           (POST "/posts" req (post/create! req db/create-post!))
           (not-found response-not-found))

(def app
  (-> routes
      (wrap-json-body {:keywords? true})))

(defn start-server
  [port]
  (reset! server (run-server #'app {:port port})))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

;(defn -main []
;  ;(migrations/init)
;  ;(migrations/migrate)
;  (start-server 5000))
