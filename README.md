# Articles Hub

Сервис загрузки и хранения статей  
*Тестовое задание АП-софт*

### Описание

Сервис позволяет загружать статьи, хранить и получать  
их в виде структуры заголовков и параграфов.

#### Входной формат
Исходный файл представлен в формате `.txt`. Представляет из себя набор строк с возможными переводами строк в стиле `CRLF`, `CR` и/или `LF`. В начале каждой строки может быть признак начала раздела или подраздела - символ `#`.  

Количество символов `#` в начале строки указывает на уровень вложенности раздела. Если строка не начинается с префикса заголовка, она считается параграфом и имеет уровень вложенности предшествующего заголовка.

Возможно 6 уровней вложенности заголовка. Если строка имеет префикс длиннее, чем префикс заголовка 6 (последнего) уровня, то строка считается таким заголовком, и её текстовое представление включит в себя лишние символы `#`


Пример входного текста:

```
GREATEST MAN IN ALIVE
#Chapter one  
this story about awesome dude that call name is Jack  
##Jack's characteristics  
###height: 71 inch  
###weight: 190 pounds  
#Chapter two  
Jack was most famous man in alive  
his fame was greater than his popularity  
##Jack's patents  
###mosquito net  
###x-ray  
###internal combustion engine
```


<details>
  <summary>Пример разобранной структуры</summary>

```
{
    "successful": true,
    "result": {
        "id": "65ce37b9ddee9f325f14db8d",
        "name": "example",
        "nodes": [
            {
                "lineNumber": 0,
                "content": "GREATEST MAN IN ALIVE",
                "type": "TEXT"
            },
            {
                "lineNumber": 1,
                "content": "Chapter one",
                "type": "H1",
                "children": [
                    {
                        "lineNumber": 2,
                        "content": "this story about awesome dude that call name is Jack",
                        "type": "TEXT"
                    },
                    {
                        "lineNumber": 3,
                        "content": "Jack's characteristics",
                        "type": "H2",
                        "children": [
                            {
                                "lineNumber": 4,
                                "content": "height: 71 inch",
                                "type": "H3"
                            },
                            {
                                "lineNumber": 5,
                                "content": "weight: 190 pounds",
                                "type": "H3"
                            }
                        ]
                    }
                ]
            },
            {
                "lineNumber": 6,
                "content": "Chapter two",
                "type": "H1",
                "children": [
                    {
                        "lineNumber": 7,
                        "content": "Jack was most famous man in alive",
                        "type": "TEXT"
                    },
                    {
                        "lineNumber": 8,
                        "content": "his fame was greater than his popularity",
                        "type": "TEXT"
                    },
                    {
                        "lineNumber": 9,
                        "content": "Jack's patents",
                        "type": "H2",
                        "children": [
                            {
                                "lineNumber": 10,
                                "content": "mosquito net",
                                "type": "H3"
                            },
                            {
                                "lineNumber": 11,
                                "content": "x-ray",
                                "type": "H3"
                            },
                            {
                                "lineNumber": 12,
                                "content": "internal combustion engine",
                                "type": "H3"
                            }
                        ]
                    }
                ]
            }
        ],
        "creationDate": 1708013497263
    }
}
```
</details>

### Запуск
Проект включает в себя серверное приложение, базу данных и фронтенд. Запустить их вместе можно с помощью docker-compose. Файл `docker-compose.yml` находится в корне проекта. [Как использовать docker-compose](https://docs.docker.com/compose/gettingstarted/#step-4-build-and-run-your-app-with-compose)

* URL приложения по умолчанию: [localhost:8181](localhost:8181)
* URL базы данных по умолчанию: [localhost:27017](localhost:27017)
* URL фронденда по умолчанию: [localhost:3000](localhost:3000)

### Использованные технологии
* Spring Framework 6.1.3
* MongoDB 7.0
* ReactJS 18.2.0