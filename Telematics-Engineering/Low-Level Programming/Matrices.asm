%include "io64.inc"

section .bss

C resd 16; reserve 16 espacio de dword, el d al final es de dword

section .data ; aqui creo dos matrices A y B que multiplicare

A dd 128, 41, 0,  99

  dd 58,  12, 5,  18

  dd 55,  63, 37, 127

B dd 3, 6 , 2

  dd 7, 28, 9

  dd 8, 2,  7

  dd 9, 42, 0
  
 

section .text

global CMAIN
CMAIN:
    mov rbp, rsp; for correct debugging
    mov ebp, esp; for correct debugging
    ;write your code her
    
 
  
;Inicio loop C 

;variables del loop c                
 mov esi,0 ;esi será el índice de la columna
 mov edi,0 ;edi será el índice de la fila
 mov ebx,0 ;ebx será donde guardaremos la suma 

loop_C:
 
;loop interno de la a y b

;variables del loop con b
 mov ecx,0 ;esi será el índice de la columna
 mov edx,0 ;edi será el índice de la fila
 
 ;variable del loop a
 mov r14,0 ;r13 sera el indice de la columna
 mov r13,0 ;r14 sera el indeice de la fila
 
 ;variable auxiliar
 mov eax,0 ;primer operando de la multiplicacion y donde quedara resultado
 mov ebp,0 ;segundo operando de la multiplicacion y parametro de imul 
 
loop_A:

push rdx
mov eax, dword[B+edx+ecx*4] ;multiplican el índice de la columna
mov ebp, dword[A+r13+r14*4] 
imul ebp; multiplico indices
add ebx,eax ;muevo resultado a variable de suma
pop  rdx
 
inc ecx ;muevo columna de b
add r13,16; muevo fila de a
 
cmp ecx, 3 ;durante 3 ciclos se hace la multiplicacion vectorial.

jl loop_A

mov dword[C+edi+esi*4],ebx; copio resultado de la multiplicacion vectorial a la poscion de la C
mov ebx,0; reinicio sumador
inc esi ;por 4 porque cada elemento ocupa 4 bytes.

mov ecx,0; reinicio columna de b
inc r14 ; muevo columna de a
mov r13,0 ; reinicio fila de a
 
cmp r14,4

jl loop_A
 
add edx,12; muevo fila de b
mov r14,0; reicio columnas de a
mov esi, 0 ;reinicio columnas de c
add edi, 16 ;aumento columnas de c

cmp edi, 64 ;comparamos con 64 bytes tiene una fila. 16 bytes columna * 4 filas
jl loop_A ;hago recorrido por fila
 
 ;fin loop C
    
