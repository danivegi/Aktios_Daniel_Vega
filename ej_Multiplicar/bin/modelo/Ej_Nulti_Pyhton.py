def multiplicar(num1, num2):
    str_num1 = str(num1)
    str_num2 = str(num2)
    filas = len(str_num2)
    columnas = len(str_num1) + filas
    matriz = [[0] * columnas for _ in range(filas)]

    for i in range(filas - 1, -1, -1):
        digito2 = int(str_num2[i])
        acarreo = 0
        fila_actual = filas - 1 - i
        columna = columnas - 1 - fila_actual

        for j in range(len(str_num1) - 1, -1, -1):
            digito1 = int(str_num1[j])
            producto = digito1 * digito2 + acarreo
            matriz[fila_actual][columna] = producto % 10
            acarreo = producto // 10
            columna -= 1

        if acarreo > 0:
            matriz[fila_actual][columna] = acarreo
    
    return sumar_matriz(matriz)

def sumar_matriz(matriz):
    suma_final = 0
    acarreo = 0
    columnas = len(matriz[0])

    for j in range(columnas - 1, -1, -1):
        suma_columna = acarreo
        for fila in matriz:
            suma_columna += fila[j]
        suma_final = suma_columna % 10 + suma_final * 10
        acarreo = suma_columna // 10
    
    return suma_final

if __name__ == "__main__":
    num1 = 4103
    num2 = 254
    print("Resultado:", multiplicar(num1, num2))
