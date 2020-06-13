# Втора лабораториска вежба по Софтверско инженерство

## Андреј Сарафимовски, бр. на индекс 141213

## Група на код: 
Ја добив групата на код 2

##  Control Flow Graph

![alt text](https://github.com/MrAndrej20/SI_lab2_141213/blob/master/control-flow-diagram.png?raw=true)

## Цикломатска комплексност

Цикломатската комплексност на овој код е 8.

* Со користење на формулата со бројот на региони, добиваме 8 региони и 8 цикломатска комплексност.

* Со користење на формулата со предикантни јазли, P+1, каде што P е бројот на предикантни јазли. Во случајов P=7, добиваме 8 цикломатска комплексност.

* Со користење на формулата со јазли и гранки, E-N+2, каде што E е бројот на гранки, а N бројот на јазли. Во случајов E=22 и N=16, добиваме 8 цикломатска комплексност.

## Тест случаи според критериумот Multiple condtition 

Според критериумот потребно е да ги истестираме сите разгранувања што имаат повеќе услови.

Имаме 3 такви во нашата функција.

Тест случаевите се:
* За линијата '3' - `user.getUsername() == null || allUsers.contains(user.getUsername())`:

Combination | Branch | Possible Test Case
 --- | --- | ---
TX | 1,3-4 | 1
FT | 1,3-4 | 2
FF | 1,3-5 | 3

* За линијата '11' - `atChar && user.getEmail().charAt(i) == '.'`:

Combination | Branch | Possible Test Case
 --- | --- | ---
FX | 8,9,11,13-14 | 4
TF | 8,9,10,11,13-14 | 5
TT | 8,9,10,11,12,13-15 | 6

* За линијата '13' - `!atChar || !dotChar`:

Combination | Branch | Possible Test Case
 --- | --- | ---
TX | 13-14 | 7
FT | 13-14 | 8
FF | 13-15 | 9

* Сите Случаеви:

Test Case  | User |  username | password | email | userList
 --- | --- | --- | --- | --- | ---
1 | object | null | Test123! | andrej@emailcom | []
2 | object | Andrej | Password123! | andrej-new@emailcom | [ Andrej ]
3 | object | Pero | Pero123! | pero@email.com | [ Andrej ]
4 | object | Antonio | Antonio123! | Antonioemail.com | [ Andrej, Pero ]
5 | object | Antonio | Antonio123! | Antonio@emailcom | [ Andrej, Pero ]
6 | object | Antonio | Antonio123! | Antonio@email.com | [ Andrej, Pero ]
7 | object | Vlado | Vlado123! | vladoemail | [ Andrej, Pero, Antonio ]
8 | object | Vlado | Vlado123! | vlado@email | [ Andrej, Pero, Antonio ]
9 | object | Vlado | Vlado123! | vlado@email.io | [ Andrej, Pero, Antonio ]

## Тест случаи според критериумот Every path

Според критериумот потребно е да ги истестираме сите патеки од кодот.

Тест случаевите се:
Test Case  | User |  username | password | email | userList
 --- | --- | --- | --- | --- | ---
1 | null | | | | []
2 | object | null | Test123! | andrej@emailcom | []
3 | object | Andrej | Test123! | null | []
4 | object | Andrej | Test123! | invalidEmail | []
5 | object | Andrej | Test123! | invalidEmail.si | []
6 | object | Andrej | Test123! | invalidEmail@test | []
7 | object | Andrej | Test123! | invalidEmail@test.si | []
8 | object | Andrej | NewPassword123! | different@email.com | [ Andrej ]


### Објаснување на напишаните unit tests

...
...