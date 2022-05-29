(ns clojure-hacker-news.core-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.core :refer :all]
            [ring.mock.request :as mock]
            [clojure-hacker-news.core :refer [content-type-plain-text myapp response-not-found]]))

(deftest ping
  (testing "ping"
    (let [{status :status body :body headers :headers} (myapp (mock/request :get "/ping"))]
      (is (= 200 status))
      (is (= content-type-plain-text headers))
      (is (= "pong" body)))))

(deftest not-found
  (testing "not-a-ping"
    (is (= response-not-found (myapp (mock/request :get "/not-a-ping")))))
  (testing "not-found"
    (is (= response-not-found (myapp (mock/request :get "/not-found")))))
  (testing "also-not-found"
    (is (= response-not-found (myapp (mock/request :get "/also-not-found"))))))



