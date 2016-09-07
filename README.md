# insertion-sort

# Описание
Программа сортировки содержимого файла.

Входной файл содержит данные одного из двух видов: целые числа или строки. Данные записаны
в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные
символы.

Результатом работы программы является новый файл с содержимым входного файла,
отсортированным по возрастанию или убыванию. Для сортировки строк используется
лексикографический порядок (по кодам символов).

Реализован алгоритм сортировки методом вставок (Insertion sort) и использован для сортировки содержимого файла.

Входной файл должен содержать малое количество элементов: не больше 100.

# Инструкция

Имя входного, выходного файла, режим сортировки, а так же тип содержимого задаются при
запуске через аргументы командной строки. Примеры запуска из командной строки для Windows:

insertion-sort.exe in.txt out.txt -i -a (для целых чисел по возрастанию)

insertion-sort.exe in.txt out.txt -i -d (для целых чисел по убыванию)

insertion-sort.exe in.txt out.txt -s -a (для строк по возрастанию)

insertion-sort.exe in.txt out.txt -s -d (для строк по убыванию)


in.txt - путь + имя входного файла
out.txt - путь + имя выходного файла
-i / -s - типы содержимого
-a / -d - режимы сортировки