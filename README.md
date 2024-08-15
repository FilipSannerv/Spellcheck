# Spellcheck

Finds the editing distance between words using dynamic programming with Levenshtein distance. Can be used for autocorrect.

- The input consists of a wordlist, terminated by a "#" sign.
The following part of the input consists of a list of incorrectly spelled words.

- For every incorrectly spelled word the program will return the minimal editing distance in (), along with every word that has the minimal editing distance to the incorrectly spelled word.


 Example input:

```
skål
skålar
skålen
skålens
skålform
#
kål
k
b
sklfrm
skala
```
Example output:
```
kål (1) skål
k (3) skål
b (4) skål
sklfrm (2) skålform
skala (2) skål skålar
```



