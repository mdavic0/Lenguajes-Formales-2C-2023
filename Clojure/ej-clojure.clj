; Ej sumar n numeros: 
(defn sumar
    ([x] x)
    ([x & args]
    (+ x (reduce + args)))
)

(println(sumar 1))
(println(sumar 1 2))
(println(sumar 1 2 3))


;"EJ:1. Definir la función tercer-angulo que reciba los valores de dos de
;los ángulos interiores de un triángulo y devuelva el valor del restante."

((fn [a b] (- 180 (+ b a) )) 50 30)

(defn tercer-angulo [a b] (- 180 (+ b a) ))

version pro:

(defn tercer-angulo [angulo1, angulo2]
    (cond
        (> 0 angulo1) (printl "Error, angulo 1 Neg")
        (> 0 angulo2) (printl "Error, angulo 2 Neg")
        (< 180 (+ angulo1 angulo2)) (printl "Error suma mayor a 180")
        :else (printl (- 180 (+ angulo1 angulo2)))
    )
)

ej: (tercer-angulo 20 60)
     ->   100
     (tercer-angulo 20 1860)
     -> Error suma mayor a 180

;"Clojure Practica 17/10/2023"
 
 ;"Ej2. Definir la función segundos que reciba los cuatro valores 
 ;(días, horas, minutos y segundos) del tiempo que dura un evento
 ; y devuelva el valor de ese tiempo expresado solamente en segundos."

(defn segundos [dias horas minutos segs]
    (cond
        (> 0 dias) (println "Error, dias Neg")
        (or (> horas 24) (> 0 horas)) (println "Error, horas Neg")
        (or (> minutos 60) (> 0 minutos)) (println "Error, minutos Neg")
        (or (> segs 60) (> 0 segs)) (println "Error, segundos Neg")
        :else (
               println (+ (* minutos 60) (* horas 3600) (* dias 86400) segs)
  
               )
    )
)

(segundos 1 0 0 0)

;"EJ5. Definir la función capicua? que reciba un número entero no negativo
; de hasta 5 dígitos y devuelva true si el número es capicúa; si no, false."

 (defn es-capicua? [n]
  (cond
      (> 0 n) (println "Error, numero Neg")
      (> n 99999) (println "Error, numero mayor a 5 cifras")
      :else (
             println (= (str n) (apply str (reverse (str n))))
            )
  )
)

(es-capicua? 121)
(es-capicua? 123)
(es-capicua? 123255)
(es-capicua? -123)



24/10/2023
;#####################################################################
FUNCIONES DE ORDEN SUPERIOR IMPORTANTES
    Apply
        OBS: Lo que hace es desempaquetar el parametro que esta en la lista 
        ej: (println (apply str '(a b c)))
        -> abc

        en este caso es lo mismo que hacer (str 'a 'b 'c)

        ej2: (println (apply list '((ab) c d)))
            -> ((ab) c d)
            es decir, equivale a hacer
            (println (list '(ab) 'c 'd))
            -> ((ab) c d)
    Map 
        ej: (map + '(1 2 3) '(4 5 6) '(7 8))
            da (12 15)
            OBS: SI TIENE + DE UN ARG INTENTA EVALUAR USANDO LOS INDEX DE CADA ELEMENTO (en este caso hace la suma
            de el prmer elem de cada secuencia -> 1 + 4 + 7 = 12, luego del segundo elem de cada sec -> 2 + 5 + 8 = 15, 
            luego como no todos los arg tienen la misma cantidad de elementos, entonces corta). 

        ej: (map first '((1 2 3) (4 5 6)))
            da (1 4)

            OBS: SI TIENE 1 SOLO ARGUMENTO FUNCIONA COMO EL MAP DE TODA LA VIDA (EL alfa DE APL)
    Reduce
        (println (reduce + '(2 3 5 4)))
        -> 14
        OBS: El reduce recibe una funcion y una secuencia, es igual que el /+ de APL, es decir ejecuta entre
        cada elemento de la secuencia pero a diferencia de APL lo hace de izq a derecha
        
        -> En el ejemplo: (2+3) 5 4
                            (5 + 5) 4
                            (10 + 4) = 14


    map-indexed 
        ej: (map-indexed list '(1 2 3 4))
        -> ((0 1) (1 2) (2 3) (3 4))

    Partial

    Comp
        Ej: (println ( (comp first second second) '(1 (33 ( 5 4))) ) )
            Esto es componer funciones, y se aplican de derecha a izquierda
            en este caso a la secuencia '(1 (33 ( 5 4))) le aplica second y resulta
            (33 ( 5 4)) a esta nueva secuencia le aplica second nuevamente y resulta 
            ( 5 4) finalmente aplica first por lo que el resultado es 5



;######################################################################################
Ej 12) Definir la función repartir que, llamada sin argumentos, devuelva la 
cadena "Uno para vos, uno para mí". De lo contrario, se devolverá una lista, 
en la que habrá una cadena "Uno para X, uno para mí" por cada argumento X.

(defn reparto [x]
  (str "Uno para " x ", uno para mi\n"))

(defn repartir
  ([] ["Uno para vos, uno para mí"])
  ([& args] (map reparto args)))

(println (repartir))
(println (repartir "Juan"))
(println (repartir "Juan" "Roman" "Riquelme"))

EJ 13). Definir una función para producir una lista con los elementos en las posiciones pares de dos listas dadas.

(defn lista_pares [lista1 lista2]
    (concat (map second(partition 2 lista1)) (map second(partition 2 lista2)))
)

(println (lista_pares '(2 4 5 7 6) '(5 9 8 7 7)))
    -> (4 7 9 7)


EJ) 15. Definir una función para eliminar las ocurrencias de un dato escalar en una lista (a todo nivel).

(defn eliminar-ocurrencias [dato lista]
  (if (empty? lista)
    '()
    (let [primer-elemento (first lista)
          resto (rest lista)]
      (cond
        (coll? primer-elemento) (cons (eliminar-ocurrencias dato primer-elemento) (eliminar-ocurrencias dato resto))
        (= primer-elemento dato) (eliminar-ocurrencias dato resto)
        :else (cons primer-elemento (eliminar-ocurrencias dato resto))))))

(def mi-lista [1 2 [3 4 [5 6 7] 8] 9 [10 [11 12] 13] 14])
(def dato-a-eliminar 3)

(def resultado (eliminar-ocurrencias dato-a-eliminar mi-lista))
(println resultado) ; Devuelve '(1 2 (4 (5 6 7) 8) 9 (10 (11 12) 13) 14)


;########################################################
TAREA PARA EL 31/10/2023
De forma recursiva, no recursiva, y mostrar ejemplos de uso:
; 21. Definir una función para obtener la matriz triangular superior (incluyendo la diagonal 
; principal) de una matriz cuadrada que está representada como una lista de listas.

;; Sin recursividad:
(defn matriz-triangular [matriz]
  (let [n (count matriz)]
    (for [i (range n)]
      (for [j (range n)]
        (if (<= i j) (get-in matriz [i j]) 0)
      )
    )
  )
)

;forma recursiva
(defn mat-triangular-rec
  ([m] (mat-triangular-rec m 0 (count m)))
  ([m i n] (if (empty? m) m
               (cons (concat (repeat i 0) (drop i (first m)))
                     (mat-triangular-rec (rest m) (inc i) n)
                )
            )
  )
)

(def matriz-ejemplo [[1 2 3]
                     [4 5 6]
                     [7 8 9]])

(println "EJ.21) SIN RECURSIVIDAD")
(println (matriz-triangular matriz-ejemplo) "\n")

(println "EJ.21) CON RECURSIVIDAD")
(println (mat-triangular-rec matriz-ejemplo))

22. Definir una función para obtener la diagonal principal de una matriz cuadrada que está representada como una lista de listas.
;; Sin recursividad:
(defn matriz-diagonal-ppal [matriz]
  (let [n (count matriz)]
    (for [i (range n) j (range n) :when (= i j)]
      (get-in matriz [i j])
    )
  )
)

;forma recursiva
(defn mat-diagonal-ppal-rec [m]
  (if (empty? m) m
      (cons (ffirst m) (mat-diagonal-ppal-rec (map rest (rest m))))
  )
)


(def matriz-ejemplo [[1 2 3]
                     [4 5 6]
                     [7 8 9]])

(println "EJ.22) SIN RECURSIVIDAD")
(println (matriz-diagonal-ppal matriz-ejemplo) "\n")

(println "EJ.22) CON RECURSIVIDAD")
(println (mat-diagonal-ppal-rec matriz-ejemplo))

; CLASE 31/10/2023
;30. Definir la función slice que reciba una cadena cad y un número n y devuelva una lista
;con todas las subcadenas contiguas de cad cuyo tamaño sea n. Por ejemplo:
; (slice "abcde" 3) → ("abc" "bcd" "cde")

(defn aux [letras]
  (apply str letras)
)
(defn slice [cad n]
  (map aux (partition n 1 cad))  
)

(println (slice "abcde" 3))


;35. Definir las funciones filas-max-V y mas-V-o-F que, 
; aplicadas a una matriz de V y F (una lista de listas con los valores V y F), devuelvan, respectivamente:

;; a) El/los número/s de la/s fila/s en la/s que la cantidad de V es máxima, por ejemplo:
;; (filas-max-V '((V F V V F)(V V F V V)(F F F V F)(V V V F V))) → (2 4)

(defn contar-V [fila]
  (get (frequencies fila) `V)
)

(defn contar-F [fila]
  (get (frequencies fila) `F)
)

; (println (contar-V `(V F V V F)))
;(println (get (frequencies `(V F V V F)) `V))
;(println (contar-F `(V F V V F)))

;; a) El/los número/s de la/s fila/s en la/s que la cantidad de V es máxima, por ejemplo:
;; (filas-max-V '((V F V V F)(V V F V V)(F F F V F)(V V V F V))) → (2 4)

(defn indicesMaximos [cantidadMax i lista]
  (cond (= (contar-V lista) cantidadMax) (+ i 1))
)

(defn !nil? [a]
 (cond (not (nil? a)) a) 
)

(defn filas-max-V [mat]
    (let [cantidadMax (apply max (map contar-V mat))]
      (filter !nil? (map-indexed (partial indicesMaximos cantidadMax) mat))
    )
)

(println "EJ 35 a)")
(println (filas-max-V `((V F V V F) (V V F V V) (F F F V F) (V V V F V))))

;; b) V si en la mayoría de las filas hay más V que F o, de lo contrario, F, por ejemplo:
;; (mas-V-o-F '((V F V V F)(F F F V F)(V V F F V))) → V



IMPORTANTE PARA EL PARCIAL APRENDER: 
(defn transponer [l1] (apply map list l1) )

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