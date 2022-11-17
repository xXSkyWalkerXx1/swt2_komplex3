# Vorgehen zum Übungskomplex

## Aufgabe 3
Zunächst habe ich die Datei im LightMode geöffnet. Anschließend habe ich auf "Access full IDE" geklickt, dann 
über "New Project -> Maven -> Next" navigiert, Projektname & Pfad eingetragen und anschließend auf "Finish" geklickt.

### Anstoßen eines Kompilervorgangs mit Maven
```mvn compile```

### Anstoßen eines Testvorgangs mit Maven
```mvn test-compile```

## Aufgabe 4
Zunächst habe ich die POM-Datei um das Element "dependencies" erweitert und anschließend dieses um 2 "dependency" Elemente, 
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
Zur Installation von Jacoco wurde folgendes Element zum "dependencies" Element hinzugefügt:
```
<dependency>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.8.8</version>
</dependency>
```
Warum kein EclEmma? EclEmma ist nur für Eclipse, während JaCoCo (basierend auf EclEmma) für jede Java-VM basierte Umgebung zugänglich ist (siehe [hier](https://www.jacoco.org/jacoco/trunk/doc/mission.html) und [hier](https://www.jacoco.org/jacoco/trunk/doc/integrations.html)).

### Arten der Abdeckung (siehe [hier](https://www.michael-albrecht.de/tdd/jacoco/) für mehr)
Instruktionen/Anweisungen (C0 Coverage), Branches (C1 Coverage), Codezeilen/Lines, Methoden, Typen und zyklomatischer Komplexität.

### Konfiguration
Erweiterung der Jacoco Dependency um folgendes Element:
```
<configuration>
  <argLine>@{argLine} -your -extra -arguments</argLine>
</configuration>
```
Hierbei handelt es sich um den allgemeinen Syntax. Alle möglichen Argumente können [hier]([https://link-url-here.org](https://www.eclemma.org/jacoco/trunk/doc/prepare-agent-mojo.html)) gefunden werden.

Anschließend (in IntelliJ) zu "Run -> Edit Configurations" navigieren und eine neue Konfiguration erstellen. Dazu auf "+" klicken, "jUnit" auswählen und JaCoCo als Coverage-Runner auswählen ("Modify Options -> Specify alternative coverage runner"). Die Konfiguration von JaCoCo kann außerdem über das gleiche Fenster ("Modify") erfolgen.

## Aufgabe 6
