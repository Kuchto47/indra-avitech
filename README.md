# Home assignment

## Development / IDE

### Command
Runnable using ```./gradlew run```

### Input arguments
In *build.gradle* file, parameters are set as follows:
- *name* is set on line 33 (eg. *Adam*).
- *path* to csv file is set on line 34

## JAR

### Build
Build JAR using ```./gradlew jar```,

JAR is put into *./build/libs/<jar_name>.jar*

### Run
Run built JAR using ```java -jar <path-to-JAR> <name-of-wallet-owner> <path-to-csv-input-file>```.

Java must be >= JDK 17