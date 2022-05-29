(ns clojure-hacker-news.controllers.post
  (:require [clojure-hacker-news.responses :refer [response-plain-text]]))

(defn create
  [req]
  (response-plain-text "post created" 201))
