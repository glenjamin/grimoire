(defn not=
  "Same as (not (= obj1 obj2))"
  {:tag Boolean
   :added "1.0"
   :static true}
  ([x] false)
  ([x y] (not (= x y)))
  ([x y & more]
   (not (apply = x y more))))