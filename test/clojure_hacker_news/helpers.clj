(ns clojure-hacker-news.helpers
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-hacker-news.core :refer [myapp]]))

(defn mock-request
  ([path]
   (myapp (mock/request :get path)))
  ([method path]
   (myapp (mock/request method path))))