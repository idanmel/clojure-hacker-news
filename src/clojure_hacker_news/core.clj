(ns clojure-hacker-news.core
  (:require [compojure.core :refer [GET POST defroutes]]
            [compojure.route :refer [not-found]]
            [org.httpkit.server :refer [run-server]]
            [clojure-hacker-news.responses :refer [response-plain-text response-not-found]]))

(defroutes myapp
           (GET "/ping" [] (response-plain-text "pong" 200))
           (not-found response-not-found))

(defn -main []
  (run-server myapp {:port 5000}))
