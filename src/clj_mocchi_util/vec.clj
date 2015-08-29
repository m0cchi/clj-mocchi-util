(ns clj-mocchi-util.vec)

(defn to-hash
  "vector to hash.
  [\"key\" \"value\"]
   => {:key \"value\"}"
  ([vec]
   (let [len (count vec)]
     (if (and (even? len)
              (> len 1))
       (to-hash (first vec) (rest vec) {})
       {})))
  ([key-string vec hash]
   (to-hash (keyword key-string) (first vec) (rest vec) hash))
  ([key value vec hash]
   (merge (to-hash vec) {key value})))
