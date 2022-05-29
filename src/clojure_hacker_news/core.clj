(ns clojure-hacker-news.core
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :refer [run-server]]))


(defn json-headers [body]
  {:headers {"Content-Type" "application/json; charset=utf-8"}
   :status 200
   :body body})

(defn plain-text-headers [body status]
  {:headers {"Content-Type" "text/plain; charset=utf-8"}
   :status status
   :body body})

(defroutes myapp
           (GET "/ping" [] (plain-text-headers "pong" 200))
           (GET "/not-a-ping" [] (plain-text-headers "not found" 404))
           (GET "/not-found" [] (plain-text-headers "not found" 404)))

(defn -main []
  (run-server myapp {:port 5000}))