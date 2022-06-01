(ns clojure-hacker-news.controllers.post
  (:require [clojure-hacker-news.responses :refer [response-plain-text]]
            [clojure-hacker-news.validations :refer [valid-create-inputs?]]
            [clojure-hacker-news.helpers :refer [req->body]]
            [honey.sql :as honeysql]))

(defn create-response
  [db-response]
  (if (= db-response :ok)
    (response-plain-text "post created" 201)
    (response-plain-text "post creation failed" 500)))

(defn req->sql-dsl
  [{content :content title :title}]
  {:insert-into [:posts] :values [{:content content, :title title}]})

(defn create!
  [req db-create-post-function!]
  (let [body (req->body req)]
    (if (valid-create-inputs? body)
      (->> body
           req->sql-dsl
           honeysql/format
           db-create-post-function!
           create-response)
      (response-plain-text "request does not have the required fields" 422))))