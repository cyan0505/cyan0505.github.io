package DAO;

import BuisnessLogic.Quest;
import Connection.DatabaseConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestDAO {

    public void addQuest(Quest quest) throws SQLException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO quest (quest_name, description, coins, isextra)" +
                                                                " values (?, ?, ?, ?)");

        stmt.setString(1, quest.getName());
        stmt.setString(2, quest.getDescription());
        stmt.setInt(3, quest.getReward());
        stmt.setBoolean(4, quest.getExtra());

        stmt.executeUpdate();

    }


    public Quest getQuest(int id) throws SQLException{
        Connection connection = DatabaseConnection.getInstance().getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM quest WHERE id_quest='"+ id + "');");

        ResultSet rs = stmt.executeQuery();

        String questName = rs.getString("quest_name");
        String description = rs.getString("description");
        int coins = rs.getInt("coins");
        boolean isExtra = rs.getBoolean("isextra");
        int questId = rs.getInt("id_quest");


        Quest quest = new Quest(questName, description, coins, isExtra, questId);

        return quest;

    }

    public List<Quest> getListOfQuests() throws SQLException{
        List<Quest> questList = new ArrayList<>();

        Connection connection = DatabaseConnection.getInstance().getConnection();

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM quest;");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {

            String questName = rs.getString("quest_name");
            String description = rs.getString("description");
            int coins = rs.getInt("coins");
            boolean isExtra = rs.getBoolean("isextra");
            int questId = rs.getInt("id_quest");

            Quest quest = new Quest(questName, description, coins, isExtra, questId);

            questList.add(quest);
        }
        return questList;
    }

    public List<List> getNestedQuestList(List<Quest> questList) {
        List<List> listOfLists = new ArrayList<>();

        int size = 3;

        for(int i = 0; i < questList.size(); i += size) {
            int end = Math.min(i + size, questList.size());
            List<Quest> sublist = questList.subList(i, end);
            listOfLists.add(sublist);
        }

        return listOfLists;

    }

}
