
%  Matteo Jacob 218203360, Maurice Ihlow 218203150, Frederik Schilling 218204061, Tobias Banke 216201267, Emin Heydarzada 218200172

% Aufgabe 1

% a)

/*
L ist eine Liste von Werten.
E ist ein Wert, der in L enthalten ist.
R ist die Restliste ohne E.
Dabei ist es egal an welcher Stelle E in L steht.
Allerdings wenn E mehrfach vorkommt, wird nur das erste Vorkommen von links gelöscht.
*/

% b)

blup([],_,[]).
blup([X|X1],X, X1).
blup([X|X1],Y,(X|X2)):- blup(X1,Y,X2),!.


% c)

/*

    blup([1,2,3], 2, R)
          |
          |
append([1],[2|3],[1,2,3]), append([1],[3],R)    R = [1,3]
          |
          |
        false

----------------------------------------------------------------------------------------------------------------
                                                    blup([1,2], E, R)
                                                            |
                    ________________________________________|____________________________________________       
                    |                                                                                   |
                    |                                                                                   |
append([],[E|2],[1,2]),append([],[2],R)  E = 1, R = [2]                         append([1],[E|[]],[1,2]),append([1],[E],R)        E = 2, R = [1]
                    |                                                                                    |
                    |                                                                                    |
                 false                                                                                  false

-----------------------------------------------------------------------------------------------------------------
    blup([1,2,3], 2, R)  R = 1
            |
            |
    blup([2,3],2,R)     R = [1,3]
            |
            |
            []

-----------------------------------------------------------------------------------------------------------------
                                            blup([1,2], E, R)
                                                   |
             ______________________________________|__________________________________
            |                                                                        |
            |                                                                        |
    blup([1,2],E,R)   E = 2, R = [1]                                      blup([1,2],E,R)   E = 1, R = [2]
            |                                                                       |
            |                                                                       |
    blup([2],E,R)   E = 2,   R = [1]                                                []
            |
            |
            []                       

*/

% Aufgabe 2

simplify(X, X) :- atom(X); number(X).

simplify(X+0,X):-simplify(X,X),!.
simplify(0+X,X):-simplify(X,X),!.
simplify(1*X,X):-simplify(X,X),!.
simplify(X*1,X):-simplify(X,X),!.
simplify(X*0,0):-simplify(X,X),!.
simplify(0*X,0):-simplify(X,X),!.
simplify(X/1,X):-simplify(X,X),!.
simplify(X-0,X):-simplify(X,X),!.
simplify(X-X,0):-simplify(X,X),!.

simplify(-(X), Y) :- number(X), abs(X,Z), simplify(Z,Y),  X < 0, !.
simplify(-(-X),Y) :- simplify(X,Y), !.


simplify(-(X + Y),(-X1) + (-Y1)) :- simplify(X,X1), simplify(Y,Y1),!.
simplify(-(X * Y),(-X1) * Y1) :- simplify(X,X1), simplify(Y,Y1),!.



simplify(X+Y, Z) :- simplify(X, X1), simplify(Y, Y1), (( number(X), number(Y), Z is X + Y) ; Z = X1 + Y1).
simplify(X-Y, Z) :- simplify(X, X1), simplify(Y, Y1), (( number(X), number(Y), Z is X - Y) ; Z = X1 - Y1).
simplify(X*Y, Z) :- simplify(X, X1), simplify(Y, Y1), (( number(X), number(Y), Z is X * Y) ; Z = X1 * Y1).
simplify(X/Y, Z) :- simplify(X, X1), simplify(Y, Y1), (( number(X), number(Y), Z is X / Y) ; Z = X1 / Y1).

% Aufgabe 3

/*
?- simplify(3*1+0,X).
X = 3*1.

?- simplify(3*x*1+x*(3*1) ,X).
X = 3*x+x*3.

?- simplify(0,X).
X = 0.

*/

% Aufgabe 4

% http://www.swi-prolog.org/pldoc/man?section=allsolutions http://www.swi-prolog.org/pldoc/man?section=forall2

% a)
border(sn,lwl).
border(sn,nwm).
border(lwl,nwm).
border(lwl,lro).
border(lwl,mse).
border(mse,lro).
border(mse,vr).
border(mse,vg).
border(vg,vr).
border(vr,lro).
border(lro,hro).
border(lro,nwm).

% b)

% counties(CS):- findall(X,(border(X, CS);border(CS,X)) ,X ).

neighbours(C,N) :- findall(X, (border(C,X);border(X,C)),N).

% c)

listcountries([sn, lwl, nwm, lro, mse, vr, vg, hro]).

colours([red,yellow,blue,green]).



