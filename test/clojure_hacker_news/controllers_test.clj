(ns clojure-hacker-news.controllers-test
  (:require [clojure.test :refer :all]
            [clojure-hacker-news.responses :refer [response-plain-text]]
            [clojure-hacker-news.controllers.post :as post-controller]))

(deftest create-post
  (testing "post created"
    (is (= (response-plain-text "post created" 201) (post-controller/post-create-response :ok))))
  (testing "post not created"
    (is (= (response-plain-text "post creation failed" 500) (post-controller/post-create-response :error)))))
