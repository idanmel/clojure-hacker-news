(ns clojure-hacker-news.core-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.responses :refer [content-type-plain-text response-not-found]]
            [clojure-hacker-news.helpers :refer [mock-request]]))

(deftest ping
  (testing "ping"
    (let [{status :status body :body headers :headers} (mock-request "/ping")]
      (is (= 200 status))
      (is (= content-type-plain-text headers))
      (is (= "pong" body)))))

(deftest not-found
  (testing "not-a-ping"
    (is (= response-not-found (mock-request "/not-a-ping"))))
  (testing "not-found"
    (is (= response-not-found (mock-request "/not-found"))))
  (testing "also-not-found"
    (is (= response-not-found (mock-request "/also-not-found")))))
