(ns wordy-word.word-list
  (:require [clojure.pprint :refer [pprint]]))

(defn read-lines [file]
  (try
    (-> (clojure.java.io/resource file)
        slurp
        clojure.string/split-lines)
    (catch Throwable _
      [])))

(def unapproved-nouns (atom (read-lines "unapproved-nouns")))
(def unapproved-adjectives (atom (read-lines "unapproved-adjectives")))
(def approved-nouns (atom (read-lines "approved-nouns")))
(def approved-adjectives (atom (read-lines "approved-adjectives")))

(defn save! []
  ; TODO
  )

(defn accept! [ballot]
  (swap! (:atom ballot) into (:words ballot))
  (save!))
