(ns clojure-hacker-news.controllers.post
  (:require [clojure-hacker-news.responses :refer [response-plain-text]]
            [clojure-hacker-news.validations :refer [valid-create-inputs?]]))

(defn create-response
  [db-response]
  (if (= db-response :ok)
    (response-plain-text "post created" 201)
    (response-plain-text "post creation failed" 500)))

(defn req->sql-dsl
  [{content :content title :title}]
  {:insert-into [:post] :values [{:content content, :title title}]})

(defn create-post
  [req db-create-post-function]
  (let [valid_input? valid-create-inputs?]
    (if valid_input?
      (create-response (db-create-post-function (req->sql-dsl req)))
      (response-plain-text "request does not have the required fields" 422))))