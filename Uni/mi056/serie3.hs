import Data.Char

--Aufgabe 1

{-
a)
foo:: [Int] -> [Int]
Es wird eine Liste "angefordert" mit [], und es wird [] ausgegeben. Demnach muss eine Liste eingegeben und eine Ausgegeben werden.


bar:: Int -> [Int] -> [Int]
Es werden eine Zahl und eine Liste gefordert und es wird eine Liste ausgegegeben. Dies ist wie in foo an [] und hier neu an x erkennbar.

b)
----


c)
foo dreht die Reihenfolge der Elemente einer Liste um und arbeitet demnach genau wie der Befehl "reverse".
bar fügt den eingegebene Wert am Anfang einer Liste hinzu und erweitert diese folglich um eine Element. Die urspüngliche Liste wird so nicht verändert.



-}
--Aufgabe 2

--a

reduce:: (Int,Int) -> (Int,Int)
reduce (p,q) = let groessterTeiler = gcd p q in (div p groessterTeiler,div q groessterTeiler)

--b

zipMin:: (Ord a)=> [a]->[a]->[a] 
zipMin [][] = []
zipMin (x:xs) (y:ys) 
    |x < y = x: zipMin xs ys
    |y <= x = y: zipMin xs ys

--c

mult:: Int -> Int -> Int 
mult a b 
    |b > 0 = a + (mult a (b-1))
    |b < 0 = (negate a) + (mult a (b+1))
    |b == 0 = 0 

--Aufgabe 3

--a

concatR:: [[a]]->[a]
concatR liste = foldr (++) [] liste

concatL:: [[a]]->[a]
concatL liste = foldl (++) [] liste

--b

maxList:: [Int] -> Int
maxList (x:xs) = foldr max x xs

--Aufgabe 4

--a

type SymbolTabelle = [(Char,Int)]

symTabelle = [('a',7),('b',7)]


eval_pn_expr:: String -> SymbolTabelle -> Int
eval_pn_expr s sym = fst (eval s sym)
    where
    eval:: String ->SymbolTabelle -> (Int,String)
    eval [] sym = (0,[])
    eval ('+':xs) sym =
       let (v1,xs1) = eval xs sym
           (v2,xs2) = eval xs1 sym
       in (v1+v2,xs2)
    eval ('*':xs) sym =
       let (v1,xs1) = eval xs sym
           (v2,xs2) = eval xs1 sym
       in (v1*v2,xs2)
    eval (x:xs) sym = if isDigit x
                  then (digitToInt x,xs)
                  else error "Fehler"
                  

--b

type Picture = [String]
horse:: Picture
horse = 
    [".......##...",".....##..#..","...##.....#.","..#.......#.","..#...#...#.","..#...###.##",
    "..#...#..##.","..#...#.....","...#...#....","....#..#....",".....#.#....","......##...."]
draw:: Picture -> IO ()
draw h = putStrLn (unlines h)

flipV:: Picture -> Picture
flipV pic = map reverse pic

flipH:: Picture -> Picture
flipH pic = reverse pic

cross:: Picture
cross = 
    [".....##.....",".....##.....","..########..",".....##.....",".....##.....",".....##.....",".....##....."]