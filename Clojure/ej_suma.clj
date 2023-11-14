; Ej sumar n numeros: 
(defn sumar
    ([x] x)
    ([x & args]
    (+ x (reduce + args)))
)

(println(sumar 1))
(println(sumar 1 2))
(println(sumar 1 2 3))
