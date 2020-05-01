import Data.Char

--Aufgabe 1

--a

halve:: [a] ->([a],[a])
halve liste = (gr liste, ungr liste)
    where
        gr:: [a]-> [a]
        gr (x:xs) = x: ungr xs
        gr _ = []
        ungr:: [a]-> [a]
        ungr (_:xs) = gr xs
        ungr _ = []

--b

f:: [a]-> [a]
f xs = foldr (++) [] (map sing xs)
        where
            sing x = [x]

{-
map sing  ["an","auf","unter"] = [["an"],["auf"],["unter"]]
foldr (++) [] [["an"],["auf"],["unter"]] = ["an"] ++ foldr (++) [] [["auf"],["unter"]]
foldr (++) [] [["auf"],["unter"]] = ["auf"] ++ foldr (++) [] ["unter"]
foldr (++) [] [["unter"]] = ["unter"] ++ []
foldr (++) [] (map sing ["an","auf","unter"]) = ["an"] ++(["auf"] ++ (["unter"] ++ []) ) = ["an","auf","unter"]

Die Funktion liefert die Identität einer Liste.
-}

--Aufgabe 2

largestProduct:: Int -> String -> Int
largestProduct n m = maximum (listProducts n m)
            where
                listProducts n m
                    |length m < n = []
                    |otherwise = (product (take n (map digitToInt m)): listProducts n (tail m))

--Aufgabe 3

--a

{-
λf.λx.(f x) (λx.(x ∗ x)) 3      ->β λx.(λx.(x ∗ x) x) 3       R: λf.λx.(f x) (λx.(x ∗ x))
λx.(λx.(x ∗ x) x) 3             ->β λx.(x ∗ x) 3              R: (λx.(x ∗ x) x) 
λx.(x ∗ x) 3                    ->β 3 * 3                     R: λx.(x ∗ x) 3 
3 * 3                           ->δ 9                         R: 3 * 3
-}

--b

{-
AND FALSE E2                    ≡ λx.λy.x y FALSE FALSE E2
λx.λy.(x y FALSE) FALSE E2      ->β λy.(FALSE y FALSE) E2      R: λx.λy.(x y) FALSE
λy.(FALSE y FALSE) E2           ->β FALSE E2 FALSE             R: λy.(FALSE y) FALSE
FALSE0 E2 FALSE E2              ≡ λx.λy.y E2 FALSE 
λx.λy.y E2 FALSE                ->β λy.y FALSE                 R: λx.λy.y E2
λy.y FALSE                      ->β FALSE                      R: λy.y FALSE 
-}

--c

{-
AND TRUE E2                     ≡ λx.λy.x y FALSE TRUE E2
λx.λy.x y FALSE TRUE E2         ->β λy.y FALSE TRUE  E2        R: λx.λy.x y
λy.y FALSE TRUE  E2             ->β FALSE TRUE  E2             R:  λy.y FALSE
FALSE TRUE  E2                  ≡ λx.λy.y TRUE E2
λx.λy.y TRUE E2                 ->β λy.y E2                    R: λx.λy.y TRUE
λy.y E2                         ->β E2                         R: λy.y E2 
-}

--Aufgabe 4

--a

sqrts_1:: [Int]->[Float]
sqrts_1 (x:xs) = (sqrt( fromIntegral x): sqrts_1 xs)
sqrts_1 [] = []

sqrts_2:: [Int]-> [Float]
sqrts_2 liste = [sqrt (fromIntegral x)|x <-liste]

sqrts_3:: [Int]->[Float]
sqrts_3 liste = map sqrt ( map fromIntegral liste)

--b

summatrix_1:: [[Int]] -> Int
summatrix_1 (x:xs) 
    |xs == [] = sum  x
    |otherwise =  (sum x) + summatrix_1 xs
 
summatrix_2:: [[Int]] -> Int
summatrix_2 liste = sum (map sum liste)

summatrix_3:: [[Int]] -> Int
summatrix_3 liste = sum (foldr (++) [] liste)

summatrix_4:: [[Int]] -> Int
summatrix_4 liste = sum (foldl (++) [] liste)