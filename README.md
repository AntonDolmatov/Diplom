# Дипломная работа по курсу "Инженер по тестированию: с 0 до middle"

## Тестирование мобильного приложение "Хоспис"

[Ссылка на задание](https://github.com/netology-code/qamid-diplom)

### Для работы с проектом необходимо: 
- Android Studio
- Allure


### Для запуска тестов:

- Склонировать репозиторий с помощью команды git clone https://github.com/AntonDolmatov/Diplom
- Открыть Android studio
- Открыть склонированный проект, папку fmhandroid
- Дождитесь загрузки Gradle
- Запустить эмулятор Pixel 5 API 29
- Перейти к папке с тестами fmh-android\app\src\androidTest\java\ru\iteco\fmhandroid\ui\tests нажать ПКМ и выбрать Run 'Tests in 'ru.iteco.fmhandroid.ui.test' или комбинацией клавиш Ctrl+Shift+F10

### Для формирования Allure отчетов

- Запустить тесты
- Выгрузить каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора (при помощи Device Manager).
- Перейти в консоли на уровень выше каталога allure-results
- Выполнить команду allure serve
- Дождаться формирования отчета
- Открыть отчеты в браузере