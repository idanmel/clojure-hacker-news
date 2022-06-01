(ns clojure-hacker-news.helpers)

(defn req->body
  [req]
  (:body req))
