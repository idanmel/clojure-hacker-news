(ns clojure-hacker-news.core-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.core :refer :all]
            [ring.mock.request :as mock]))

(deftest ping
  (testing "ping"
    (is (= (myapp (mock/request :get "/ping"))
           {:body    "pong"
            :headers {"Content-Type" "text/plain; charset=utf-8"}
            :status  200}))))

(deftest not-found
  (testing "not-a-ping")
  (is (= (myapp (mock/request :get "/not-a-ping"))
         {:body    "not found"
          :headers {"Content-Type" "text/plain; charset=utf-8"}
          :status  404})))



