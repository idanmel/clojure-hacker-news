(ns clojure-hacker-news.core
  (:require [compojure.core :refer [GET POST defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :refer [run-server]]))

(def content-type-plain-text {"Content-Type" "text/plain; charset=utf-8"})

(defn response-json [body]
  {:headers {"Content-Type" "application/json; charset=utf-8"}
   :status 200
   :body body})

(defn response-plain-text [body status]
  {:headers content-type-plain-text
   :status status
   :body body})

(def response-not-found
  (response-plain-text "not found" 404))

(defroutes myapp
           (GET "/ping" [] (response-plain-text "pong" 200))
           (POST "/create-post" [] (response-plain-text "post created" 201))
           (not-found response-not-found))

(defn -main []
  (run-server myapp {:port 5000}))
