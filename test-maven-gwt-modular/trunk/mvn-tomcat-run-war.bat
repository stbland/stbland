@echo off
call mvn -f .\app-parent\pom.xml -Pdev tomcat:run-war
pause
