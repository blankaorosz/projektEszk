# Projekt eszközök
Projekt eszkozok ELTE IK 2017/18 tavasz


FTDL

Projektünk neve FTDL (Family ToDo List). 
A(z) FTDL webalkalmazás célja a családi élet rendszerezésének megkönnyítése.
A program fejlesztése Java nyelven történik és egy családi todo list-et valósít meg.
Technológiák szempontjából fontos megemlíteni, hogy Spring Boot keretrendszerben íródó, MVC architektúrájú alkalmazás. 
A csapat a Git verziókezelő rendszert választotta a fejlesztési folyamat és a közös munka megkönnyítésére.


FELHASZNÁLÓI DOKUMENTÁCIÓ
--------------------------

Futtatás
----------
Az alábbi programba olyan családok regisztrációját várjuk, akik szeretnék egy helyen látni a teendőiket. Regisztrálnak, majd azzal a felhasználónévvel és jelszóval léphet be az egész család. Felvehetnek feladatokat és megadhatják, hogy kinek szánják azt.

Az alkalmazás főként netbeansben íródott, így használatához a következő lépések szükségesek:

- 1.töltsük le az FTDL (Family Todo List) alkalmazást githubról
- 2.importáljuk netbeans-be
- 3.ha szükségek akkor jobb kattintás az alkalmazáson és "resolve project problems"
- 3.jobb kattintás az alkalmazáson majd clean and build
- 4.jobb kattintás az alkalmazáson majd run
- 5. az alkalmazás elindul a localhost:8080-on

Működés
---------
- 1.Induláskor a user/login url-re kerülünk, ahol be tudunk jelentkezni, amenyiben nincs accountunk a Regsztrációra kell kattintani
- 2.Regisztráció során megadunk egy nevet, egy felhasználónevet és egy jelszót.
- 3.Ez után a login oldalon bejelentkezhetünk
- 4.Innen a todo listához kerülünk, elkezdhetünk létrehozni és menedzselni todokat.

