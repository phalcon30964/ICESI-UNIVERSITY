@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n1_triangulo
REM Autor: Pablo Barvo - 21-Oct-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

java -classpath ../lib/triangulo.jar;../test/lib/trianguloTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.triangulo.test.ColorTest
java -classpath ../lib/triangulo.jar;../test/lib/trianguloTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.triangulo.test.PuntoTest
java -classpath ../lib/triangulo.jar;../test/lib/trianguloTest.jar;../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.triangulo.test.TrianguloTest