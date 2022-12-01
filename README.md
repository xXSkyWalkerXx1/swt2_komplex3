# Vorgehen zum Übungskomplex

* Autore/n: Philipp Jonscher
* Gruppe: Mittwoch_G3

## Aufgabe 3
Zunächst habe ich die Datei im LightMode geöffnet. Anschließend habe ich auf "Access full IDE" geklickt, dann 
über "New Project -> Maven -> Next" navigiert, Projektname & Pfad eingetragen und anschließend auf "Finish" geklickt.

### Anstoßen eines Kompilervorgangs mit Maven
```mvn compile```

### Anstoßen eines Testvorgangs mit Maven
```mvn test-compile```

## Aufgabe 4
Zunächst habe ich die POM-Datei um das Element _dependencies_ erweitert und anschließend dieses um 2 _dependency_ Elemente, 
für jUnit & AssertJ, erweitert. 

Zusammengefasst ergab sich diese Änderung/Erweiterung in der POM-Datei:
```
<dependencies>
   <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <version>5.9.1</version>
      <scope>test</scope>
   </dependency>
   <dependency>
      <groupId>org.assertj</groupId>
      <artifactId>assertj-core</artifactId>
      <version>3.23.1</version>
      <scope>test</scope>
   </dependency>
</dependencies>
```

## Aufgabe 5
Zur Installation von Jacoco wurde folgendes Element zum _dependencies_ Element hinzugefügt:
```
<dependency>
   <groupId>org.jacoco</groupId>
   <artifactId>jacoco-maven-plugin</artifactId>
   <version>0.8.8</version>
</dependency>
```
Warum kein EclEmma? EclEmma ist nur für Eclipse, während JaCoCo (basierend auf EclEmma) für jede Java-VM basierte Umgebung zugänglich ist (siehe [hier](https://www.jacoco.org/jacoco/trunk/doc/mission.html) und [hier](https://www.jacoco.org/jacoco/trunk/doc/integrations.html)).

### Arten der Abdeckung (siehe [hier](https://www.michael-albrecht.de/tdd/jacoco/) für genaueres)
* Instruktionen/Anweisungen (C0 Coverage)
* Branches (C1 Coverage)
* Codezeilen/Lines, Methoden
* Typen
* Zyklomatische Komplexität.

### Konfiguration
Erweiterung der Jacoco Dependency um folgendes Element:
```
<configuration>
  <argLine>@{argLine} -your -extra -arguments</argLine>
</configuration>
```
Hierbei handelt es sich um den allgemeinen Syntax. Alle möglichen Argumente können [hier]([https://link-url-here.org](https://www.eclemma.org/jacoco/trunk/doc/prepare-agent-mojo.html)) gefunden werden.

Anschließend (in IntelliJ) zu _Run -> Edit Configurations_ navigieren und eine neue Konfiguration erstellen. Dazu auf "+" klicken, _jUnit_ auswählen und JaCoCo als Coverage-Runner auswählen (_Modify Options -> Specify alternative coverage runner_). Die Konfiguration von JaCoCo kann außerdem über das gleiche Fenster (_Modify_) erfolgen.

## Aufgabe 6
1. Neue Klasse, unter _src -> test -> java_ erstellt
2. jUnit in diese Datei importieren:
```
import junit.framework.Assert;
import org.junit.jupiter.api.*;
```
3. Testfälle entwickelt sowie Fehler behoben

### Behobene Fehler

* #### Zeile 35:
```
if (end != null); {end.next = e;}
```
geändert zu
```
if (end != null) {end.next = e;}
```

* #### Zeile 68
```
public E next() {
   current = current.next;
   return current.elem;
}
```
geändert zu
```
public E next() {
   Elem last = current;
   current = current.next;
   return last.elem;
}
```

## Aufgabe 7

Um die Warnungen im Compiler (bei IntelliJ) zu aktivieren:
![](./Images/IntelliJ_Show_Warnings.png)
_(Standardmäßig sollte dies, bei IntelliJ, aktiviert sein)_

Zur Installation von SpotBugs, wie bereits oben beschrieben, folgendes zur _pom.xml_ hinzufügen:
```
<reporting>
   <plugins>
      <plugin>
         <groupId>com.github.spotbugs</groupId>
         <artifactId>spotbugs-maven-plugin</artifactId>
         <version>4.7.3.0</version>
      </plugin>
   </plugins>
</reporting>
```

### Nach Ausführung von SpotBugs:
ToDo: [Maven Fehler fixen](https://github.com/xXSkyWalkerXx1/swt2_komplex3/issues/2)

### Zusatz:
Übrigens, um die Warnungen/Errors/etc. zu beseitigen, gibt es in IntelliJ die Option _Show Quick Fixes_:
![](./Images/IntelliJ_Show_QuickFixes.png)
_(Das Menu erscheint bei dem Glühbirnen-Icon)_

## Aufgabe 8
Zur Demonstration des IntelliJ-Debuggers habe ich die `public static void main(String[] args) {}`-Methode zur `SimpleLinkedList`-Klasse
hinzugefügt. Dieser Schritt ist nötig, um die Anwendung zu debuggen (_alternativ hätte man die Tests debuggen könne_).
Der blaue Balken (_siehe Bild_) kennzeichnet hierbei die nächste Codezeile, die vom Debugger ausgeführt wird.
Zusätzlich habe ich in der Zeile 27 und 29-34 Breakpoints gesetzt, wodurch die Rückgabewerde sowie die Listengröße am Ende der Codezeile angezeigt werden.
Im Variable-View Panel werden letztlich alle *Variablen* der durchlaufenen Codezeilen angezeigt.
![](./Images/Debugging/initial.png)

Im nächsten Schritt (_mit F8_) wird eine Instanz der Klasse erzeugt, zu der später 4 Elemente hinzugefügt werden.
![](./Images/Debugging/step_1.png)

Nun werden 4 Elemente hinzugefügt.
![](./Images/Debugging/step_2.png)
![](./Images/Debugging/step_3.png)
![](./Images/Debugging/step_4.png)
![](./Images/Debugging/step_5.png)

Nach dem letzten Breakpoint habe ich zusätzlich eine Variable hinzugefügt, um ein Abbild der Liste als String zu erhalten.
![](./Images/Debugging/end.png)
