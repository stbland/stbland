@echo off
call mvn -f .\app-parent\pom.xml dependency:list
pause