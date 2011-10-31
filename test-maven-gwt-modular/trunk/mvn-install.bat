@echo off
call mvn -f .\app-parent\pom.xml -Pdev install
pause
