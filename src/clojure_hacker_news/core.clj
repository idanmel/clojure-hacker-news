(ns clojure-hacker-news.core
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :refer [run-server]]))

(def content-type-plain-text {"Content-Type" "text/plain; charset=utf-8"})

(defn json-headers [body]
  {:headers {"Content-Type" "application/json; charset=utf-8"}
   :status 200
   :body body})

(defn plain-text-headers [body status]
  {:headers content-type-plain-text
   :status status
   :body body})

(def response-not-found
  (plain-text-headers "not found" 404))

(defroutes myapp
           (GET "/ping" [] (plain-text-headers "pong" 200))
           (not-found response-not-found))

(defn -main []
  (run-server myapp {:port 5000}))
