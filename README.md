# Vorgehen zum Übungskomplex

## Aufgabe 3
Zunächst habe ich die Datei im LightMode geöffnet. Anschließend habe ich auf "Access full IDE" geklickt, dann 
über "New Project -> Maven -> Next" navigiert, Projektname & Pfad eingetragen und anschließend auf "Finish" geklickt.

### Anstoßen eines Kompilervorgangs mit Maven
```mvn compile```

### Anstoßen eines Testvorgangs mit Maven
```mvn test-compile```

## Aufgabe 4
Zunächst habe ich die POM-Datei um das Element "dependencies" erweitert und anschließend dieses um ein "dependency" Element, 
für jUnit, erweitert. 

Zusammengefasst ergab sich diese Änderung/Erweiterung in der POM-Datei:
```
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.1</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```
