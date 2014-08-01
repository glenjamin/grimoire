(defn rename
  "Returns a rel of the maps in xrel with the keys in kmap renamed to the vals in kmap"
  {:added "1.0"}
  [xrel kmap]
  (with-meta (set (map #(rename-keys % kmap) xrel)) (meta xrel)))