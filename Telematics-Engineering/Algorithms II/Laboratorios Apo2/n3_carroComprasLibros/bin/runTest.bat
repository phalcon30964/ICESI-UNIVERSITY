@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n3_carroComprasLibros
REM Autor: Jorge Jiménez - 23-Jun-2005
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecución de las pruebas
REM ---------------------------------------------------------
cd..
java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.TiendaLibrosTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.LibroTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.ItemCompraTest

java -classpath ./lib/carroLibros.jar;./test/lib/carroLibrosTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.carrocompralibro.test.CarroCompraTest

cd bin