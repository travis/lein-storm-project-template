(ns {{ns-name}}.topology
  "Topology

More info on the Clojure DSL here:

https://github.com/nathanmarz/storm/wiki/Clojure-DSL"
  (:require [{{ns-name}}
             [spouts :refer [type-spout]]
             [bolts :refer [stormy-bolt {{name}}-bolt]]]
            [backtype.storm [clojure :refer [topology spout-spec bolt-spec]] [config :refer :all]])
  (:import [backtype.storm LocalCluster LocalDRPC]))

(defn stormy-topology []
  (topology
   {"spout" (spout-spec type-spout)}

   {"stormy-bolt" (bolt-spec {"spout" ["type"]} stormy-bolt :p 2)
    "{{name}}-bolt" (bolt-spec {"stormy-bolt" :shuffle} {{name}}-bolt :p 2)}))

(defn run! [& {debug "debug" workers "workers" :or {debug "true" workers "2"}}]
  (doto (LocalCluster.)
    (.submitTopology "stormy topology"
                     {TOPOLOGY-DEBUG (Boolean/parseBoolean debug)
                      TOPOLOGY-WORKERS (Integer/parseInt workers)}
                     (stormy-topology))))