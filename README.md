# Multithreading + Distributed Parallel Execution:

Run test via CL:<br>
<code>mvn clean test</code><br>
OR<br>
<code>mvn clean test -DsuiteXmlFile=runner.xml</code><br>
<code>mvn clean test -Dgroups=Regression</code><br>
OR<br>
    - name: Build with Maven
       run: mvn -B package --file pom.xml
       
Note: When running by -Dgroups=Regression, the test will depend on runner1 and runner2.xml as well.

<img src="https://user-images.githubusercontent.com/60035342/187041236-8402a254-eaf9-4bc0-b9ff-d7271f51dda9.png" alt="parallel" width="400" height="400">
