# prog2-testing

Zuerst compilieren, danach die gesamte Folderstruktur in das Projekt packen, dann sollte man die Klasse mit
`de.uni_hannover.hci.dominik_schneider.testing.Tests` importieren können.


Falls man custom Klassen verwenden will, ist wichtig das sowohl toString und equals überschrieben werden
```
@Override
public String toString() {
  //...
}

public boolean equals() {
  //...
}
```
