(ns clojure-hacker-news.test_helpers
  (:require [ring.mock.request :as mock]
            [clojure-hacker-news.core :refer [app]]))

(defn mock-request
  ([path]
   (app (mock/request :get path)))
  ([method path]
   (app (mock/request method path))))