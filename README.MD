# Csiszer Csongor felvételi feladat

* **határidő**: 2019.06.23 23:59:59 (CEST)

## Megvalósítandó feladat leírása
### Autókölcsönző alkalmazás
Egy egyszerű autókölcsönző alkalmazást kell elkészíteni.
Pontozas súlyozása az alábbiak szerint alakul:
* Egy feladatra kapható maximálsi pontszám akkor érhető el, ha a feladat teljes egészében elkészült

* Minden feladatra az adott feladat mellet található pontérték érhető el. 

* **Részpont van!**
 
  **Javaslom:** Inkább a feladatot addig vidd el, amíyg tutod, mint hogy semmit nem csinálsz meg belőle.

* **Nem baj, ha nem megy egy-egy feladat!** 
  _Nem várjuk el tőled, hogy azonnal mindent tudj_ :-) A hozzáállás a lényeg!

#### Publikus felület `max. 150 pont`
##### Feladat leírása
A feleadat egy publikus felület készítése, hogy ahol 

* keresni tud az autók között

* le tudja foglalni az adott autót az adati megadásával. ( :warning: Egy autó ugyanabban az időszakban nem foglalható kétszer.)

##### Megvalósítandó feladatok és pontjaik
_Kereső felület_

 1. Publikus felületen a főoldalon a felhasználó kiválaszt egy valamilyen _daterange picker_-ből egy **_-tól_** és egy **_-ig_** dátumot. (20 pont)

 2. Ekkor elmegy egy kérés a szerver felé. (10 pont)

    A válaszban egy **lista** az abban az időszakban szabad autókról, képpel, napi árral. (30 pont)
 
_Foglalás kezelése_

 3. A kiválasztott autóra kattintva egy felületen megadja az adatait: (50 pont)

    * Név, 

    * email cím, 

    * cím, 

    * telefonszám

    * foglalandó napok száma

    * foglalás teljes összege (a foglalandó napok számától függ!)

 4. Majd egy submit gomb megnyomásával véglegesíti a rendelést. (10 pont)

_Tesztek_ 

 5. min. 50%-os teszt lefedettség (30 pont)

#### AdminUse-case `max. 150 pont`

##### Feladat leírása

Admin felület egy minimális adminisztrációhoz.

* belépő felületre nincs szükség! Az admin adatok jöhetnek akár `config`-ból és automatikusan admin joggal leszünk a `/admin` path-on.

Az admin oldalon szeretnénk 

* látni a foglalásokat egy listában

* szerkeszteni autokat (akár újakat felvenni, deaktiválni **nem törölni!** :)

##### Megvalósítandó feladatok és pontjaik

_Foglalási adatok megjelenítése_

 5. Admin belépés (config-ból), admin jogosultságokkal (20 pont)

 6. Felület ahol láthatjuk a foglalásokat (10 pont)

 7. Folgalásokat kiszolgáló service (20 pont)

_Autók szerkesztése_

 6. Meglévő autók szerkesztése (25p) - képek nélkül

 7. Új autó felvitele (25p)  képek nélül

 8. Képek feltöltésének kezelése a szerkesztés a felvitel felületekhez (20p)

 9. Autók deaktiválása (:warning: meglévő foglalások kezelése!)
  
_Tesztek_

 10. min. 50%-os teszt lefedettség (30p)

#### Bónusz feladatok `max. 50 pont`

 11. Bónuszként egy REST API amivel a szabad autókat le lehet kérdezni és egy fogalást leadni. (20 pont)

 12. Dupla bónusz, docker plugin, docker konténer, adatbázis is külön docker, (20 pont)

 13. Minden a 12.-ik pontban elkészített docker konténer közös hálózatban (10 pont)

### Javasolt technológiai stack:

 * Spring boot 2 

 * Spring mvc 

 * Spring security 

 * Valamilyen adatbázis engine (javasolt PostgreSQL, de lehet bármi más is)

 * Ha ezt elolvasod, küldj egy üzit és kapsz tíz pontot ;)

 * Frontend: 

    * HTML5 

    * Bootstrap vagy Bulma CSS

    * Thymeleaf