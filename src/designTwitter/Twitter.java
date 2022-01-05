package designTwitter;

import java.util.ArrayList;

/*
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user, and is able to see the 10 most recent tweets 
in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId 
by the user userId. Each call to this function will be made with a unique tweetId.

List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs 
in the user's news feed. Each item in the news feed must be posted by users who 
the user followed or by the user themself. Tweets must be ordered from most 
recent to least recent.

void follow(int followerId, int followeeId) The user with ID followerId started 
following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId 
started unfollowing the user with ID followeeId.

 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {
	Map<Integer, ArrayList<Integer>> followers;
    Map<Integer, ArrayList<Integer>> tweetsMap;
    List<Integer> recentTweets;
    List<Integer> followersList;
    public Twitter() {
        followers = new HashMap<Integer, ArrayList<Integer>>();
        recentTweets = new ArrayList<Integer>();
        tweetsMap = new HashMap<Integer, ArrayList<Integer>>();
        followersList = new ArrayList<Integer>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetsMap.containsKey(userId)){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(tweetId);
            tweetsMap.put(userId, temp);
            recentTweets.add(tweetId);
        }else{
            tweetsMap.get(userId).add(tweetId);
            recentTweets.add(tweetId);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<Integer>();
        List<Integer> p = followers.get(userId);
        List<Integer> personsTweets = new ArrayList<Integer>();
        int count = 0;

        if(p != null){
            for(int i = 0; i < p.size(); i++){
            int id = p.get(i);
            List<Integer> a = tweetsMap.get(id);
            if(a != null && followersList.contains(id)){
                for(int j = a.size() - 1; j >= 0; j--){
                    if(recentTweets.contains(a.get(j)) && !personsTweets.contains(a.get(j))){
                        personsTweets.add(a.get(j));
                    }
                }
            }
        }
        }
        //System.out.println(tweetsMap);
        List<Integer> z = tweetsMap.get(userId);
        if(z != null){
                    for(int i = 0; i < z.size(); i++){
            int id = z.get(i);
            personsTweets.add(z.get(i));
    
        }
        }
    
        int maxIndex = 0;
        List<Integer> indices = new ArrayList<Integer>();
        if(personsTweets.size() == 0){
            return tweets;
        }
        while(true){
            maxIndex = 0;
            for(int i = personsTweets.size() - 1; i >= 0; i--){
                if(recentTweets.indexOf(personsTweets.get(i)) > maxIndex && !indices.contains(recentTweets.indexOf(personsTweets.get(i)))){
                    maxIndex = recentTweets.indexOf(personsTweets.get(i));
                }
            }
            tweets.add(recentTweets.get(maxIndex));
            indices.add(maxIndex);
            if(tweets.size() >= 10 || indices.size() == personsTweets.size()){
                break;
            }
        }

        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(followeeId);
            followers.put(followerId, temp);
            followersList.add(followeeId);
        }else{
            if(followers.get(followerId).indexOf(followeeId) == -1){
                followers.get(followerId).add(followeeId);
                followersList.add(followeeId);
            }
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            if(followers.get(followerId).indexOf(followeeId) >= 0){
                followers.get(followerId).remove(followers.get(followerId).indexOf(followeeId));
            }
        }
    }
}
