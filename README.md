# sort
[![Build Status](https://drone.io/github.com/DmitryVoronko/insertion-sort/status.png)](https://drone.io/github.com/DmitryVoronko/insertion-sort/latest)
# Описание

## Систеные требования:
- Версия ОС: Windows 7 и выше
- Версия предустановленной Java машины: 1.8

Программа сортировки содержимого файла.

Входной файл содержит данные одного из следующих видов:
- целые числа;
- строки;
- числа с плавающей точкой.

Данные должны быть записаны в столбик (каждая строка файла – новый элемент). Строки могут содержать любые не пробельные символы.

Результатом работы программы является новый файл с содержимым входного файла, отсортированным по возрастанию или убыванию. Для сортировки строк используется лексикографический порядок (по кодам символов).

Реализованы следующие алгоритмы сортировки:
- Методом вставок (Insertion sort)
- Методом выбора (Selection sort)
- Пузырьковая сортировка (Bubble sort)
- Сортировка слиянием (Merge sort)
- Быстрая сортировка (Quick sort)
- Сортировка Шелла (Shell sort)

Входной файл должен содержать малое количество элементов: не больше 100.

# Инструкция

Имя входного, выходного файла, режим сортировки, а так же тип содержимого задаются при
запуске через аргументы командной строки. Примеры запуска из командной строки для Windows:

sort.exe in.txt out.txt -i -a -insert (сортировка методом вставки для целых чисел по возрастанию)

sort.exe in.txt out.txt -i -d -select (сортировка методом выбора для целых чисел по убыванию)

sort.exe in.txt out.txt -s -a -bubble (пузырьковая сортировка для строк по возрастанию)

sort.exe in.txt out.txt -f -d -insert (сортировка методом вставки для числе с плавающей запятой по убыванию)


- in.txt - путь + имя входного файла
- out.txt - путь + имя выходного файла
- -i / -s / -f - типы содержимого
- -a / -d - режимы сортировки
- -insert / -select / -bubble / -merge / -quick / -shell - метод сортировки
