# Decision Service for Admission Intelligence


See (https://admission-intelligence.github.io/admission-intelligence-docs/) for getting started and documentation.


## Technical Details
Run locally with: 
```
mvn clean compile quarkus:dev -Dquarkus.http.port=8081
```

Note: If you want to build a native image from this you need to remove this from the pom:

```
<configuration>
  <uberJar>true</uberJar>
</configuration>
```

Follow this issue for more details:
https://issues.redhat.com/browse/KOGITO-1683
                
            
