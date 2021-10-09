# BullsCows
Bulls and Cows game

Description

Some players need a challenge, so let's make the secret code in the game harder to guess. Add support for more than 10 symbols by adding letters. Now, the secret code can contain the numbers 0-9 and the lowercase Latin characters a-z. The new maximum length for the code is 36. Note that the length of the secret word may not match the number of possible characters in the secret code, so you should request t input twice: once for the secret code length and once for the number of possible characters.

Also, since a secret code is not a number anymore, the symbol 0 should be allowed as the first character in a secret code.

Objectives

In this step, your program should:

Ask for the length of the secret code.
Ask for the range of possible characters in the secret code.
Generate a secret code using numbers and characters. This time, you should also print the secret code using * characters and print which characters were used to generate the secret code.

Function as a fully playable game.

Description

There are a lot of error possibilities. What if someone enters an answer of the wrong length? Or the number of possible symbols is less than the length of the code? What if the answer contains invalid symbols? The game may crash before the secret number was guessed!

Let's handle errors like this. At this point, you can implement this without the try catch construction. Use the following rule of thumb: if you can avoid the exception-based logic, avoid it! If you use exceptions in normal situations, how would you deal with unusual (exceptional) situations? Now it may not seem that important, but when you need to find errors in more complex programs, this makes a difference.

Objectives

In this stage, your program should:

Handle incorrect input.

Print an error message that contains the word error. After that, don't ask for the numbers again, just finish the program.
