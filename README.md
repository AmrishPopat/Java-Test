# Java-Test Deploy Instructions

Preface
1> The GitHub repo contains the target folder too so its easy to download and run without runing mvn clean package/mvn install  
2> This is a spring boot application so do not deploy this on an app server as the jar contains its own tomcat container

Deployment Instructions
1> Download a zip file from the root of the Gib Hub Repo Java-test Branch penguinTest  
2> Extract in your local
3> From "Java-Test-penguinTest" run cmd.exe(on windows) or open command prompt and cd into "Java-Test-penguinTest"
4> run the command "java -jar target\javaTest-0.0.1-SNAPSHOT.jar"
5> Open your favourite web brower and enter url "localhost:8080/books/11" to see the 1st book in the data.json provided
6> Like wise 12, 13, 14 books can be displayed
7> Book 15 has a broken link so looking up for it will result in a message on the page "Book not found" as the data didnt pass validations.
8> Book 16 has missing author name so looking up for it will result in a message on the page "Book not found" as the data didnt pass validations.
7> Any book number apart from the range [11..14] will result in a message on the page "book not found"
8> Any other URL apart from the "localhost:8080/books/{id}" where ID is any string will result in the default whitelabeled error page

Code review instructions
1> To review the code, just import the "Java-Test-penguinTest" folder from the zip in Eclipse as Existing Maven project
2> You can install STS in Eclipse and run the package as Spring boot application 
3> Alternatively run the PenguinTest.java as Java Application
4> Later follow steps from #5 onwards of the above Deployment Instructions to check the functionality of the running application

Resuable component
1> The application is built on Spring boot and Spring MVC to simplify the logic
2> The scalable Validation logic is built into the backend Java code and a single reusable view file can display any valid book. 

Validations
1> Missing values in a give book data will result in not displaying the book
2> Security issue is handled by the validation class by stripping off any instances of opening and closing script tags from the book fields
3> Borken links are checked by the validation class and if found will result in book not being displayed
