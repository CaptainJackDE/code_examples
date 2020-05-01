module M1 where

-- Aufgabe 1
nAnd:: Bool -> Bool -> Bool
nAnd True True = False
nAnd _ _       = True

minAndMax:: Int -> Int -> (Int,Int)
minAndMax x y
  | x <= y     = (x, y)
  | y < x      = (y, x)

distance:: (Int, Int) -> (Int, Int) -> Float
distance (a, b) (x, y) = sqrt (fromIntegral(((x-a)*(x-a)) + ((y-b)*(y-b))))


--Aufgabe 2 
linGl:: (Float, Float) -> (Float, Bool)
linGl (a, b) 
  | a == 0                      = ((0.0), False)
  | otherwise                   = (((0-b)/a), True)
  
howManySolutions:: Float -> Float -> Float -> Int
howManySolutions a b c
  | a == 0 && b == 0 && c == 0 = (-1)
  | ((b/2)^2-c) == 0           = 1
  | ((b/2)^2-c) > 0            = 2
  | ((b/2)^2-c) < 0            = 0
  

--Aufgabe 3  

{-
Aufgabe 3.a
1.	Der Interpreter ließt die Zahl 5 in der Funktion fF ein.
2.	fF gibt die Variable zur Funktion fP weiter, welche prüft, ob die Zahl gleich null ist. Da 5 nicht null ist, gilt die Anweisung „otherwise“ und gibt die Variable und die Variable – 1 an fS weiter.
3.	fS rechnet aus der Zahl 5 und 4 folgendes aus: (5, 4) = (5, 4+5) = (5, 9)
-}
 
fib:: Int -> Int
fib n
  | n == 0 = 0
  | n == 1 = 1
  | n > 1  = ((fib(n-1)) + (fib(n-2)))
  
{-
Aufgabe 3.c

1. fib überprüft die Zahl auf die Wertigkeit von 0 und 1. 4 ist größer als ein, somit wird die dritte Option gewählt.
2. Der Interpreter rechnet nun das Ergebnis von n-1 (am Anfang hier 3) und n-2 (am Anfang hier 2). Dieser VOrang wir immer so oft wiederholt,
   dass n 1 ist.
3. Das Ergebnis bei fib 4 wäre hier: 3, also ist die 4. Fibonacci-Zahl die 3.   

-}


 
  
--Aufgabe 4  
type CityInfo = (String, Int)  


setPopulation:: CityInfo -> Int -> CityInfo
setPopulation (a, b) c = (a, c)

incPopulation:: CityInfo -> Int -> CityInfo
incPopulation (a, b) c = (a, (b+c))

cmpPopulation:: CityInfo -> CityInfo -> String
cmpPopulation (a1,a2) (b1,b2)
  | a2 < b2  = b1
  | b2 < a2  = a1
  | b2 == a2 = "Einwohnerzahl gleich"














