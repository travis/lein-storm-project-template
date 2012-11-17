(ns leiningen.new.storm-project
  (:use [leiningen.new.templates :only [renderer name-to-path sanitize-ns ->files year]]))

(def render (renderer "storm-project"))

(defn storm-project
  [name]
  (let [data {:name name
              :ns-name (sanitize-ns name)
              :sanitized (name-to-path name)
              :year (year)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/{{sanitized}}/bolts.clj" (render "bolts.clj" data)]
             ["src/{{sanitized}}/spouts.clj" (render "spouts.clj" data)]
             ["src/{{sanitized}}/topology.clj" (render "topology.clj" data)]
             ["src/{{sanitized}}/TopologySubmitter.clj" (render "TopologySubmitter.clj" data)]
             ["test/{{sanitized}}/core_test.clj" (render "core_test.clj" data)])))