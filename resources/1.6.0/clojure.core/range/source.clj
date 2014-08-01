(defn range
  "Returns a lazy seq of nums from start (inclusive) to end
  (exclusive), by step, where start defaults to 0, step to 1, and end to
  infinity. When step is equal to 0, returns an infinite sequence of
  start. When start is equal to end, returns empty list."
  {:added "1.0"
   :static true}
  ([] (range 0 Double/POSITIVE_INFINITY 1))
  ([end] (range 0 end 1))
  ([start end] (range start end 1))
  ([start end step]
   (lazy-seq
    (let [b (chunk-buffer 32)
          comp (cond (or (zero? step) (= start end)) not=
                     (pos? step) <
                     (neg? step) >)]
      (loop [i start]
        (if (and (< (count b) 32)
                 (comp i end))
          (do
            (chunk-append b i)
            (recur (+ i step)))
          (chunk-cons (chunk b) 
                      (when (comp i end) 
                        (range i end step)))))))))