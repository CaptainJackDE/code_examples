Matteo Jacob - MNr: 218203360
Maurice Ihlow - MNr: 218203150
Frederik Schilling - MNr: 218204061
Emin Heydarzada- MNr: 218100172
Tobias Banke - MNr: 216201267




% ######### Aufgabe 1.a,b #########
male(tom).
male(carl).
male(bob).
male(jim).
male(tim).
female(ann).
female(pam).
female(liz).
female(kira).
female(tina).

parent(tom,bob).
parent(ann,bob).
parent(tom,kira).
parent(ann,kira).
parent(kira,liz).
parent(tim,liz).
parent(kira,pam).
parent(tim,pam).

parent(bob,jim).
parent(liz,jim).

child(X, Y) :- parent(Y, X).
daugther(X,Y) :- female(X), child(X,Y).
son(X,Y) :- male(X), child(X,Y).
brother(X,Y) :- son(X, Z), parent(Z, Y), X \== Y.
sister(X,Y) :- daugther(X,Z), parent(Z, Y), X \== Y.
aunt(X,Y) :- parent(Z, Y), sister(Z,X).
uncle(X,Y) :- parent(Z, Y), brother(Z,X).
grandparent(X,Y) :- parent(Z, Y), child(Z,X).

/*
######### Aufgabe 1.c #########
son(X,tom)
X=bob

child(X,tom).
X= bob
X=kira

daugther(X,ann).
X=kira

brother(X,kira).
X= bob

sister(X,bob).
X = kira

aunt(X, bob).
X=ann

uncle(kira, X).
X=jim

grandparent(X,jim).
X = tom
X = ann
X = kira
X = tim



######### Aufgabe 1.d #########
brother(X,Y).
 | brother(X,Y) :-son(X, Z), parent(Z, Y), X \== Y.
son(X,Z).
 | son(X,Y) :- male(X), child(X,Y).
child(X,Y).
 | child(X,Y) :- parent(Y,X).
parent(X,Y).

sister(X,Y).
 | sister(X,Y) :-dougther(X, Z), parent(Z, Y), X \== Y.
dougther(X,Z).
 | dougther(X,Y) :- female(X), child(X,Y).
child(X,Y).
 | child(X,Y) :- parent(Y,X).
parent(X,Y).

uncle(X,Y)
 | uncle(X,Y) :- parent(Z, Y), brother(Z,X). {Z = X, X = Y}
brother(X,Y).
 | brother(X,Y) :-son(X, Z), parent(Z, Y), X \== Y. {}
son(X,Z).
 | son(X,Y) :- male(X), child(X,Y).
child(X,Y).
 | child(X,Y) :- parent(Y,X).
parent(X,Y).

grandparent(X,Y).
 | grandparent(X,Y) :- parent(Z, Y), child(Z,X).
child(X,Y).
 | child(X,Y) :- parent(Y,X).
parent(X,Y).


######### Aufgabe 2 #########

 parent(Y,jim).
	|
	|
   Y = pat
	|
	|
   parent(X,Y)
	|
	|
   parent(X,pat)
	|
	|
     X = bob

parent(X,Y)

Y = jan		Y = pat		Y = bob		   Y = ann	   Y = liz
|  		    |		    |		        |		   |
|   	    |		    |	    	    |	       |
X = pat		X = bob		X = tom, pam	X = bob	   X = tom 
|   		|		    |     		    |		   |
|___________|___________|_______________|__________|
				    |
				    |
				parent(Y,jim)
				    |
				Y= pat
*/

% ######### Aufgabe 3 #########
on(a,table).
on(b,a).
on(c,b).
on(d,table).
on(e,table).
on(f,e).

above(X,table) :- on(X,_).
above(X,Y) :- on(X,X1), on(Y,Y1), above(X1,Y1).
top(X) :- not(on(_,X)).
bottom(X) :- on(X,table).
tower(X,Y) :- top(X), bottom(Y).


/*
######### Aufgabe 4 #########
4.	a)
	i. 	1. 	X = Z, Z = z
		2.	X = s(z),
			Y = Z
		3.	X = s(s(z)),
			Y = Z, Z = z
		4.	X = s(s(z)),
			Y = z(z),
			Z = s(z(z))
		5.	X = s(s(z)),
			Y = z(z(z)),
			Z = s(s(z(z(z))))

	ii.	1.	Y = Z, Z = z
		2.	Y = z(z),
			Z = s(z(z)
		3.	Y = z(z(z)),
			Z = s(s(z(z(z))))
		4.	Y = z(z(z(z))),
			Z = s(s(s(z(z(z(z))))))
		5.	Y = z(z(z(z(z)))),
			Z = s(s(s(s(z(z(z(z(z))))))))

	iii.	1.	X = s(z),
			Y = s(s(z)) 
		2.	ERROR: Out of global-stack.
			ERROR: No room for exception term.  Aborting.
			% Execution Aborted

Wenn Prolog einen Fehler erkennt, dann benutzt es den anderen Ast. Wenn dieser dann auch zu einem Fehler f�hrt, gibt es einen Error aus.
*/






