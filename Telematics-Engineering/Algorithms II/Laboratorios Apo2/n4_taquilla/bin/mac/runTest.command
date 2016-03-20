# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# $Id$
# Universidad de los Andes (Bogota‡ - Colombia)
# Departamento de Ingenieri’a de Sistemas y Computacio—n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2
# Ejercicio: n4_taquilla
# Autor: Kelvin Guerrero - 11-mar-2013
# Creacion de Script: Juan Sebasti‡an Urrego
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# ---------------------------------------------------------
# Asegura la creaci—on de los directorios classes y lib
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
pwd
java -ea -classpath ../../lib/taquilla.jar:../../test/lib/taquillaTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.PartidoTest
java -ea -classpath ../../lib/taquilla.jar:../../test/lib/taquillaTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.PersonaTest
java -ea -classpath ../../lib/taquilla.jar:../../test/lib/taquillaTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.SillaTest
java -ea -classpath ../../lib/taquilla.jar:../../test/lib/taquillaTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.taquilla.test.TaquillaTest


