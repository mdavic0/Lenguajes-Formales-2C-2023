;; EJ PARCIAL:
(defn indexar_lista [l]
  (map-indexed list l)  
)
; DADA LA LISTA '(5 6 8)   retorna -> ((0 5) (1 6) (2 8))

(defn sumar_notas [m]
  (map (partial reduce +) m)  
)
; dada una matriz de notas (lista de listas)
;; (def notas '((2 5 6) (3 5 4) (2 8 9)))         retorna -> (13 12 19) 

(defn maxima_nota [l]
  (apply max-key second l)  
)
; recibe la lista indexada ((0 5) (1 6) (2 8)) y retorna ->    (2 8)

(defn mejor_alumno [alumnos notas]
  (let [suma_por_alumno (sumar_notas notas)]
    (nth alumnos (first (maxima_nota (indexar_lista suma_por_alumno))) "error")
  )
)
; entonces el mejor alumno sera aquel que tenga mayor suma de notas:
; se calcula la suma de notas por alumno, se indexa esa lista y se calcula la maxima nota: (2 8)
; luego se obtiene el index de esa nota (primer elemento) y con ese index se obtiene el nombre del alumno -> "Pedro"

(def alumnos '("Juan" "Pepe" "Pedro"))
(def notas '((2 5 6) (3 5 4) (2 8 9)))

(println (mejor_alumno alumnos notas))