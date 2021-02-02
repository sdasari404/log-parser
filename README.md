### Log Parser

- [Problem](PROBLEM.md)
- [Example log data](src/main/resources/example.log)


#### Setup and running the application

- The easiest way to get started is to install via maven
`mvn clean install`
- Package the project `mvn clean package`
- Run the project `mvn exec:java -Dexec.mainClass=digio.main.LogParserDriver`

#### Running unit tests

- `mvn clean test`

#### Assumptions
- Assuming the apache http log format to be consistent, each log line has only one instance of IP address and one url
- The log file being parsed does not have any headers
- Ignoring edge cases caused by multiple IP addresses or urls having the same frequency