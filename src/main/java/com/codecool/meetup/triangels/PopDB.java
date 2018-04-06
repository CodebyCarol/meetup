package com.codecool.meetup.triangels;

import com.codecool.meetup.triangels.model.*;
import com.codecool.meetup.triangels.repository.*;
import com.codecool.meetup.triangels.services.CommentService;
import com.codecool.meetup.triangels.services.EventService;
import com.codecool.meetup.triangels.services.GroupService;
import com.codecool.meetup.triangels.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopDB {

    public PopDB(UserRepo userRepo, EventRepo eventRepo,
                 CommentRepo commentRepo, GroupRepo groupRepo,
                 InterestRepo interestRepo, Utility utility) {

        /*
        //CREATE CLASSES
        User user1 = new User ("Emil", "123", utility.hashPassword("xxx"), "speaker-1.png", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ip");
        User user2 = new User ("Carol", "2", utility.hashPassword("xxx"), "speaker-2.png",  "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ip");
        User user3 = new User ("Tünderella", "5", utility.hashPassword("xxx"), "speaker-3.png",  "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ip");
        User user4 = new User ("Tetris", "123", utility.hashPassword("asdasd"), "ll", "I like to play tetris on my mobile, looking for other tetris lovers, to practice together");
        User user5 = new User ("John Smith", "2", utility.hashPassword("xxx"), "kk",  "Iam John Smith, the real. 36 y/o, doing stuff here and there, mainly there tho");
        User user6 = new User ("xxNinjaWarrior26xx", "xxx", utility.hashPassword("2d"), "kk",  "what can i say... Iam a ninja who likes everything but mainly muffins");
        Group everyOnesGroups = new Group("everyone", "this group is for every single lovely user");
        everyOnesGroups.addUserToGroup(user1);
        everyOnesGroups.addUserToGroup(user2);
        everyOnesGroups.addUserToGroup(user3);
        everyOnesGroups.addUserToGroup(user4);
        everyOnesGroups.addUserToGroup(user5);
        everyOnesGroups.addUserToGroup(user6);
        List<User> eventUsers = new ArrayList<>();
        eventUsers.add(user1);
        eventUsers.add(user2);
        eventUsers.add(user3);

//        Interest interest1 = new Interest("skiing");

        Group group1 = new Group("Geeks",
                "we were born with a keyboard in our hands", user1);
        Group group2 = new Group("Not so Geeks",
                "We are not natural geeks but smart enough", user3);
        Group group3 = new Group("PC MASTERRACE", "this group is for those who want to have events and aint plebs", user1);
        Group group4 = new Group("plebs", "group for us, common folks. We like to do usual common folk stuff", user3);
//        group1.addInterestToGroup(interest1);
        group1.addUserToGroup(user2);

        Event event = new Event("basejump", "basejumping from the top of codecool, will take like 3 sec, but its gonna be awesome",
                "place", "02/21/2019 1:12 PM");


        event.addGroupToEvent(everyOnesGroups);
        Event event1 = new Event("Short ski trip March 15 weekend",
                "this will be a very nice trip, join, moreover if you have a car",
                "Ramsau", "02/21/2019 1:12 PM");
        event1.addGroupToEvent(group3);
        Event event2 = new Event("1st Go-Kart GP",
                "The first Codecool Go-Kart GP in history",
                "Go-Kart-Ring", "02/21/2019 1:12 PM");
        event2.addGroupToEvent(everyOnesGroups);
        //SAVE EM
        event.addUserToEvent(user3);
        event.addGroupToEvent(group1);
        event2.addGroupToEvent(group2);

        Comment comment = new Comment(user1, "asdasdasd", event);

//        event.addInterestToEvent(interest1);
//        event.addInterestToEvent(interest1);

        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);
        userRepo.save(user6);



//                interestRepo.save(interest1);


        groupRepo.save(everyOnesGroups);
        groupRepo.save(group1);
        groupRepo.save(group2);
        groupRepo.save(group3);
        groupRepo.save(group4);


        eventRepo.save(event);
        eventRepo.save(event1);
        eventRepo.save(event2);

        commentRepo.save(comment);

*/

    }


}
