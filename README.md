
## Run Locally

Clone the project

```bash
  git clone https://github.com/carklo/PGTest.git
```

Go to the project directory and make sure you have maven installed:

```bash
  mvn -v
```

The target Java version in the pom.xml is Java 11 but this can be downgraded to 8 if needed:
```
  <maven.compiler.source>11</maven.compiler.source>
  <maven.compiler.target>11</maven.compiler.target>
```
At the moment this exercise doesn't have a running code, so the way to check the operation is through the tests

Run the tests

```bash
  mvn clean test
```

