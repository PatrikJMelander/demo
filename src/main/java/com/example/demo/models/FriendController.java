package com.example.demo.models;

import com.example.demo.repos.DAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-04-08
 * Time: 14:29
 * Project: demo
 * Copyright: MIT
 */
@RestController
public class FriendController {
    DAO db = new DAO();
    List<Friend> myFriends = db.getAllFriends();

    //Skriver ut hela listan med objekt som JSON
    @RequestMapping("/friends")
    public List<Friend> friends(){
        return myFriends;
    }

    //Letar upp ett objekt med id
    @RequestMapping("/friends/{id}")
    public Friend getFriendById(@PathVariable("id") int id){
        return myFriends.get(id+1);
    }

    //Skriver ut listan med lite html styling
    @RequestMapping("/friendsHTML")
    public StringBuilder friendsWithHTML(){
        StringBuilder send = new StringBuilder();
        send.append("<h3>").append("Namn ").append("Telefonnr").append("</h3>");
        for (Friend f : myFriends) {
            send.append(f.name).append(": ").append(f.phone).append("<br><hr><br>");
        }
        return send;
    }
    //Tar bort objekt ut lista // http://localhost:8080/friends/5/delete tar bort objekt med id 5
    @RequestMapping("/friends/{id}/delete")
    public String deleteFriendById(@PathVariable("id") int id){
        Friend temp = null;

        for (Friend f : myFriends) {
            if (f.id==id){
                temp=f;
            }
        }
            if (!myFriends.contains(temp)) return "Personen finns inte";

            myFriends.removeIf(f -> f.id == id);
            return "Du har tagit bort personen med id: " + id;

    }

    @PostMapping("/friend/add")
    public String addFriend(@RequestBody Friend f){
        myFriends.add(f);
        return "Person tillagd";
    }
    @PostMapping("/friend/addOrUpdate")
    public String addOrUpdateFriend(@RequestBody Friend f){
        for (Friend friend : myFriends) {
            if (f.id == friend.id){
                myFriends.remove(friend);
                myFriends.add(myFriends.indexOf(friend),f);
            }
        }
        return "Person uppdaterad";
    }
}
