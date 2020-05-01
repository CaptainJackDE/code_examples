module Serie5 where

-- Aufgabe 1a
comp2 :: (a -> a) -> (a -> a -> a) -> a -> a -> a
comp2 f g = \x y -> g (f x) (f y)
{-
comp2 negate (*) 3 4
12
-}

-- Aufgabe 1b
unfold p h t x
 | p x = []
 | otherwise=h x: unfold p h t (t x)

decToBin = reverse. unfold (==0) (`mod` 2) (`div`2)
{-
decToBin 12
reverse. unfold (==0) (`mod` 2) (`div`2) 12
  reverse. [0] ++ unfold (==0) (`mod` 2) (`div`2) 6
    reverse. [0] ++ [0] ++ unfold (==0) (`mod` 2) (`div`2) 3
      reverse. [0] ++ [0] ++ [1] ++ unfold (==0) (`mod` 2) (`div`2) 3
        reverse. [0] ++ [0] ++ [1] ++ [1] ++ unfold (==0) (`mod` 2) (`div`2) 1
          reverse. [0] ++ [0] ++ [1] ++ [1] ++ []
reverse [0,0,1,1]
[1,1,0,0]
-}

-- Aufgabe 1c
{-
Typ von (.) =
(.) :: (b -> c) -> (a -> b) -> (a -> c)
(f . g) x = f (g x)

Der Ausdruck f.g wird ohne Argument x im Code geschrieben, x wird erst
beim Anwenden von f.g übergeben, z.B. im Terminal.
Beispiel im Terminal:
  Prelude> let second = head . tail
  Prelude> second "asdf"
  's'
-}

-- Aufgabe 2a
{-
square x = x^2

Das Currying ermöglicht verkürzte Funktionsdefinitionen.
Die Funktion "sqlist" kann als Gleichung für Listen:
  sqlist xs = map square xs
oder als Gleichung für Funktionen genutzt werden:
  sqlist = map square
-----------
myplus:: Int -> Int -> Int
myplus x y = x+y

Curryfizierte Funktionen erlauben partielle Funktionsapplikationen.
Beispiel: Inkrementieren
  inc:: Int -> Int
  inc x = (myplus 1) x
-}

-- Aufgabe 2b
twice:: (a -> a) -> (a -> a)
twice f=f . f

iter:: Int->(a->a)->(a->a)
iter n f
  | n == 1 = f
  | otherwise = f . iter (n-1) f

potenz2:: Integer -> Integer
potenz2 x = iter (fromIntegral x) (*2) 1

-- Aufgabe 2c
f n g=foldr (.) id (replicate n g)
{-
f 3 (+5)
foldr (.) id (replicate 3 (+5))
foldr (.) id ([(+5),(+5),(+5)])
  (+5). foldr (.) id [(+5),(+5)]
    (+5).(+5) foldr (.) id [(+5)]
(+5).(+5).(+5)

"id" gibt die Eingabe wieder zurück. Sie wird zum Verbinden der Funktionen
in der Liste genommen, da (.) eine Funktion erwartet. (+5).id (+5) = (+5).(+5)
Replicate erzeugt eine Liste mit n mal x als Elemente nach dem Muster:
"replicate n x" = [x,x,...x]

Die Funktion f erwartet eine Anzahl n und eine Funktion g und erzeugt
eine Funktionskomposition mit (.) über alle Funktionen in der Liste.
(Siehe Beispiel)
-}

-- Aufgabe 3
makeLists:: [(Int,Line)] -> [([Int],Line)]
makeLists [] = []
makeLists (x:y) = [([fst x], snd x)] ++ makeLists y

amalgamate:: [([Int],Line)] -> [([Int],Line)]
amalgamate [] = []
amalgamate [([i],l)] = [([i],l)]
amalgamate (x:y:z) = if snd x == snd y
  then [((fst x ++ fst y), snd x)] ++ amalgamate z
  else [(fst x, snd x)] ++ amalgamate (y:z)

shorten:: [([Int],Line)] -> [([Int],Line)]
shorten [] = []
shorten (x:y) = if length (snd x) < 4
  then shorten y
  else [(fst x, snd x)] ++ shorten y

-- Aufgabe 4
sammeln:: [(Int,[Char])] -> [(Int,[Char])]
sammeln [] = []
sammeln x = [(sumup x (a),a)] ++ sammeln (remDouble x (a)) where
  a = snd (head x)

sumup:: [(Int,[Char])] -> [Char] -> Int
sumup [] a = 0
sumup (x:y) a = if snd x == a
  then fst x + sumup y a
  else sumup y a

remDouble:: [(Int,[Char])] -> [Char] -> [(Int,[Char])]
remDouble [] a =[]
remDouble (x:y) a = if snd x == a
  then remDouble y a
  else x: remDouble y a


-- creating an index --
-----------------------

type Doc = String
type Line = String
type TWord = String

infixl 9 >.>

(>.>):: (a  -> b) -> (b -> c) -> (a -> c)
g >.> f = f.g



-- makeIndex:: Doc ->  [([Int],TWord)]
makeIndex =
  lines
  >.> numLines
  >.> allNumWords
  >.> sortLs
-- to be implemented by you ;-)
  >.> makeLists
  >.> amalgamate
  >.> shorten



numLines:: [Line] -> [(Int,Line)]
numLines lines =  zip [1..length lines] lines

-----------

allNumWords:: [(Int,Line)] -> [(Int,TWord)]
allNumWords =  concat.map numWords
  where
    numWords (i,line) = map (\w -> (i,w)) (splitWords line)


splitWords:: Line -> [TWord]
splitWords line =  filterWords (words line)
  where
     filterWords ws = filter (/= "") (map filterSeparators ws)
     filterSeparators w = [ s | s <- w, notElem s [',',';',':','.','!','?','(',')','-'] ]


-----------

sortLs:: [(Int,TWord)] -> [(Int,TWord)]
sortLs [] = []
sortLs (p:ps) =
  (sortLs [ q | q<-ps, orderPair q p]) ++ [p] ++ (sortLs [ q | q<-ps, orderPair p q])

orderPair:: (Int,TWord) -> (Int,TWord) -> Bool
orderPair (n1,w1) (n2,w2) =  w1<w2 || (w1==w2 && n1<n2)

-----------

test1 = "Die  Elemente, einer Datenstruktur werden dabei gleichartig behandelt. \n Die Struktur bleibt dabei erhalten.\n Eine  Identifikation von Rekursionsmustern (Berechnungsmustern) \n und die Implementation durch Funktionen hoeherer Ordnung ist moeglich."

test2 = "War einmal ein Bumerang; \n War ein Weniges zu lang..."
