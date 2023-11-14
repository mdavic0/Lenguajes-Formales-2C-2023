;; EJ 13). Definir una función para producir una lista con los elementos en las posiciones pares de dos listas dadas.

(defn lista_pares [lista1 lista2]
    (concat (map second(partition 2 lista1)) (map second(partition 2 lista2)))
)

(println (lista_pares '(2 4 5 7 6) '(5 9 8 7 7)))
;; retorna -> (4 7 9 7)   ^   ^        ^   ^

