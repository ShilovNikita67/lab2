@echo off
setlocal enabledelayedexpansion

echo === Компиляция ===
if exist out rmdir /s /q out
mkdir out

dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
if errorlevel 1 (
    echo Ошибка компиляции!
    del sources.txt
    exit /b 1
)
del sources.txt

echo === Сборка JAR ===
jar --create --file lab2.jar --manifest manifest.mf -C out .
if errorlevel 1 (
    echo Ошибка сборки JAR!
    exit /b 1
)

echo === Готово. Запуск ===
java -jar lab2.jar