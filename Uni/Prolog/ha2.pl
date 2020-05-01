ableitung(F, X, FA) :- diff(F, X, FA1), simplify(FA1, FA2), evaluate(FA2, FA3), simplify(FA3, FA), !.


diff(K,X,0) :- atomic(K), K\==X.
diff(-F,X, -FA) :- diff(F,X,FA). %Vorzeichenregel
diff(X,X,1). %diff von x
diff(F+G, X, FA+GA) :- diff(F,X,FA), diff(G,X,GA). %Summenregel
diff(F-G, X, FA-GA) :- diff(F,X,FA), diff(G,X,GA). %Differenzenregel
diff(K*F,X,K*FA) :- atom(K,X), diff(F,X,FA). %Faktorregel
diff(F*G,X,F*GA+G*FA) :- diff(F,X,FA), diff(G,X,GA). %Produktregel
diff(F/G,X,(F*GA-G*FA)/(G*G)) :- diff(F,X,FA), diff(G,X,GA). %Quotientenregel

%Grundfunktionen
diff(sin(X),X,cos(X)).
diff(cos(X),X,-sin(X)).
diff(-sin(X),X,-cos(X)).
diff(-cos(X),X, sin(X)).
diff(e(X),X,e(X)).
diff(ln(X),X,1/X).
diff(X^N, X, N*X^(N - 1)) :- atom(N,X).
atom(K,X) :- atomic(K), K\==X.

simplify(X1 + X2, V) :- simplify(X1, X1v), simplify(X2, X2v), sum(X1v + X2v, V).
simplify(X1 - X2, V) :- simplify(X1, X1v), simplify(X2, X2v), sum(X1v - X2v, V).
simplify(X,V)        :- not(plus(X)), not(minus(X)), simplify2(X,V).
simplify2(X1 * X2,V) :- simplify2(X1,X1v), simplify2(X2,X2v), product(X1v * X2v, V).
simplify2(X1 / X2,V) :- simplify2(X1,X1v), simplify2(X2,X2v), product(X1v / X2v, V).
simplify2(X,X)       :- not(multi(X)), not(division(X)).

plus(_ + _).
minus(_ - _).
multi(_ * _).
division(_ / _).

sum(0 + X, X).
sum(X + 0, X).
sum(X1 + X2, X) :- integer(X1), integer(X2), X is X1 + X2.
sum(0 - X1, X) :- integer(X1), X is -X1.
sum(X - 0, X).
sum(X1 - X2, X) :- integer(X1), integer(X2), X is X1 - X2.
sum(A + B, B + A) :- not(integer(A)), integer(B).
sum(X - X, 0).
sum(A*X - X, S) :- sum(A - 1, A1), product(A1 * X, S).
sum(X - A*X, S) :- sum(1 - A, A1), product(A1 * X, S).
sum(A*X - B*X, S) :- sum(A - B, A1), product(A1 * X, S).
sum(A*X + B*X, S) :- sum(A + B, A1), product(A1 * X, S).
sum(X1 + (X2 + X3), X4 + X3) :- simplify(X1 + X2, X4).
sum(X, X).

product(X / X, 1).
product(A*X,A*X) :- not(number(X)).
product(0 * _, 0).
product(_ * 0, 0).
product(X * 1, X).
product(1 * X, X).
product(X1 * X2, X) :- number(X1), number(X2), X is X1 * X2.
product(_ / 0,_) :- fail.
product(X / 1, X).
product(X1 / X2, X) :- number(X1), number(X2), X is X1 / X2.
product(A * B, B * A).

evaluate(X,X) :- atomic(X).
evaluate(X,X) :- var(X).
evaluate(X1,X2) :- X1 =.. [F|N], list(N,M), X3 =.. [F|M], simple(X3,X2).

list([],[]).
list([N|M],[O|P]) :- evaluate(N,O), list(M, P).

simple(X1 + X2, W) :- number(X1), number(X2), W is X1 + X2.
simple(X1 - X2, W) :- number(X1), number(X2), W is X1 - X2.
simple(X1 * X2, W) :- number(X1), number(X2), W is X1 * X2.
simple(X1 / X2, W) :- number(X1), number(X2), W is X1 / X2.
simple(X1 mod X2, W) :- number(X1), number(X2), W is X1 mod X2.
simple(-X, W) :- number(X), W is -X.
simple(X,X).
