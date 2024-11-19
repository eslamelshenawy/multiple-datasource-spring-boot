# Run the Application
`if want to build localization-profile`
### Execute the command to build your application `localization-profile`

````
mvn clean package -P localization-profile
````
### After building, run the packaged JAR file of your application as follows: `localization`
````
java -jar target/FormFieldLocalizationSecurity-0.0.1-SNAPSHOT.jar --spring.profiles.active=localization
````

`if want to build form-profile`

####  Execute the command to build your application `form-profile`

````
mvn clean package -P form-profile
````
#####   After building, run the packaged JAR file of your application as follows: `form`
```` 
java -jar target/FormFieldLocalizationSecurity-0.0.1-SNAPSHOT.jar --spring.profiles.active=form
````


