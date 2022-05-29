(ns clojure-hacker-news.controllers.post
  (:require [clojure-hacker-news.responses :refer [response-plain-text]]))

(defn create-response
  [response]
  (if (= response :ok)
    (response-plain-text "post created" 201)
    (response-plain-text "post creation failed" 500)))
