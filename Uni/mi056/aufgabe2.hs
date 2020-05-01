module Serie2 where

--Aufgabe 1
divisors:: Int -> [Int]
divisors a = [x | x <- [1..a], a `mod` x == 0, x /= 0]

--Aufgabe 1b
repl:: Int -> Int -> [Int]
repl a n = [a | _ <- [1..n]]

--Aufgabe 1c
perfect:: Int -> [Int]
perfect n = [x | x <- [1..n], sum(init(divisors(x))) == x]

--Aufgabe 2a
replre:: Int -> Int -> [Int]
replre a n = take n (repeat a)

--Aufgabe 2b
{-
Zunächst überprüft die Funktion ob eine leere Liste eingegeben wurde.
Da dies nicht der Fall ist, wird die zweite Operation ausgeführt. Dort werden die Listenelemente zusammen in eine gemeinsame Liste (Z3) zusammengeführt.
-}

--Aufgabe 2c
myUnion:: Eq a => [a] -> [a] -> [a]
myUnion _ [] = []
myUnion [] _ = []
myUnion xs ys = dupl $ xs ++ ys where
  dupl [] = []
  dupl (x:xs)
    | not $ elem x xs = x : dupl xs
    | otherwise = dupl xs

-- Aufgabe 3
type Person = String
type Book = String
type Database = [(Person,Book)]
exampleDB:: Database
exampleDB =
 [("Leon", "Tintenherz"),
 ("Johann", "Tintenblut"),
 ("Arthur", "Im Westen nichts Neues"),
 ("Peter", "Tintenherz"),
 ("Jonas", "Der Schimmelreiter"),
 ("Johann", "Theoretische Grundlagen der Informatik")]
 
 
books:: Person -> Database -> [Book]
books person db = [b | (p,b) <- db, p == person]
 
borrowers:: Book -> Database -> [Person]
borrowers book db = [b | (p,b) <- db, b == book]
 
borrowed:: Book -> Database -> (Bool,Int)
borrowed book db
  | length (borrowers book db) == 0 = (False,0)
  | length (borrowers book db) > 0 = (True, length (borrowers book db))

numBorrowed:: Person -> Database -> Int
numBorrowed person db = length (books person db)


--Aufgabe 4

createTupleList:: Int -> [(Int,Int)]
createTupleList a = zip [1..a] [a, a-1..1]
  
split:: [a] -> ([a],[a])
split a
  | x == 0 = ((take b a), (drop b a))
  | x == 1 = ((take b a), (drop (b) a))
  where x = mod (length a) 2
        b = quot (length a) 2