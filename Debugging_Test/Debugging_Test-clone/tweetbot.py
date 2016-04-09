from twython import Twython, TwythonError
import time
#Api info goes here
APP_KEY = 'REDACTED'
APP_SECRET = 'REDACTED'
OAUTH_TOKEN = 'REDACTED'
OAUTH_TOKEN_SECRET = 'REDACTED'
#Use Twython to set up api access to twitter
api = Twython(APP_KEY, APP_SECRET, OAUTH_TOKEN, OAUTH_TOKEN_SECRET)

try:
    #Read the things we need to tweet
    with open('tweets.txt', 'r+') as tweetsfile:
        tweets = tweetsfile.readlines()
    #store list of tweets the bot sends
    tweetList = []
    #loop through all the tweets
    for line in tweets[:]:
        #What are we tweeting
        print ("Trying to tweet " + line)
        #Do simple text tweet validation
        if line[0].isalnum() and len(line) <= 140:
            #Confirm it hasn't already been sent - this is blocked by twitter
            if line not in tweetList:
                #Attempt to send the tweet and update sent list
                api.update_status(status=line)
                tweetList.append(line)
            else:
                print(str(line) + " is a dupe tweet")
        else:
            print(str(line) + " either contains nothing or is too long")
        #Rate limit
        time.sleep(5)
    #Yey it worked
    print("I have tweeted AllTheThings!")

except TwythonError:
    #in case it didn't work
    print("Something Broke :(")
