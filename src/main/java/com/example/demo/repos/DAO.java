package com.example.demo.repos;

import com.example.demo.models.Friend;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    public List<Friend> getAllFriends(){
        List<Friend> friends = new ArrayList<>();
       Friend b1 = new Friend(1, "Jessica", "Norlindsvägen", "070011119");
        Friend b2 = new Friend(2, "Oscar", "Oscarsvägen", "070011118");
        Friend b3 = new Friend(3, "Julia", "JuliaVägen", "070011117");
        Friend b4 = new Friend(4, "Stefan", "Stefans väg 10", "070011116");
        Friend b5 = new Friend(5, "Crib", "The Crib", "070011115");
        Friend b6 = new Friend(6, "Sara", "Sahara", "070011114");
        Friend b7 = new Friend(7, "Ivona", "Ivory Cost", "070011113");
        friends.add(b1);
        friends.add(b2);
        friends.add(b3);
        friends.add(b4);
        friends.add(b5);
        friends.add(b6);
        friends.add(b7);
        return friends;
    }


}
