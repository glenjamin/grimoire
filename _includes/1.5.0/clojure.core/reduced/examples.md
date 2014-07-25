`reduced` allows you to short-circuit a call to `reduce`, ending the reduction early.

```clj
(reduce (fn [a v] (if-not (a v) (conj a v) (reduced a))) 
         #{} 
         infinite-lazy-sequence)
 => #{1 2 3 4}
 ```
