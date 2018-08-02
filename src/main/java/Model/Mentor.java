package Model;

import BuisnessLogic.Room;

import java.util.ArrayList;
import java.util.List;

public class Mentor extends User{

    private List<Room> roomsAssignToMentor;

    public Mentor(String firstName, String lastName, String login, String password, String email, String role, int userId) {
        super(firstName, lastName, login, password, email, role, userId);
        this.roomsAssignToMentor = new ArrayList<Room>();
    }

    public List<Room> getRoomsAssignToMentor() {
        return roomsAssignToMentor;
    }
}
