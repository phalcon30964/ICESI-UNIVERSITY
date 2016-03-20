 %include "io.inc"

section .data

var dd 62h ;vector de datos, tengo que recorrerlo y calcularle el crc a cada byte con el otro codigo

section .text

global CMAIN

CMAIN:

mov ebp, esp; for correct debugging

;write your code here

;REINICIO LOS REGISTROS A UTILIZAR

xor ebx,ebx; el crc8

xor ecx,ecx; el carry 

xor eax,eax; la entrada

xor edx,edx; el contador interno

xor edi,edi; direccion efectiva del vector entrada

xor esi,esi; el contador externo

;TRANSFIERO DIRECCION EFECTIVA DEL ARREGLO DE DATOS

lea edi,[var]; direccion efectiva del arreglo

startFor0:
;10110000
;01100001
mov al,[edi+4*esi]; la entrada

mov cl,al ;uso cl como variable temporal

startCRC:

;Hago xor entre entrada[al] y crc[bl] y roto la entrada una vez.



xor cl,bl ;hago xor entre el crc8 y la entrada

rol cl,1 ;corro una vez para usar el carry

;2 casos de crc
 
jc bit1 ;Si hay carry entonces salta a bit1 , sino ejecute lo que siga

shl bl,1

jmp cont; ejecute y continue codigo

bit1:
rcl bl,1
xor bl,00110000b
;65= 4e 1110  4F  1111

cont:
rol al,1
mov cl,al
inc edx
cmp edx,08

;VUELVO A EJECUTAR SINO SE CUMPLE CONDICION
jnz startCRC

hlt ;para revision de cada iteracion

inc esi

cmp esi,1  ; debe ponerse el numero de palabras a hacer CRC8

jnz startFor0

;hlt ;para revision de una cadena entera

ret