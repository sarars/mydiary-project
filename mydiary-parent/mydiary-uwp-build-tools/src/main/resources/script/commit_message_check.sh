#!/bin/bash

commit_message_check() {

    # Get the current branch and apply it to a variable
    currentbranch=`git branch | grep \* | cut -d ' ' -f2`

      # Gets the commits for the current branch and outputs to file
      git log $currentbranch  --pretty='format:%h'  > ../../resources/script/shafile.txt

# loops through the file an gets the message
for i in `cat ../../resources/script/shafile.txt`;
	do 
# gets the git commit message based on the sha
gitmessage=`git log --format=%s -n 1 "$i"`

####################### TEST STRINGS comment out line 13 to use #########################################
#gitmessage="FEAT: Subject"
#gitmessage="FIX: Subject"
#gitmessage="DOCS: Subject"
#gitmessage="STYLE: Subject"
#gitmessage="REFACTOR: Subject"
#gitmessage="TEST: Subject"
#gitmessage="CHORE: Subject"
#########################################################################################################

# Checks gitmessage for string FEAT, FIX, DOCS, STYLE, REFACTOR, TEST, CHORE, if the messagecheck var is empty if fails
messagecheck=`echo $gitmessage | grep -w "FEAT\FIX\|DOCS\STYLE\REAFCTOR\TEST\|CHORE"`
if [ -z "$messagecheck" ]
then 
	echo "Your commit message must begin with one of the following"
	echo "  FEAT: Subject"
	echo "  FIX: Subject"
	echo "  DOCS: Subject"
	echo "  STYLE: Subject"
	echo "  REFACTOR: Subject"
	echo "  TEST: Subject"
	echo "  CHORE: Subject"
	echo " " 
fi

# All checks run at the same time by pipeing from one grep to another
messagecheck=`echo $gitmessage | grep -w "FEAT\FIX\|DOCS\STYLE\REAFCTOR\TEST\|CHORE"`



# check to see if the messagecheck var is empty
if [ -z "$messagecheck" ]
then  
	echo "The commit message with sha: '$i' failed "
	echo "Please review the following :"
	echo " "
	echo $gitmessage
	echo " "
	rm ../../resources/script/shafile.txt >/dev/null 2>&1
	set -o errexit
else
	echo "$messagecheck"
	echo "'$i' commit message passed"
fi  
done
rm ../../resources/script/shafile.txt  >/dev/null 2>&1
}

# Calling the function
commit_message_check 
