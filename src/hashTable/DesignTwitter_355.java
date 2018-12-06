package hashTable;

import java.util.*;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 12/6/18.
 */
public class DesignTwitter_355 {
    Map<Integer, Set<Integer>> follower = new HashMap<>();
    Map<Integer, LinkedList<Tweet>> posts = new HashMap<>();
    int cnt = 0;

    public void postTweet(int userId, int tweetId) {
        if (!follower.containsKey(userId)) follower.put(userId, new HashSet<>());
        follower.get(userId).add(userId);
        if (!posts.containsKey(userId)) posts.put(userId, new LinkedList<>());
        posts.get(userId).addFirst(new Tweet(cnt++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!follower.containsKey(userId)) return new LinkedList<>();
        PriorityQueue<Tweet> feed = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        follower.get(userId).stream()
                .filter(f -> posts.containsKey(f))
                .forEach(f -> posts.get(f).forEach(feed::add));
        List<Integer> res = new LinkedList<>();
        while (feed.size() > 0 && res.size() < 10) res.add(feed.poll().id);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!follower.containsKey(followerId)) follower.put(followerId, new HashSet<>());
        follower.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follower.containsKey(followerId) && followeeId != followerId) follower.get(followerId).remove(followeeId);
    }

    class Tweet {
        int time;
        int id;

        Tweet(int time, int id) {
            this.time = time;
            this.id = id;
        }
    }
}
