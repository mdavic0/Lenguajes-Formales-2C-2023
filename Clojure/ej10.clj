; 10. Definir la función pot? que reciba dos números naturales y devuelva true si el primero es potencia del segundo; si no, false.

(defn pot? [x y]
  (cond 
    (or (neg? x) (neg? y)) (println "Error. Los numeros no pueden ser negativos!")
    (= x 1) true
    (< x y) false
    :else (pot? (/ x y) y)))

(println (pot? 16 2))